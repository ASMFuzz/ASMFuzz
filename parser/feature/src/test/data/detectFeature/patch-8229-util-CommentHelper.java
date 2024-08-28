@@ -25,7 +25,6 @@
 
 package jdk.javadoc.internal.doclets.toolkit.util;
 
-import java.util.ArrayList;
 import java.util.List;
 import java.util.stream.Collectors;
 
@@ -578,10 +577,9 @@ public IdentifierTree getName(DocTree dtree) {
 
     public List<? extends DocTree> getTags(DocTree dtree) {
         return new SimpleDocTreeVisitor<List<? extends DocTree>, Void>() {
-            List<? extends DocTree> asList(String content) {
-                List<DocTree> out = new ArrayList<>();
-                out.add(configuration.cmtUtils.makeTextTree(content));
-                return out;
+
+            private List<DocTree> asList(String content) {
+                return List.of(configuration.cmtUtils.makeTextTree(content));
             }
 
             @Override
@@ -611,7 +609,7 @@ public List<? extends DocTree> visitLiteral(LiteralTree node, Void p) {
 
             @Override
             public List<? extends DocTree> visitProvides(ProvidesTree node, Void p) {
-                 return node.getDescription();
+                return node.getDescription();
             }
 
             @Override
@@ -631,7 +629,7 @@ public List<? extends DocTree> visitVersion(VersionTree node, Void p) {
 
             @Override
             public List<? extends DocTree> visitParam(ParamTree node, Void p) {
-               return node.getDescription();
+                return node.getDescription();
             }
 
             @Override
@@ -661,7 +659,7 @@ public List<? extends DocTree> visitSerialField(SerialFieldTree node, Void p) {
 
             @Override
             public List<? extends DocTree> visitThrows(ThrowsTree node, Void p) {
-                 return node.getDescription();
+                return node.getDescription();
             }
 
             @Override
@@ -671,12 +669,12 @@ public List<? extends DocTree> visitUnknownBlockTag(UnknownBlockTagTree node, Vo
 
             @Override
             public List<? extends DocTree> visitUses(UsesTree node, Void p) {
-                 return node.getDescription();
+                return node.getDescription();
             }
 
             @Override
             protected List<? extends DocTree> defaultAction(DocTree node, Void p) {
-               return List.of();
+                return List.of();
             }
         }.visit(dtree, null);
     }