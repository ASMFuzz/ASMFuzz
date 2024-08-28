@@ -85,7 +85,7 @@ private void initializeJVMEventTypes() {
                 // annotations, such as Period and Threshold.
                 if (pEventType.hasPeriod()) {
                     pEventType.setEventHook(true);
-                    if (!(Type.EVENT_NAME_PREFIX + "ExecutionSample").equals(type.getName())) {
+                    if (!pEventType.isMethodSampling()) {
                         requestHooks.add(new RequestHook(pEventType));
                     }
                 }