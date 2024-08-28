@@ -42,7 +42,6 @@
 import com.sun.tools.javac.util.DefinedBy;
 import com.sun.tools.javac.util.DefinedBy.Api;
 import com.sun.tools.javac.util.JCDiagnostic;
-import com.sun.tools.javac.util.Position;
 
 import static com.sun.tools.javac.util.Position.NOPOS;
 
@@ -225,6 +224,14 @@ public int getEndPosition() {
         return NOPOS;
     }
 
+    public boolean isBlank() {
+        return false;
+    }
+
+    public static boolean isBlank(List<? extends DCTree> list) {
+        return list.stream().allMatch(DCTree::isBlank);
+    }
+
     /**
      * Convert a tree to a pretty-printed string.
      */
@@ -1080,6 +1087,41 @@ public TextTree getBody() {
         }
     }
 
+    public static class DCSpec extends DCBlockTag implements SpecTree {
+        public final DCText uri;
+        public final List<DCTree> title;
+
+        DCSpec(DCText uri, List<DCTree> title) {
+            this.uri = uri;
+            this.title = title;
+        }
+
+        @Override
+        public String getTagName() {
+            return "spec";
+        }
+
+        @Override @DefinedBy(Api.COMPILER_TREE)
+        public Kind getKind() {
+            return Kind.SPEC;
+        }
+
+        @Override @DefinedBy(Api.COMPILER_TREE)
+        public <R, D> R accept(DocTreeVisitor<R, D> v, D d) {
+            return v.visitSpec(this, d);
+        }
+
+        @Override @DefinedBy(Api.COMPILER_TREE)
+        public TextTree getURL() {
+            return uri;
+        }
+
+        @Override @DefinedBy(Api.COMPILER_TREE)
+        public List<? extends DocTree> getTitle() {
+            return title;
+        }
+    }
+
     public static class DCStartElement extends DCEndPosTree<DCStartElement> implements StartElementTree {
         public final Name name;
         public final List<DCTree> attrs;
@@ -1170,6 +1212,11 @@ public static class DCText extends DCTree implements TextTree {
             this.text = text;
         }
 
+        @Override
+        public boolean isBlank() {
+            return text.isBlank();
+        }
+
         @Override @DefinedBy(Api.COMPILER_TREE)
         public Kind getKind() {
             return Kind.TEXT;