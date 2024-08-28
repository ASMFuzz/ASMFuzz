@@ -326,15 +326,12 @@ public Content getBlockTagOutput(TagletManager tagletManager,
      *
      * @param holder        the element associated with the doc comment
      * @param tagletManager the taglet manager for the current doclet
-     * @param holderTag     the tag that holds this inline tag, or {@code null} if
-     *                      there is no tag that holds it
      * @param inlineTag     the inline tag to be documented
      *
      * @return the content, or {@code null}
      */
     public Content getInlineTagOutput(Element holder,
                                       TagletManager tagletManager,
-                                      DocTree holderTag,
                                       DocTree inlineTag) {
 
         Map<String, Taglet> inlineTags = tagletManager.getInlineTaglets();
@@ -346,9 +343,7 @@ public Content getInlineTagOutput(Element holder,
         }
 
         try {
-            Content tagletOutput = t.getInlineTagOutput(holder,
-                    holderTag != null && t.getName().equals("inheritDoc") ? holderTag : inlineTag,
-                    this);
+            Content tagletOutput = t.getInlineTagOutput(holder, inlineTag, this);
             tagletManager.seenTag(t.getName());
             return tagletOutput;
         } catch (UnsupportedTagletOperationException e) {