@@ -35,10 +35,11 @@
 import com.sun.tools.javac.code.Symbol.BindingSymbol;
 import com.sun.tools.javac.code.Symbol.ClassSymbol;
 import com.sun.tools.javac.code.Symbol.DynamicMethodSymbol;
-import com.sun.tools.javac.code.Symbol.DynamicVarSymbol;
 import com.sun.tools.javac.code.Symbol.VarSymbol;
 import com.sun.tools.javac.code.Symtab;
-import com.sun.tools.javac.code.Type;
+import com.sun.tools.javac.code.Type.ClassType;
+import com.sun.tools.javac.code.Type.MethodType;
+import com.sun.tools.javac.code.Type.WildcardType;
 import com.sun.tools.javac.code.Types;
 import com.sun.tools.javac.tree.JCTree.JCAssign;
 import com.sun.tools.javac.tree.JCTree.JCBinary;
@@ -63,16 +64,14 @@
 import com.sun.tools.javac.util.Names;
 import com.sun.tools.javac.util.Options;
 
-import java.util.Collection;
-import java.util.LinkedHashMap;
+import java.util.HashMap;
 import java.util.Map;
 import java.util.Map.Entry;
+import java.util.LinkedHashMap;
 
 import com.sun.tools.javac.code.Symbol.MethodSymbol;
-import com.sun.tools.javac.code.Type.ClassType;
-import com.sun.tools.javac.code.Type.MethodType;
-import com.sun.tools.javac.code.Type.WildcardType;
-import com.sun.tools.javac.code.TypeTag;
+import com.sun.tools.javac.code.Symbol.RecordComponent;
+import com.sun.tools.javac.code.Type;
 import static com.sun.tools.javac.code.TypeTag.BOT;
 import com.sun.tools.javac.jvm.PoolConstant.LoadableConstant;
 import com.sun.tools.javac.jvm.Target;
@@ -86,15 +85,17 @@
 import com.sun.tools.javac.tree.JCTree.JCDoWhileLoop;
 import com.sun.tools.javac.tree.JCTree.JCFieldAccess;
 import com.sun.tools.javac.tree.JCTree.JCLambda;
+import com.sun.tools.javac.tree.JCTree.JCMethodInvocation;
+import com.sun.tools.javac.tree.JCTree.JCNewClass;
 import com.sun.tools.javac.tree.JCTree.JCParenthesizedPattern;
 import com.sun.tools.javac.tree.JCTree.JCPattern;
+import com.sun.tools.javac.tree.JCTree.JCRecordPattern;
 import com.sun.tools.javac.tree.JCTree.JCStatement;
 import com.sun.tools.javac.tree.JCTree.JCSwitchExpression;
 import com.sun.tools.javac.tree.JCTree.LetExpr;
 import com.sun.tools.javac.tree.TreeInfo;
 import com.sun.tools.javac.util.Assert;
 import com.sun.tools.javac.util.List;
