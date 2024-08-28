@@ -187,7 +187,7 @@ public Void scan(DocCommentTree tree, TreePath p) {
                     if (isNormalClass(p.getParentPath())) {
                         reportMissing("dc.default.constructor");
                     }
-                } else if (!isOverridingMethod && !isSynthetic() && !isAnonymous()) {
+                } else if (!isOverridingMethod && !isSynthetic() && !isAnonymous() && !isRecordComponentOrField()) {
                     reportMissing("dc.missing.comment");
                 }
                 return null;
@@ -248,26 +248,28 @@ public Void scan(DocCommentTree tree, TreePath p) {
 
         scan(new DocTreePath(p, tree), null);
 
-        if (!isOverridingMethod) {
-            switch (env.currElement.getKind()) {
-                case METHOD:
-                case CONSTRUCTOR: {
-                    ExecutableElement ee = (ExecutableElement) env.currElement;
-                    checkParamsDocumented(ee.getTypeParameters());
-                    checkParamsDocumented(ee.getParameters());
-                    switch (ee.getReturnType().getKind()) {
-                        case VOID:
-                        case NONE:
-                            break;
-                        default:
-                            if (!foundReturn
-                                    && !foundInheritDoc
-                                    && !env.types.isSameType(ee.getReturnType(), env.java_lang_Void)) {
-                                reportMissing("dc.missing.return");
-                            }
+        // the following checks are made after the scan, which will record @param tags
+        if (isDeclaredType()) {
+            TypeElement te = (TypeElement) env.currElement;
+            // checkParamsDocumented(te.getTypeParameters()); // See JDK-8285496
+            checkParamsDocumented(te.getRecordComponents());
+        } else if (isExecutable()) {
+            if (!isOverridingMethod) {
+                ExecutableElement ee = (ExecutableElement) env.currElement;
+                checkParamsDocumented(ee.getTypeParameters());
+                checkParamsDocumented(ee.getParameters());
+                switch (ee.getReturnType().getKind()) {
+                    case VOID, NONE -> {
+                    }
+                    default -> {
+                        if (!foundReturn
+                                && !foundInheritDoc
+                                && !env.types.isSameType(ee.getReturnType(), env.java_lang_Void)) {
+                            reportMissing("dc.missing.return");
+                        }
                     }
-                    checkThrowsDocumented(ee.getThrownTypes());
                 }
+                checkThrowsDocumented(ee.getThrownTypes());
             }
         }
 
@@ -1207,6 +1209,26 @@ private boolean isDefaultConstructor() {
         return false;
     }
 
+    private boolean isDeclaredType() {
+        ElementKind ek = env.currElement.getKind();
+        return ek.isClass() || ek.isInterface();
+    }
+
+    private boolean isExecutable() {
+        ElementKind ek = env.currElement.getKind();
+        return switch (ek) {
+            case CONSTRUCTOR, METHOD -> true;
+            default -> false;
+        };
+    }
+
+    private boolean isRecordComponentOrField() {
+        return env.currElement.getKind() == ElementKind.RECORD_COMPONENT
+            || env.currElement.getEnclosingElement() != null
+                && env.currElement.getEnclosingElement().getKind() == ElementKind.RECORD
+                && env.currElement.getKind() == ElementKind.FIELD;
+    }
+
     private boolean isNormalClass(TreePath p) {
         return switch (p.getLeaf().getKind()) {
             case ENUM, RECORD -> false;