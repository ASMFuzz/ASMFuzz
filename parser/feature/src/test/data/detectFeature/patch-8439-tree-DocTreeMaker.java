@@ -76,6 +76,7 @@
 import com.sun.tools.javac.tree.DCTree.DCSerialField;
 import com.sun.tools.javac.tree.DCTree.DCSince;
 import com.sun.tools.javac.tree.DCTree.DCSnippet;
+import com.sun.tools.javac.tree.DCTree.DCSpec;
 import com.sun.tools.javac.tree.DCTree.DCStartElement;
 import com.sun.tools.javac.tree.DCTree.DCSummary;
 import com.sun.tools.javac.tree.DCTree.DCSystemProperty;
@@ -89,9 +90,7 @@
 import com.sun.tools.javac.util.Context;
 import com.sun.tools.javac.util.DefinedBy;
 import com.sun.tools.javac.util.DefinedBy.Api;
-import com.sun.tools.javac.util.DiagnosticSource;
 import com.sun.tools.javac.util.JCDiagnostic;
-import com.sun.tools.javac.util.JCDiagnostic.DiagnosticPosition;
 import com.sun.tools.javac.util.ListBuffer;
 import com.sun.tools.javac.util.Pair;
 import com.sun.tools.javac.util.Position;
@@ -124,7 +123,7 @@ public static DocTreeMaker instance(Context context) {
 
     /** The position at which subsequent trees will be created.
      */
-    public int pos = Position.NOPOS;
+    public int pos;
 
     private final JavacTrees trees;
 
@@ -238,9 +237,8 @@ public boolean isDeprecated() {
             }
         };
         Pair<List<DCTree>, List<DCTree>> pair = splitBody(fullBody);
-        DCDocComment tree = new DCDocComment(c, fBody, pair.fst, pair.snd, cast(tags),
+        return new DCDocComment(c, fBody, pair.fst, pair.snd, cast(tags),
                                              cast(preamble), cast(postamble));
-        return tree;
     }
 
     @Override @DefinedBy(Api.COMPILER_TREE)
@@ -421,6 +419,13 @@ public DCSnippet newSnippetTree(List<? extends DocTree> attributes, TextTree tex
         return tree;
     }
 
+    @Override @DefinedBy(Api.COMPILER_TREE)
+    public DCSpec newSpecTree(TextTree url, List<? extends DocTree> title) {
+        DCSpec tree = new DCSpec((DCText) url, cast(title));
+        tree.pos = pos;
+        return tree;
+    }
+
     @Override @DefinedBy(Api.COMPILER_TREE)
     public DCStartElement newStartElementTree(Name name, List<? extends DocTree> attrs, boolean selfClosing) {
         DCStartElement tree = new DCStartElement(name, cast(attrs), selfClosing);