@@ -22,6 +22,7 @@
  * or visit www.oracle.com if you need additional information or have any
  * questions.
  */
+
 package jdk.javadoc.internal.doclets.formats.html;
 
 import java.util.ArrayList;
@@ -85,6 +86,7 @@ public enum PageMode {
         CONSTANT_VALUES,
         DEPRECATED,
         DOC_FILE,
+        EXTERNAL_SPECS,
         HELP,
         INDEX,
         MODULE,
@@ -316,6 +318,7 @@ private void addMainNavLinks(Content target) {
             case ALL_CLASSES:
             case ALL_PACKAGES:
             case CONSTANT_VALUES:
+            case EXTERNAL_SPECS:
             case SERIALIZED_FORM:
             case SEARCH:
             case SYSTEM_PROPERTIES: