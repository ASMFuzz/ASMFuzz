@@ -26,7 +26,6 @@
 package jdk.javadoc.internal.doclets.formats.html;
 
 import java.util.ArrayList;
-import java.util.Collections;
 import java.util.Comparator;
 import java.util.EnumSet;
 import java.util.HashMap;
@@ -411,7 +410,7 @@ public void printHtmlDocument(List<String> metakeywords,
                                   String description,
                                   Content body)
             throws DocFileIOException {
-        printHtmlDocument(metakeywords, description, new ContentBuilder(), Collections.emptyList(), body);
+        printHtmlDocument(metakeywords, description, new ContentBuilder(), List.of(), body);
     }
 
     /**