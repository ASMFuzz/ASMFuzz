@@ -30,7 +30,6 @@
 import com.sun.source.doctree.StartElementTree;
 import com.sun.source.util.DocTreeFactory;
 import jdk.javadoc.internal.doclets.formats.html.markup.BodyContents;
-import jdk.javadoc.internal.doclets.formats.html.markup.ContentBuilder;
 import jdk.javadoc.internal.doclets.formats.html.markup.HtmlTree;
 import jdk.javadoc.internal.doclets.toolkit.Content;
 import jdk.javadoc.internal.doclets.toolkit.DocFileElement;
@@ -77,22 +76,23 @@ public DocFilesHandlerImpl(HtmlConfiguration configuration, Element element) {
         this.element = element;
 
         switch (element.getKind()) {
-            case MODULE:
-                ModuleElement mdle = (ModuleElement)element;
+            case MODULE -> {
+                ModuleElement mdle = (ModuleElement) element;
                 location = configuration.utils.getLocationForModule(mdle);
                 source = DocPaths.DOC_FILES;
-                break;
-            case PACKAGE:
-                PackageElement pkg = (PackageElement)element;
+            }
+
+            case PACKAGE -> {
+                PackageElement pkg = (PackageElement) element;
                 location = configuration.utils.getLocationForPackage(pkg);
                 // Note, given that we have a module-specific location,
                 // we want a module-relative path for the source, and not the
                 // standard path that may include the module directory
                 source = DocPath.create(pkg.getQualifiedName().toString().replace('.', '/'))
                         .resolve(DocPaths.DOC_FILES);
-                break;
-            default:
-                throw new AssertionError("unsupported element " + element);
+            }
+
+            default -> throw new AssertionError("unsupported element " + element);
         }
     }
 
@@ -110,25 +110,19 @@ public void copyDocFiles()  throws DocFileIOException {
             if (!srcdir.isDirectory()) {
                 continue;
             }
-            DocPath path = null;
-            switch (this.element.getKind()) {
-                case MODULE:
-                    path = DocPaths.forModule((ModuleElement)this.element);
-                    break;
-                case PACKAGE:
-                    path = configuration.docPaths.forPackage((PackageElement)this.element);
-                    break;
-                default:
-                    throw new AssertionError("unknown kind:" + this.element.getKind());
-            }
+            DocPath path = switch (this.element.getKind()) {
+                case MODULE -> DocPaths.forModule((ModuleElement) this.element);
+                case PACKAGE -> configuration.docPaths.forPackage((PackageElement) this.element);
+                default -> throw new AssertionError("unknown kind:" + this.element.getKind());
+            };
             copyDirectory(srcdir, path.resolve(DocPaths.DOC_FILES), first);
             first = false;
         }
     }
 
     @Override
     public List<DocPath> getStylesheets() throws DocFileIOException {
-        List<DocPath> stylesheets = new ArrayList<DocPath>();
+        var stylesheets = new ArrayList<DocPath>();
         for (DocFile srcdir : DocFile.list(configuration, location, source)) {
             for (DocFile srcFile : srcdir.list()) {
                 if (srcFile.getName().endsWith(".css"))