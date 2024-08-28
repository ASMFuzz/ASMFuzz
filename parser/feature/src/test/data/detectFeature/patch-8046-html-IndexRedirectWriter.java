@@ -25,7 +25,7 @@
 
 package jdk.javadoc.internal.doclets.formats.html;
 
-import java.util.Collections;
+import java.util.List;
 
 import jdk.javadoc.internal.doclets.formats.html.markup.Head;
 import jdk.javadoc.internal.doclets.formats.html.markup.ContentBuilder;
@@ -78,7 +78,7 @@ private void generateIndexFile() throws DocFileIOException {
                 .setTimestamp(!options.noTimestamp())
                 .setDescription("index redirect")
                 .setGenerator(getGenerator(getClass()))
-                .setStylesheets(configuration.getMainStylesheet(), Collections.emptyList()) // avoid reference to default stylesheet
+                .setStylesheets(configuration.getMainStylesheet(), List.of()) // avoid reference to default stylesheet
                 .addDefaultScript(false);
 
         String title = (options.windowTitle().length() > 0)