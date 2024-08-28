@@ -36,7 +36,7 @@
 import jdk.jfr.SettingControl;
 import jdk.jfr.internal.settings.JDKSettingControl;
 
-public final class Control {
+final class Control {
     @SuppressWarnings("removal")
     private final AccessControlContext context;
     private static final int CACHE_SIZE = 5;