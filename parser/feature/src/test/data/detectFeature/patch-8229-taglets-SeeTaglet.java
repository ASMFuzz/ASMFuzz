@@ -52,7 +52,7 @@ public SeeTaglet() {
     public void inherit(DocFinder.Input input, DocFinder.Output output) {
         List<? extends SeeTree> tags = input.utils.getSeeTrees(input.element);
         if (!tags.isEmpty()) {
-            CommentHelper ch =  input.utils.getCommentHelper(input.element);
+            CommentHelper ch = input.utils.getCommentHelper(input.element);
             output.holder = input.element;
             output.holderTag = tags.get(0);
             output.inlineTags = input.isFirstSentence