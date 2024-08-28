@@ -35,7 +35,6 @@
 import java.util.ArrayDeque;
 import java.util.ArrayList;
 import java.util.Collection;
-import java.util.Collections;
 import java.util.Deque;
 import java.util.EnumSet;
 import java.util.HashMap;
@@ -643,7 +642,7 @@ public List<? extends TypeMirror> getBounds(TypeParameterElement tpe) {
         if (!bounds.isEmpty()) {
             TypeMirror upperBound = bounds.get(bounds.size() - 1);
             if (ignoreBounds(upperBound)) {
-                return Collections.emptyList();
+                return List.of();
             }
         }
         return bounds;
@@ -764,7 +763,7 @@ public FileObject getFileObject(TypeElement te) {
     }
 
     public TypeMirror getDeclaredType(TypeElement enclosing, TypeMirror target) {
-        return getDeclaredType(Collections.emptyList(), enclosing, target);
+        return getDeclaredType(List.of(), enclosing, target);
     }
 
     /**
@@ -2261,7 +2260,7 @@ public List<? extends DocTree> getBlockTags(Element element) {
     }
 
     public List<? extends DocTree> getBlockTags(DocCommentTree dcTree) {
-        return dcTree == null ? Collections.emptyList() : dcTree.getBlockTags();
+        return dcTree == null ? List.of() : dcTree.getBlockTags();
     }
 
     public List<? extends DocTree> getBlockTags(Element element, Predicate<DocTree> filter) {
@@ -2480,21 +2479,21 @@ public DocCommentTree getDocCommentTree(Element element) {
     public List<? extends DocTree> getPreamble(Element element) {
         DocCommentTree docCommentTree = getDocCommentTree(element);
         return docCommentTree == null
-                ? Collections.emptyList()
+                ? List.of()
                 : docCommentTree.getPreamble();
     }
 
     public List<? extends DocTree> getFullBody(Element element) {
         DocCommentTree docCommentTree = getDocCommentTree(element);
             return (docCommentTree == null)
-                    ? Collections.emptyList()
+                    ? List.of()
                     : docCommentTree.getFullBody();
     }
 
     public List<? extends DocTree> getBody(Element element) {
         DocCommentTree docCommentTree = getDocCommentTree(element);
         return (docCommentTree == null)
-                ? Collections.emptyList()
+                ? List.of()
                 : docCommentTree.getFullBody();
     }
 
@@ -2549,7 +2548,7 @@ public List<? extends UsesTree> getUsesTrees(Element element) {
     public List<? extends DocTree> getFirstSentenceTrees(Element element) {
         DocCommentTree dcTree = getDocCommentTree(element);
         if (dcTree == null) {
-            return Collections.emptyList();
+            return List.of();
         }
         return new ArrayList<>(dcTree.getFirstSentence());
     }
@@ -2649,7 +2648,7 @@ public enum DeclarationPreviewLanguageFeatures {
     public PreviewSummary declaredUsingPreviewAPIs(Element el) {
         if (el.asType().getKind() == ERROR) {
             // Can happen with undocumented --ignore-source-errors option
-            return new PreviewSummary(Collections.emptySet(), Collections.emptySet(), Collections.emptySet());
+            return new PreviewSummary(Set.of(), Set.of(), Set.of());
         }
         List<TypeElement> usedInDeclaration = new ArrayList<>(annotations2Classes(el));
         switch (el.getKind()) {