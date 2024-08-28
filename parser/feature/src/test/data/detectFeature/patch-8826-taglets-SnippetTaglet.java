@@ -230,7 +230,7 @@ private Content generateContent(Element holder, DocTree tag, TagletWriter writer
                 }
             } catch (IOException | IllegalArgumentException e) { // TODO: test this when JDK-8276892 is integrated
                 // JavaFileManager.getFileForInput can throw IllegalArgumentException in certain cases
-                throw new BadSnippetException(a, "doclet.exception.read.file", v, e.getCause());
+                throw new BadSnippetException(a, "doclet.exception.read.file", v, e);
             }
 
             if (fileObject == null) {
@@ -242,7 +242,7 @@ private Content generateContent(Element holder, DocTree tag, TagletWriter writer
                 externalContent = fileObject.getCharContent(true).toString();
             } catch (IOException e) {  // TODO: test this when JDK-8276892 is integrated
                 throw new BadSnippetException(a, "doclet.exception.read.file",
-                        fileObject.getName(), e.getCause());
+                        fileObject.getName(), e);
             }
         }
 