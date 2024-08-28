@@ -25,6 +25,7 @@
 
 package jdk.javadoc.internal.doclets.formats.html;
 
+import java.net.URI;
 import java.util.ArrayList;
 import java.util.Comparator;
 import java.util.EnumSet;
@@ -2176,4 +2177,19 @@ private Content withLinks(String key, String className, Set<TypeElement> element
                                    HtmlTree.CODE(Text.of(className)),
                                    links);
     }
+
+    public URI resolveExternalSpecURI(URI specURI) {
+        if (!specURI.isAbsolute()) {
+            URI baseURI = configuration.getOptions().specBaseURI();
+            if (baseURI == null) {
+                baseURI = URI.create("../specs/");
+            }
+            if (!baseURI.isAbsolute() && !pathToRoot.isEmpty()) {
+                baseURI = URI.create(pathToRoot.getPath() + "/").resolve(baseURI);
+            }
+            specURI = baseURI.resolve(specURI);
+        }
+        return specURI;
+    }
+
 }