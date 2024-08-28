@@ -366,9 +366,9 @@ protected boolean hasSerializationOverviewTags(VariableElement field) {
         return !output.isEmpty();
     }
 
-    private Content getInlineTagOutput(Element element, DocTree holder, DocTree tree, TagletWriterImpl.Context context) {
+    private Content getInlineTagOutput(Element element, DocTree tree, TagletWriterImpl.Context context) {
         return getTagletWriterInstance(context)
-                .getInlineTagOutput(element, configuration.tagletManager, holder, tree);
+                .getInlineTagOutput(element, configuration.tagletManager, tree);
     }
 
     /**
@@ -1015,7 +1015,7 @@ public Content seeTagToContent(Element element, DocTree see, TagletWriterImpl.Co
 
         boolean isLinkPlain = kind == LINK_PLAIN;
         Content labelContent = plainOrCode(isLinkPlain,
-                commentTagsToContent(see, element, label, context));
+                commentTagsToContent(element, label, context));
 
         // The signature from the @see tag. We will output this text when a label is not specified.
         Content text = plainOrCode(isLinkPlain,
@@ -1370,7 +1370,7 @@ private void addCommentTags(Element element, List<? extends DocTree> tags, boole
             return;
         }
         Content div;
-        Content result = commentTagsToContent(null, element, tags, first, inSummary);
+        Content result = commentTagsToContent(element, tags, first, inSummary);
         if (depr) {
             div = HtmlTree.DIV(HtmlStyle.deprecationComment, result);
             target.add(div);
@@ -1407,65 +1407,56 @@ boolean ignoreNonInlineTag(DocTree dtree) {
     private boolean commentRemoved = false;
 
     /**
-     * Converts inline tags and text to Content, expanding the
+     * Converts inline tags and text to content, expanding the
      * inline tags along the way.  Called wherever text can contain
      * an inline tag, such as in comments or in free-form text arguments
      * to block tags.
      *
-     * @param holderTag    specific tag where comment resides
-     * @param element    specific element where comment resides
-     * @param tags   array of text tags and inline tags (often alternating)
-               present in the text of interest for this element
-     * @param isFirstSentence  true if text is first sentence
+     * @param element         specific element where comment resides
+     * @param tags            list of text trees and inline tag trees (often alternating)
+     * @param isFirstSentence true if text is first sentence
      * @return a Content object
      */
-    public Content commentTagsToContent(DocTree holderTag,
-                                        Element element,
+    public Content commentTagsToContent(Element element,
                                         List<? extends DocTree> tags,
                                         boolean isFirstSentence)
     {
-        return commentTagsToContent(holderTag, element, tags, isFirstSentence, false);
+        return commentTagsToContent(element, tags, isFirstSentence, false);
     }
 
     /**
-     * Converts inline tags and text to text strings, expanding the
+     * Converts inline tags and text to content, expanding the
      * inline tags along the way.  Called wherever text can contain
      * an inline tag, such as in comments or in free-form text arguments
      * to block tags.
      *
-     * @param holderTag       specific tag where comment resides
      * @param element         specific element where comment resides
-     * @param trees           array of text tags and inline tags (often alternating)
-     *                        present in the text of interest for this element
+     * @param trees           list of text trees and inline tag trees (often alternating)
      * @param isFirstSentence true if text is first sentence
      * @param inSummary       if the comment tags are added into the summary section
      * @return a Content object
      */
-    public Content commentTagsToContent(DocTree holderTag,
-                                        Element element,
+    public Content commentTagsToContent(Element element,
                                         List<? extends DocTree> trees,
                                         boolean isFirstSentence,
                                         boolean inSummary) {
-        return commentTagsToContent(holderTag, element, trees,
+        return commentTagsToContent(element, trees,
                 new TagletWriterImpl.Context(isFirstSentence, inSummary));
     }
 
     /**
-     * Converts inline tags and text to text strings, expanding the
+     * Converts inline tags and text to content, expanding the
      * inline tags along the way.  Called wherever text can contain
      * an inline tag, such as in comments or in free-form text arguments
      * to block tags.
      *
-     * @param holderTag specific tag where comment resides
      * @param element   specific element where comment resides
      * @param trees     list of text trees and inline tag trees (often alternating)
-     *                  present in the text of interest for this element
      * @param context   the enclosing context for the trees
      *
      * @return a Content object
      */
-    public Content commentTagsToContent(DocTree holderTag,
-                                        Element element,
+    public Content commentTagsToContent(Element element,
                                         List<? extends DocTree> trees,
                                         TagletWriterImpl.Context context)
     {
@@ -1576,7 +1567,7 @@ private Content copyDocRootContent(Content content) {
 
                 @Override
                 public Boolean visitDocRoot(DocRootTree node, Content c) {
-                    Content docRootContent = getInlineTagOutput(element, holderTag, node, context);
+                    Content docRootContent = getInlineTagOutput(element, node, context);
                     if (c != null) {
                         c.add(docRootContent);
                     } else {
@@ -1620,15 +1611,15 @@ public Boolean visitErroneous(ErroneousTree node, Content c) {
 
                 @Override
                 public Boolean visitInheritDoc(InheritDocTree node, Content c) {
-                    Content output = getInlineTagOutput(element, holderTag, node, context);
+                    Content output = getInlineTagOutput(element, node, context);
                     result.add(output);
                     // if we obtained the first sentence successfully, nothing more to do
                     return (context.isFirstSentence && !output.isEmpty());
                 }
 
                 @Override
                 public Boolean visitIndex(IndexTree node, Content p) {
-                    Content output = getInlineTagOutput(element, holderTag, node, context);
+                    Content output = getInlineTagOutput(element, node, context);
                     if (output != null) {
                         result.add(output);
                     }
@@ -1643,7 +1634,7 @@ public Boolean visitLink(LinkTree node, Content c) {
                         if (dtp != null) {
                             messages.warning(dtp, "doclet.see.nested_link", "{@" + node.getTagName() + "}");
                         }
-                        Content label = commentTagsToContent(node, element, node.getLabel(), context);
+                        Content label = commentTagsToContent(element, node.getLabel(), context);
                         if (label.isEmpty()) {
                             label = Text.of(node.getReference().getSignature());
                         }
@@ -1686,14 +1677,14 @@ public Boolean visitStartElement(StartElementTree node, Content c) {
 
                 @Override
                 public Boolean visitSummary(SummaryTree node, Content c) {
-                    Content output = getInlineTagOutput(element, holderTag, node, context);
+                    Content output = getInlineTagOutput(element, node, context);
                     result.add(output);
                     return false;
                 }
 
                 @Override
                 public Boolean visitSystemProperty(SystemPropertyTree node, Content p) {
-                    Content output = getInlineTagOutput(element, holderTag, node, context);
+                    Content output = getInlineTagOutput(element, node, context);
                     if (output != null) {
                         result.add(output);
                     }
@@ -1726,7 +1717,7 @@ public Boolean visitText(TextTree node, Content c) {
 
                 @Override
                 protected Boolean defaultAction(DocTree node, Content c) {
-                    Content output = getInlineTagOutput(element, holderTag, node, context);
+                    Content output = getInlineTagOutput(element, node, context);
                     if (output != null) {
                         result.add(output);
                     }