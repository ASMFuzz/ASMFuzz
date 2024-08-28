@@ -209,7 +209,7 @@ protected Content indexTagOutput(Element element, IndexTree tag) {
                              .replaceAll("\\s+", " ");
         }
 
-        Content desc = htmlWriter.commentTagsToContent(tag, element, tag.getDescription(), context.within(tag));
+        Content desc = htmlWriter.commentTagsToContent(element, tag.getDescription(), context.within(tag));
         String descText = extractText(desc);
 
         return createAnchorAndSearchIndex(element, tagText, descText, tag);
@@ -298,15 +298,15 @@ public Content paramTagOutput(Element element, ParamTree paramTag, String paramN
         body.add(HtmlTree.CODE(defineID ? HtmlTree.SPAN_ID(HtmlIds.forParam(paramName), nameContent) : nameContent));
         body.add(" - ");
         List<? extends DocTree> description = ch.getDescription(paramTag);
-        body.add(htmlWriter.commentTagsToContent(paramTag, element, description, context.within(paramTag)));
+        body.add(htmlWriter.commentTagsToContent(element, description, context.within(paramTag)));
         return HtmlTree.DD(body);
     }
 
     @Override
     public Content returnTagOutput(Element element, ReturnTree returnTag, boolean inline) {
         CommentHelper ch = utils.getCommentHelper(element);
         List<? extends DocTree> desc = ch.getDescription(returnTag);
-        Content content = htmlWriter.commentTagsToContent(returnTag, element, desc , context.within(returnTag));
+        Content content = htmlWriter.commentTagsToContent(element, desc , context.within(returnTag));
         return inline
                 ? new ContentBuilder(contents.getContent("doclet.Returns_0", content))
                 : new ContentBuilder(HtmlTree.DT(contents.returns), HtmlTree.DD(content));
@@ -366,7 +366,7 @@ public Content simpleBlockTagOutput(Element element, List<? extends DocTree> sim
                 body.add(", ");
             }
             List<? extends DocTree> bodyTags = ch.getBody(simpleTag);
-            body.add(htmlWriter.commentTagsToContent(simpleTag, element, bodyTags, context.within(simpleTag)));
+            body.add(htmlWriter.commentTagsToContent(element, bodyTags, context.within(simpleTag)));
             many = true;
         }
         return new ContentBuilder(
@@ -513,7 +513,7 @@ public Content throwsTagOutput(Element element, ThrowsTree throwsTag, TypeMirror
         }
         body.add(HtmlTree.CODE(excName));
         List<? extends DocTree> description = ch.getDescription(throwsTag);
-        Content desc = htmlWriter.commentTagsToContent(throwsTag, element, description, context.within(throwsTag));
+        Content desc = htmlWriter.commentTagsToContent(element, description, context.within(throwsTag));
         if (desc != null && !desc.isEmpty()) {
             body.add(" - ");
             body.add(desc);
@@ -558,7 +558,7 @@ public Content commentTagsToOutput(Element holder,
                                        List<? extends DocTree> tags,
                                        boolean isFirstSentence)
     {
-        return htmlWriter.commentTagsToContent(holderTag, holder,
+        return htmlWriter.commentTagsToContent(holder,
                 tags, holderTag == null ? context : context.within(holderTag));
     }
 