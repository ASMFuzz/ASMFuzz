@@ -25,6 +25,7 @@
 
 package sun.awt;
 
+import java.io.File;
 import java.awt.GraphicsEnvironment;
 import java.awt.Toolkit;
 import java.security.AccessController;
@@ -43,17 +44,42 @@ public static Toolkit createToolkit() {
     /**
       * Called from java.awt.GraphicsEnvironment when
       * to check if on this platform, the JDK should default to
-      * headless mode, in the case the application did specify
+      * headless mode, in the case the application did not specify
       * a value for the java.awt.headless system property.
       */
     @SuppressWarnings("removal")
     public static boolean getDefaultHeadlessProperty() {
-        return
+        boolean noDisplay =
             AccessController.doPrivileged((PrivilegedAction<Boolean>) () -> {
 
                final String display = System.getenv("DISPLAY");
-               return  display == null || display.trim().isEmpty();
+               return display == null || display.trim().isEmpty();
+            });
+        if (noDisplay) {
+            return true;
+        }
+        /*
+         * If we positively identify a separate headless library support being present
+         * but no corresponding headful library, then we can support headless but
+         * not headful, so report that back to the caller.
+         * This does require duplication of knowing the name of the libraries
+         * also in libawt's OnLoad() but we need to make sure that the Java
+         * code is also set up as headless from the start - it is not so easy
+         * to try headful and then unwind that and then retry as headless.
+         */
+        boolean headless =
+            AccessController.doPrivileged((PrivilegedAction<Boolean>) () -> {
+                String[] libDirs = System.getProperty("sun.boot.library.path", "").split(":");
+                for (String libDir : libDirs) {
+                    File headlessLib = new File(libDir, "libawt_headless.so");
+                    File xawtLib = new File(libDir, "libawt_xawt.so");
+                    if (headlessLib.exists() && !xawtLib.exists()) {
+                        return true;
+                    }
+                }
+                return false;
             });
+        return headless;
     }
 
     /**
@@ -63,7 +89,11 @@ public static boolean getDefaultHeadlessProperty() {
       */
     public static String getDefaultHeadlessMessage() {
         return
-            "\nNo X11 DISPLAY variable was set,\n" +
-            "but this program performed an operation which requires it.";
+            """
+
+            No X11 DISPLAY variable was set,
+            or no headful library support was found,
+            but this program performed an operation which requires it,
+            """;
     }
 }