@@ -2419,7 +2419,7 @@ Symbol findType(Env<AttrContext> env, Name name) {
      *                   (a subset of VAL, TYP, PCK).
      */
     Symbol findIdent(DiagnosticPosition pos, Env<AttrContext> env, Name name, KindSelector kind) {
-        return checkRestrictedType(pos, findIdentInternal(env, name, kind), name);
+        return checkNonExistentType(checkRestrictedType(pos, findIdentInternal(env, name, kind), name));
     }
 
     Symbol findIdentInternal(Env<AttrContext> env, Name name, KindSelector kind) {
@@ -2455,7 +2455,7 @@ Symbol findIdentInternal(Env<AttrContext> env, Name name, KindSelector kind) {
     Symbol findIdentInPackage(DiagnosticPosition pos,
                               Env<AttrContext> env, TypeSymbol pck,
                               Name name, KindSelector kind) {
-        return checkRestrictedType(pos, findIdentInPackageInternal(env, pck, name, kind), name);
+        return checkNonExistentType(checkRestrictedType(pos, findIdentInPackageInternal(env, pck, name, kind), name));
     }
 
     Symbol findIdentInPackageInternal(Env<AttrContext> env, TypeSymbol pck,
@@ -2492,7 +2492,17 @@ Symbol findIdentInPackageInternal(Env<AttrContext> env, TypeSymbol pck,
     Symbol findIdentInType(DiagnosticPosition pos,
                            Env<AttrContext> env, Type site,
                            Name name, KindSelector kind) {
-        return checkRestrictedType(pos, findIdentInTypeInternal(env, site, name, kind), name);
+        return checkNonExistentType(checkRestrictedType(pos, findIdentInTypeInternal(env, site, name, kind), name));
+    }
+
+    private Symbol checkNonExistentType(Symbol symbol) {
+        /*  Guard against returning a type is not on the class path of the current compilation,
+         *  but *was* on the class path of a separate compilation that produced a class file
+         *  that is on the class path of the current compilation. Such a type will fail completion
+         *  but the completion failure may have been silently swallowed (e.g. missing annotation types)
+         *  with an error stub symbol lingering in the symbol tables.
+         */
+        return symbol instanceof ClassSymbol c && c.type.isErroneous() && c.classfile == null ? typeNotFound : symbol;
     }
 
     Symbol findIdentInTypeInternal(Env<AttrContext> env, Type site,