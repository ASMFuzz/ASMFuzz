@@ -56,13 +56,7 @@
 // holds SettingControl instances that need to be released
 // when a class is unloaded (to avoid memory leaks).
 public final class EventControl {
-    static final class NamedControl {
-        public final String name;
-        public final Control control;
-        NamedControl(String name, Control control) {
-            this.name = name;
-            this.control = control;
-        }
+    record NamedControl(String name, Control control) {
     }
     static final String FIELD_SETTING_PREFIX = "setting";
     private static final Type TYPE_ENABLED = TypeLibrary.createType(EnabledSetting.class);