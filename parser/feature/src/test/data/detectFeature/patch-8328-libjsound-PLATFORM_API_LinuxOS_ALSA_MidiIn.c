@@ -79,7 +79,7 @@ char* MIDI_IN_GetErrorStr(INT32 err) {
 INT32 MIDI_IN_GetNumDevices() {
 /* Workaround for 6842956: 32bit app on 64bit linux
  * gets assertion failure trying to open midiIn ports.
- * Untill the issue is fixed in ALSA
+ * Until the issue is fixed in ALSA
  * (https://bugtrack.alsa-project.org/alsa-bug/view.php?id=4807)
  * report no midi in devices in the configuration.
  */