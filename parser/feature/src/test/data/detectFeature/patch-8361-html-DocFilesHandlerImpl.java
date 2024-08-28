@@ -199,13 +199,13 @@ private void handleHtmlFile(DocFile srcfile, DocPath dstPath) throws DocFileIOEx
         HtmlDocletWriter docletWriter = new DocFileWriter(configuration, dfilePath, element, pkg);
 
         List<? extends DocTree> localTags = getLocalHeaderTags(utils.getPreamble(dfElement));
-        Content localTagsContent = docletWriter.commentTagsToContent(null, dfElement, localTags, false);
+        Content localTagsContent = docletWriter.commentTagsToContent(dfElement, localTags, false);
 
         String title = getWindowTitle(docletWriter, dfElement).trim();
         HtmlTree htmlContent = docletWriter.getBody(title);
 
         List<? extends DocTree> fullBody = utils.getFullBody(dfElement);
-        Content pageContent = docletWriter.commentTagsToContent(null, dfElement, fullBody, false);
+        Content pageContent = docletWriter.commentTagsToContent(dfElement, fullBody, false);
         docletWriter.addTagsInfo(dfElement, pageContent);
 
         htmlContent.add(new BodyContents()