@@ -30,6 +30,9 @@
 import java.io.OutputStream;
 import java.io.OutputStreamWriter;
 import java.io.UnsupportedEncodingException;
+import java.net.URI;
+import java.net.URISyntaxException;
+import java.nio.file.Path;
 import java.time.Instant;
 import java.time.ZoneOffset;
 import java.time.ZonedDateTime;
@@ -295,6 +298,12 @@ public enum ModularityMismatchPolicy {
      */
     private int sourceTabSize;
 
+    /**
+     * Argument for command-line option {@code --spec-base-url}.
+     * The base URL for relative URLs in {@code @spec} tags.
+     */
+    private URI specBaseURI;
+
     /**
      * Value for command-line option {@code --override-methods summary}
      * or {@code --override-methods detail}.
@@ -670,6 +679,26 @@ public boolean process(String opt, List<String> args) {
                     }
                 },
 
+                new Option(resources, "--spec-base-url", 1) {
+                    @Override
+                    public boolean process(String opt, List<String> args) {
+                        String arg = args.get(0);
+                        try {
+                            if (!arg.endsWith("/")) {
+                                // to ensure that URI.resolve works as expected
+                                arg += "/";
+                            }
+                            specBaseURI = new URI(arg);
+                            return true;
+                        } catch (URISyntaxException e) {
+                            config.reporter.print(ERROR,
+                                    config.getDocResources().getText("doclet.Invalid_URL",
+                                            e.getMessage()));
+                            return false;
+                        }
+                    }
+                },
+
                 new Hidden(resources, "--disable-javafx-strict-checks") {
                     @Override
                     public boolean process(String opt, List<String> args) {
@@ -1050,6 +1079,14 @@ public int sourceTabSize() {
         return sourceTabSize;
     }
 
+    /**
+     * Argument for command-line option {@code --spec-base-url}.
+     * The base URL for relative URLs in {@code @spec} tags.
+     */
+    public URI specBaseURI() {
+        return specBaseURI;
+    }
+
     /**
      * Value for command-line option {@code --override-methods summary}
      * or {@code --override-methods detail}.