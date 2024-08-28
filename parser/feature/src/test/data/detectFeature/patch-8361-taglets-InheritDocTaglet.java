@@ -56,39 +56,34 @@ public InheritDocTaglet() {
     }
 
     /**
-     * Given an element, a {@code DocTree} in the element's doc comment
-     * replace all occurrences of {@code {@inheritDoc}} with documentation from its
-     * superclass or superinterface.
+     * Given an element and {@code @inheritDoc} tag in that element's doc comment,
+     * returns the (recursive) expansion of that tag.
+     *
+     * <p>This method does not expand all {@code {@inheritDoc}} tags in the given
+     * element's doc comment. To do this, the method must be called for every
+     * such tag.</p>
      *
      * @param writer the writer that is writing the output.
      * @param e the {@link Element} that we are documenting.
-     *
-     * @param holderTag
-     *
-     * either the tag that holds the {@code {@inheritDoc}} tag or {@code null},
-     * which can mean either of:
-     * <ul>
-     *     <li>the tag is used on a class {@link jdk.javadoc.doclet.Taglet.Location#TYPE} declaration, or
-     *     <li>the tag is used to copy the overall doc comment
-     * </ul>
-     *
+     * @param inheritDoc the {@code {@inheritDoc}} tag
      * @param isFirstSentence true if we only want to inherit the first sentence
      */
     private Content retrieveInheritedDocumentation(TagletWriter writer,
                                                    Element e,
-                                                   DocTree holderTag,
+                                                   DocTree inheritDoc,
                                                    boolean isFirstSentence) {
         Content replacement = writer.getOutputInstance();
         BaseConfiguration configuration = writer.configuration();
         Messages messages = configuration.getMessages();
         Utils utils = configuration.utils;
         CommentHelper ch = utils.getCommentHelper(e);
-        Taglet taglet = holderTag == null
+        var path = ch.getDocTreePath(inheritDoc).getParentPath();
+        DocTree holderTag = path.getLeaf();
+        Taglet taglet = holderTag.getKind() == DocTree.Kind.DOC_COMMENT
                 ? null
                 : configuration.tagletManager.getTaglet(ch.getTagName(holderTag));
         if (taglet != null && !(taglet instanceof InheritableTaglet)) {
             // This tag does not support inheritance.
-            var path = writer.configuration().utils.getCommentHelper(e).getDocTreePath(holderTag);
             messages.warning(path, "doclet.inheritDocWithinInappropriateTag");
             return replacement;
         }
@@ -119,9 +114,7 @@ private Content retrieveInheritedDocumentation(TagletWriter writer,
     }
 
     @Override
-    public Content getInlineTagOutput(Element e, DocTree tag, TagletWriter tagletWriter) {
-        DocTree inheritTag = (tag.getKind() == DocTree.Kind.INHERIT_DOC) ? null : tag;
-        return retrieveInheritedDocumentation(tagletWriter, e,
-                inheritTag, tagletWriter.isFirstSentence);
+    public Content getInlineTagOutput(Element e, DocTree inheritDoc, TagletWriter tagletWriter) {
+        return retrieveInheritedDocumentation(tagletWriter, e, inheritDoc, tagletWriter.isFirstSentence);
     }
 }