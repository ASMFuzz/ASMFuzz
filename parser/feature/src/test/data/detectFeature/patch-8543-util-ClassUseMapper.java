@@ -205,7 +205,7 @@ public ClassUseMapper(BaseConfiguration configuration, ClassTree classtree) {
             subclasses(te);
         }
         for (TypeElement intfc : classtree.baseInterfaces()) {
-            // does subinterfacing as side-effect
+            // does subinterfacing as a side-effect
             implementingClasses(intfc);
         }
         // Map methods, fields, constructors using a class.
@@ -221,7 +221,7 @@ public ClassUseMapper(BaseConfiguration configuration, ClassTree classtree) {
             for (VariableElement fd : fields) {
                 mapTypeParameters(classToFieldTypeParam, fd, fd);
                 mapAnnotations(annotationToField, fd, fd);
-                SimpleTypeVisitor9<Void, VariableElement> stv = new SimpleTypeVisitor9<Void, VariableElement>() {
+                var stv = new SimpleTypeVisitor9<Void, VariableElement>() {
                     @Override
                     public Void visitArray(ArrayType t, VariableElement p) {
                         return visit(t.getComponentType(), p);
@@ -232,6 +232,7 @@ public Void visitDeclared(DeclaredType t, VariableElement p) {
                         add(classToField, (TypeElement) t.asElement(), p);
                         return null;
                     }
+
                     @Override
                     public Void visitTypeVariable(TypeVariable t, VariableElement p) {
                         return visit(typeUtils.erasure(t), p);
@@ -252,7 +253,7 @@ public Void visitTypeVariable(TypeVariable t, VariableElement p) {
                 mapExecutable(method);
                 mapTypeParameters(classToMethodTypeParam, method, method);
                 mapAnnotations(classToMethodAnnotations, method, method);
-                SimpleTypeVisitor9<Void, ExecutableElement> stv = new SimpleTypeVisitor9<Void, ExecutableElement>() {
+                var stv = new SimpleTypeVisitor9<Void, ExecutableElement>() {
                     @Override
                     public Void visitArray(ArrayType t, ExecutableElement p) {
                         TypeMirror componentType = t.getComponentType();
@@ -385,7 +386,7 @@ public Void visitTypeVariable(TypeVariable t, ExecutableElement p) {
 
         }
         for (TypeMirror anException : ee.getThrownTypes()) {
-            SimpleTypeVisitor9<Void, ExecutableElement> stv = new SimpleTypeVisitor9<Void, ExecutableElement>() {
+            var stv = new SimpleTypeVisitor9<Void, ExecutableElement>() {
 
                 @Override
                 public Void visitArray(ArrayType t, ExecutableElement p) {
@@ -418,12 +419,7 @@ protected Void defaultAction(TypeMirror e, ExecutableElement p) {
     }
 
     private <T> List<T> refList(Map<TypeElement, List<T>> map, TypeElement element) {
-        List<T> list = map.get(element);
-        if (list == null) {
-            list = new ArrayList<>();
-            map.put(element, list);
-        }
-        return list;
+        return map.computeIfAbsent(element, k -> new ArrayList<>());
     }
 
     private Set<PackageElement> packageSet(TypeElement te) {
@@ -449,9 +445,9 @@ private <T extends Element> void add(Map<TypeElement, List<T>> map, TypeElement
         refList(map, te).add(ref);
         // add ref's package to package map and class map
         packageSet(te).add(elementUtils.getPackageOf(ref));
-        TypeElement entry = (utils.isField((Element) ref)
-                || utils.isConstructor((Element) ref)
-                || utils.isMethod((Element) ref))
+        TypeElement entry = (utils.isField(ref)
+                || utils.isConstructor(ref)
+                || utils.isMethod(ref))
                 ? (TypeElement) ref.getEnclosingElement()
                 : (TypeElement) ref;
         classSet(te).add(entry);
@@ -483,50 +479,49 @@ private void addAll(Map<TypeElement, List<TypeElement>> map, TypeElement te, Col
     private <T extends Element> void mapTypeParameters(final Map<TypeElement, List<T>> map,
             Element element, final T holder) {
 
-        SimpleElementVisitor14<Void, Void> elementVisitor
-                = new SimpleElementVisitor14<Void, Void>() {
+        var elementVisitor = new SimpleElementVisitor14<Void, Void>() {
 
-                    private void addParameters(TypeParameterElement e) {
-                        for (TypeMirror type : utils.getBounds(e)) {
-                            addTypeParameterToMap(map, type, holder);
-                        }
-                    }
+            private void addParameters(TypeParameterElement e) {
+                for (TypeMirror type : utils.getBounds(e)) {
+                    addTypeParameterToMap(map, type, holder);
+                }
+            }
 
-                    @Override
-                    public Void visitType(TypeElement e, Void p) {
-                        for (TypeParameterElement param : e.getTypeParameters()) {
-                            addParameters(param);
-                        }
-                        return null;
-                    }
+            @Override
+            public Void visitType(TypeElement e, Void p) {
+                for (TypeParameterElement param : e.getTypeParameters()) {
+                    addParameters(param);
+                }
+                return null;
+            }
 
-                    @Override
-                    public Void visitExecutable(ExecutableElement e, Void p) {
-                        for (TypeParameterElement param : e.getTypeParameters()) {
-                            addParameters(param);
-                        }
-                        return null;
-                    }
+            @Override
+            public Void visitExecutable(ExecutableElement e, Void p) {
+                for (TypeParameterElement param : e.getTypeParameters()) {
+                    addParameters(param);
+                }
+                return null;
+            }
 
-                    @Override
-                    protected Void defaultAction(Element e, Void p) {
-                        mapTypeParameters(map, e.asType(), holder);
-                        return null;
-                    }
+            @Override
+            protected Void defaultAction(Element e, Void p) {
+                mapTypeParameters(map, e.asType(), holder);
+                return null;
+            }
 
-                    @Override
-                    public Void visitTypeParameter(TypeParameterElement e, Void p) {
-                        addParameters(e);
-                        return null;
-                    }
-                };
+            @Override
+            public Void visitTypeParameter(TypeParameterElement e, Void p) {
+                addParameters(e);
+                return null;
+            }
+        };
         elementVisitor.visit(element);
     }
 
     private <T extends Element> void mapTypeParameters(final Map<TypeElement, List<T>> map,
             TypeMirror aType, final T holder) {
 
-        SimpleTypeVisitor9<Void, Void> tv = new SimpleTypeVisitor9<Void, Void>() {
+        var tv = new SimpleTypeVisitor9<Void, Void>() {
 
             @Override
             public Void visitWildcard(WildcardType t, Void p) {