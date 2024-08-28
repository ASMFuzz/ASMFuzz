@@ -283,13 +283,13 @@ void writeActiveSettingEvent() {
         if (!type.isRegistered()) {
             return;
         }
-        ActiveSettingEvent event = ActiveSettingEvent.EVENT.get();
         for (NamedControl nc : namedControls) {
             if (Utils.isSettingVisible(nc.control, type.hasEventHook()) && type.isVisible()) {
                 String value = nc.control.getLastValue();
                 if (value == null) {
                     value = nc.control.getDefaultValue();
                 }
+                ActiveSettingEvent event = new ActiveSettingEvent();
                 event.id = type.getId();
                 event.name = nc.name;
                 event.value = value;