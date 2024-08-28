@@ -158,7 +158,7 @@ public synchronized EventType register(Class<? extends jdk.internal.event.Event>
         configuration.getPlatformEventType().setRegistered(true);
         typeLibrary.addType(configuration.getPlatformEventType());
         if (jvm.isRecording()) {
-            settingsManager.setEventControl(configuration.getEventControl());
+            settingsManager.setEventControl(configuration.getEventControl(), true);
             settingsManager.updateRetransform(Collections.singletonList((eventClass)));
        }
        setStaleMetadata();
@@ -225,8 +225,8 @@ private EventConfiguration makeConfiguration(Class<? extends jdk.internal.event.
         return configuration;
     }
 
-    public synchronized void setSettings(List<Map<String, String>> list) {
-        settingsManager.setSettings(list);
+    public synchronized void setSettings(List<Map<String, String>> list, boolean writeSettingEvents) {
+        settingsManager.setSettings(list, writeSettingEvents);
     }
 
     synchronized void disableEvents() {