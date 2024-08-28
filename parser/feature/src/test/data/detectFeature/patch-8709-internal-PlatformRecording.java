@@ -465,7 +465,7 @@ public void setSetting(String id, String value) {
         synchronized (recorder) {
             this.settings.put(id, value);
             if (getState() == RecordingState.RUNNING) {
-                recorder.updateSettings();
+                recorder.updateSettings(true);
             }
         }
     }
@@ -486,7 +486,7 @@ private void setSettings(Map<String, String> settings, boolean update) {
         synchronized (recorder) {
             this.settings = new LinkedHashMap<>(settings);
             if (getState() == RecordingState.RUNNING && update) {
-                recorder.updateSettings();
+                recorder.updateSettings(true);
             }
         }
     }