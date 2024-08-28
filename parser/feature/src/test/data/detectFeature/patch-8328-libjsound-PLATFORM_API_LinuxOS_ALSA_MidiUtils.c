@@ -106,7 +106,7 @@ static int iterateRawmidiDevices(snd_rawmidi_stream_t direction,
                     snd_ctl_close(handle);
                 }
             }
-            // call calback function for the device
+            // call callback function for the device
             if (iterator != NULL) {
                 doContinue = (*iterator)(ALSA_DEFAULT_DEVICE_ID, rawmidi_info,
                                          defcardinfo, userData);