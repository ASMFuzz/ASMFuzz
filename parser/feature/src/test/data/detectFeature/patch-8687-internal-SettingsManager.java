@@ -219,11 +219,11 @@ void setEventControl(EventControl ec) {
         }
         for (NamedControl nc: ec.getNamedControls()) {
             Set<String> values = null;
-            String settingName = nc.name;
+            String settingName = nc.name();
             if (is != null) {
                 values = is.getValues(settingName);
             }
-            Control control = nc.control;
+            Control control = nc.control();
             if (values != null) {
                 control.apply(values);
                 String after = control.getLastValue();