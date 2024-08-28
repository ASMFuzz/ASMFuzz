@@ -38,7 +38,6 @@
 import javax.tools.Diagnostic;
 import javax.tools.DocumentationTool.Location;
 import javax.tools.FileObject;
-import javax.tools.JavaFileManager;
 
 import com.sun.source.doctree.AttributeTree;
 import com.sun.source.doctree.DocTree;
@@ -215,14 +214,14 @@ private Content generateContent(Element holder, DocTree tag, TagletWriter writer
             // we didn't create JavaFileManager, so we won't close it; even if an error occurs
             var fileManager = writer.configuration().getFileManager();
 
-            // first, look in local snippet-files subdirectory
-            Utils utils = writer.configuration().utils;
-            PackageElement pkg = getPackageElement(holder, utils);
-            JavaFileManager.Location l = utils.getLocationForPackage(pkg);
-            String relativeName = "snippet-files/" + v;
-            String packageName = packageName(pkg, utils);
             try {
-                fileObject = fileManager.getFileForInput(l, packageName, relativeName);
+                // first, look in local snippet-files subdirectory
+                var utils = writer.configuration().utils;
+                var pkg = getPackageElement(holder, utils);
+                var pkgLocation = utils.getLocationForPackage(pkg);
+                var pkgName = pkg.getQualifiedName().toString(); // note: empty string for unnamed package
+                var relativeName = "snippet-files/" + v;
+                fileObject = fileManager.getFileForInput(pkgLocation, pkgName, relativeName);
 
                 // if not found in local snippet-files directory, look on snippet path
                 if (fileObject == null && fileManager.hasLocation(Location.SNIPPET_PATH)) {
@@ -409,10 +408,6 @@ private Content badSnippet(TagletWriter writer, Optional<String> details) {
         return writer.invalidTagOutput(resources.getText("doclet.tag.invalid", "snippet"), details);
     }
 
-    private String packageName(PackageElement pkg, Utils utils) {
-        return utils.getPackageName(pkg);
-    }
-
     private static PackageElement getPackageElement(Element e, Utils utils) {
         if (e instanceof DocletElement de) {
             return de.getPackageElement();