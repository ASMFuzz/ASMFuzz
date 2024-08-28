@@ -442,7 +442,7 @@ void PORT_GetControls(void* id, INT32 portIndex, PortControlCreator* creator) {
                         control = createVolumeControl(creator, portControl, elem, isPlayback);
                         // We wrap in a compound control to provide the channel name.
                         if (control != NULL) {
-                            /* $$mp 2003-09-14: The following cast shouln't be necessary. Instead, the
+                            /* $$mp 2003-09-14: The following cast shouldn't be necessary. Instead, the
                                declaration of PORT_NewCompoundControlPtr in Ports.h should be changed
                                to take a const char* parameter. */
                             control = (creator->newCompoundControl)(creator, (char*) snd_mixer_selem_channel_name(channel), &control, 1);
@@ -481,7 +481,7 @@ void PORT_GetControls(void* id, INT32 portIndex, PortControlCreator* creator) {
             }
         }
     }
-    /* $$mp 2003-09-14: The following cast shouln't be necessary. Instead, the
+    /* $$mp 2003-09-14: The following cast shouldn't be necessary. Instead, the
        declaration of PORT_NewCompoundControlPtr in Ports.h should be changed
        to take a const char* parameter. */
     portName = (char*) snd_mixer_selem_get_name(elem);