-import java.util.Iterator;
 
 /**
  * This pass translates pattern-matching constructs, such as instanceof <pattern>.
@@ -164,8 +165,11 @@ boolean tryPrepend(BindingSymbol binding, JCVariableDecl var) {
     boolean debugTransPatterns;
 
     private ClassSymbol currentClass = null;
+    private JCClassDecl currentClassTree = null;
+    private ListBuffer<JCTree> pendingMethods = null;
     private MethodSymbol currentMethodSym = null;
     private VarSymbol currentValue = null;
+    private Map<RecordComponent, MethodSymbol> component2Proxy = null;
 
     protected TransPatterns(Context context) {
         context.put(transPatternsKey, this);
@@ -254,6 +258,131 @@ public void visitParenthesizedPattern(JCParenthesizedPattern tree) {
         result = translate(tree.pattern);
     }
 
+    @Override
+    public void visitRecordPattern(JCRecordPattern tree) {
+        //type test already done, finish handling of deconstruction patterns ("T(PATT1, PATT2, ...)")
+        //=>
+        //<PATT1-handling> && <PATT2-handling> && ...
+        List<? extends RecordComponent> components = tree.record.getRecordComponents();
+        List<? extends Type> nestedFullComponentTypes = tree.fullComponentTypes;
+        List<? extends JCPattern> nestedPatterns = tree.nested;
+        JCExpression test = null;
+        while (components.nonEmpty() && nestedFullComponentTypes.nonEmpty() && nestedPatterns.nonEmpty()) {
+            //PATTn for record component COMPn of type Tn;
+            //PATTn is a type test pattern or a deconstruction pattern:
+            //=>
+            //(let Tn $c$COMPn = ((T) N$temp).COMPn(); <PATTn extractor>)
+            //or
+            //(let Tn $c$COMPn = ((T) N$temp).COMPn(); $c$COMPn != null && <PATTn extractor>)
+            //or
+            //(let Tn $c$COMPn = ((T) N$temp).COMPn(); $c$COMPn instanceof T' && <PATTn extractor>)
+            RecordComponent component = components.head;
+            JCPattern nested = nestedPatterns.head;
+            VarSymbol nestedTemp = new VarSymbol(Flags.SYNTHETIC,
+                names.fromString(target.syntheticNameChar() + "c" + target.syntheticNameChar() + component.name),
+                                 component.erasure(types),
+                                 currentMethodSym);
+            Symbol accessor = getAccessor(component);
+            JCVariableDecl nestedTempVar =
+                    make.VarDef(nestedTemp,
+                                make.App(make.QualIdent(accessor),
+                                         List.of(convert(make.Ident(currentValue), tree.type))));
+            JCExpression extracted;
+            VarSymbol prevCurrentValue = currentValue;
+            try {
+                currentValue = nestedTemp;
+                extracted = (JCExpression) this.<JCTree>translate(nested);
+            } finally {
+                currentValue = prevCurrentValue;
+            }
+            JCExpression extraTest = null;
+            if (!types.isAssignable(nestedTemp.type, nested.type)) {
+                if (!types.isAssignable(nestedFullComponentTypes.head, nested.type)) {
+                    extraTest = makeTypeTest(make.Ident(nestedTemp),
+                                             make.Type(nested.type));
+                }
+            } else if (nested.type.isReference() && nested.hasTag(Tag.RECORDPATTERN)) {
+                extraTest = makeBinary(Tag.NE, make.Ident(nestedTemp), makeNull());
+            }
+            if (extraTest != null) {
+                extracted = makeBinary(Tag.AND, extraTest, extracted);
+            }
+            LetExpr getAndRun = make.LetExpr(nestedTempVar, extracted);
+            getAndRun.needsCond = true;
+            getAndRun.setType(syms.booleanType);
+            if (test == null) {
+                test = getAndRun;
+            } else {
+                test = makeBinary(Tag.AND, test, getAndRun);
+            }
+            components = components.tail;
+            nestedFullComponentTypes = nestedFullComponentTypes.tail;
+            nestedPatterns = nestedPatterns.tail;
+        }
+
+        if (tree.var != null) {
+            BindingSymbol binding = (BindingSymbol) tree.var.sym;
+            Type castTargetType = principalType(tree);
+            VarSymbol bindingVar = bindingContext.bindingDeclared(binding);
+
+            JCAssign fakeInit =
+                    (JCAssign) make.at(TreeInfo.getStartPos(tree))
+                                   .Assign(make.Ident(bindingVar),
+                                           convert(make.Ident(currentValue), castTargetType))
+                                   .setType(bindingVar.erasure(types));
+            LetExpr nestedLE = make.LetExpr(List.of(make.Exec(fakeInit)),
+                                            make.Literal(true));
+            nestedLE.needsCond = true;
+            nestedLE.setType(syms.booleanType);
+            test = test != null ? makeBinary(Tag.AND, test, nestedLE) : nestedLE;
+        }
+
+        Assert.check(components.isEmpty() == nestedPatterns.isEmpty());
+        Assert.check(components.isEmpty() == nestedFullComponentTypes.isEmpty());
+        result = test != null ? test : makeLit(syms.booleanType, 1);
+    }
+
+    private MethodSymbol getAccessor(RecordComponent component) {
+        return component2Proxy.computeIfAbsent(component, c -> {
+            MethodSymbol realAccessor = (MethodSymbol) component.owner
+                                                 .members()
+                                                 .findFirst(component.name, s -> s.kind == Kind.MTH &&
+                                                                                 ((MethodSymbol) s).params.isEmpty());
+            MethodType type = new MethodType(List.of(component.owner.erasure(types)),
+                                             types.erasure(component.type),
+                                             List.nil(),
+                                             syms.methodClass);
+            MethodSymbol proxy = new MethodSymbol(Flags.STATIC | Flags.SYNTHETIC,
+                                                  names.fromString("$proxy$" + component.name),
+                                                  type,
+                                                  currentClass);
+            JCStatement accessorStatement =
+                    make.Return(make.App(make.Select(make.Ident(proxy.params().head), realAccessor)));
+            VarSymbol ctch = new VarSymbol(Flags.SYNTHETIC,
+                    names.fromString("catch" + currentClassTree.pos + target.syntheticNameChar()),
+                    syms.throwableType,
+                    currentMethodSym);
+            JCNewClass newException = makeNewClass(syms.matchExceptionType,
+                                                   List.of(makeApply(make.Ident(ctch),
+                                                                     names.toString,
+                                                                     List.nil()),
+                                                           make.Ident(ctch)));
+            JCTree.JCCatch catchClause = make.Catch(make.VarDef(ctch, null),
+                                                    make.Block(0, List.of(make.Throw(newException))));
+            JCStatement tryCatchAll = make.Try(make.Block(0, List.of(accessorStatement)),
+                                               List.of(catchClause),
+                                               null);
+            JCMethodDecl md = make.MethodDef(proxy,
+                                             proxy.externalType(types),
+                                             make.Block(0, List.of(tryCatchAll)));
+
+            pendingMethods.append(md);
+            currentClass.members().enter(proxy);
+
+            return proxy;
+        });
+    }
+
     @Override
     public void visitSwitch(JCSwitch tree) {
         handleSwitch(tree, tree.selector, tree.cases,
@@ -480,6 +609,25 @@ private void handleSwitch(JCTree tree,
         }
     }
 
+    JCMethodInvocation makeApply(JCExpression selector, Name name, List<JCExpression> args) {
+        MethodSymbol method = rs.resolveInternalMethod(
+                currentClassTree.pos(), env,
+                selector.type, name,
+                TreeInfo.types(args), List.nil());
+        JCMethodInvocation tree = make.App( make.Select(selector, method), args)
+                                      .setType(types.erasure(method.getReturnType()));
+        return tree;
+    }
+
+    JCNewClass makeNewClass(Type ctype, List<JCExpression> args) {
+        JCNewClass tree = make.NewClass(null,
+            null, make.QualIdent(ctype.tsym), args, null);
+        tree.constructor = rs.resolveConstructor(
+            currentClassTree.pos(), this.env, ctype, TreeInfo.types(args), List.nil());
+        tree.type = ctype;
+        return tree;
+    }
+
     private Type principalType(JCTree p) {
         return types.boxedTypeOrType(types.erasure(TreeInfo.primaryPatternType(p)));
     }
@@ -659,14 +807,24 @@ public void visitLambda(JCLambda tree) {
     @Override
     public void visitClassDef(JCClassDecl tree) {
         ClassSymbol prevCurrentClass = currentClass;
+        JCClassDecl prevCurrentClassTree = currentClassTree;
+        ListBuffer<JCTree> prevPendingMethods = pendingMethods;
         MethodSymbol prevMethodSym = currentMethodSym;
+        Map<RecordComponent, MethodSymbol> prevAccessor2Proxy = component2Proxy;
         try {
             currentClass = tree.sym;
+            currentClassTree = tree;
+            pendingMethods = new ListBuffer<>();
             currentMethodSym = null;
+            component2Proxy = new HashMap<>();
             super.visitClassDef(tree);
+            tree.defs = tree.defs.prependList(pendingMethods.toList());
         } finally {
             currentClass = prevCurrentClass;
+            currentClassTree = prevCurrentClassTree;
+            pendingMethods = prevPendingMethods;
             currentMethodSym = prevMethodSym;
+            component2Proxy = prevAccessor2Proxy;
         }
     }
 
@@ -862,4 +1020,10 @@ VarSymbol bindingDeclared(BindingSymbol varSymbol) {
     JCExpression makeLit(Type type, Object value) {
         return make.Literal(type.getTag(), value).setType(type.constType(value));
     }
+
+    /** Make an attributed tree representing null.
+     */
+    JCExpression makeNull() {
+        return makeLit(syms.botType, null);
+    }
 }