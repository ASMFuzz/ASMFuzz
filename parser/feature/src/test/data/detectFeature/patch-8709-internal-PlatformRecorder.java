@@ -254,7 +254,7 @@ synchronized long start(PlatformRecording recording) {
                 currentChunk.setStartTime(startTime);
             }
             recording.setState(RecordingState.RUNNING);
-            updateSettings();
+            updateSettings(false);
             recording.setStartTime(startTime);
             writeMetaEvents();
         } else {
@@ -273,7 +273,7 @@ synchronized long start(PlatformRecording recording) {
             startTime = Utils.epochNanosToInstant(startNanos);
             recording.setStartTime(startTime);
             recording.setState(RecordingState.RUNNING);
-            updateSettings();
+            updateSettings(false);
             writeMetaEvents();
             if (currentChunk != null) {
                 finishChunk(currentChunk, startTime, recording);
@@ -337,7 +337,7 @@ synchronized void stop(PlatformRecording recording) {
         } else {
             RepositoryChunk newChunk = null;
             RequestEngine.doChunkEnd();
-            updateSettingsButIgnoreRecording(recording);
+            updateSettingsButIgnoreRecording(recording, false);
 
             String path = null;
             if (toDisk) {
@@ -381,19 +381,19 @@ private void disableEvents() {
         MetadataRepository.getInstance().disableEvents();
     }
 
-    void updateSettings() {
-        updateSettingsButIgnoreRecording(null);
+    void updateSettings(boolean writeSettingEvents) {
+        updateSettingsButIgnoreRecording(null, writeSettingEvents);
     }
 
-    void updateSettingsButIgnoreRecording(PlatformRecording ignoreMe) {
+    void updateSettingsButIgnoreRecording(PlatformRecording ignoreMe, boolean writeSettingEvents) {
         List<PlatformRecording> recordings = getRunningRecordings();
         List<Map<String, String>> list = new ArrayList<>(recordings.size());
         for (PlatformRecording r : recordings) {
             if (r != ignoreMe) {
                 list.add(r.getSettings());
             }
         }
-        MetadataRepository.getInstance().setSettings(list);
+        MetadataRepository.getInstance().setSettings(list, writeSettingEvents);
     }
 
 