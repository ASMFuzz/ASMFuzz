@@ -29,10 +29,10 @@
 import java.util.List;
 
 import jdk.javadoc.internal.doclets.toolkit.util.DocPath;
+
 /**
  * The interface for copying doc-files to the output.
  */
-
 public interface DocFilesHandler {
     void copyDocFiles() throws DocletException;
     List<DocPath> getStylesheets() throws DocletException;