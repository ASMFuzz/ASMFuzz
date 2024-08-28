@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -1204,45 +1204,15 @@ private void monitor(ObservedObject o, int index, int an[]) {
                 MONITOR_LOGGER.log(Level.TRACE, msg);
                 MONITOR_LOGGER.log(Level.TRACE, anf_ex::toString);
             }
-        } catch (MBeanException mb_ex) {
+        } catch (MBeanException | ReflectionException| IOException | RuntimeException e) {
             if (isAlreadyNotified(o, RUNTIME_ERROR_NOTIFIED))
                 return;
             else {
                 notifType = RUNTIME_ERROR;
                 setAlreadyNotified(o, index, RUNTIME_ERROR_NOTIFIED, an);
-                msg = mb_ex.getMessage() == null ? "" : mb_ex.getMessage();
+                msg = e.getMessage() == null ? "" : e.getMessage();
                 MONITOR_LOGGER.log(Level.TRACE, msg);
-                MONITOR_LOGGER.log(Level.TRACE, mb_ex::toString);
-            }
-        } catch (ReflectionException ref_ex) {
-            if (isAlreadyNotified(o, RUNTIME_ERROR_NOTIFIED)) {
-                return;
-            } else {
-                notifType = RUNTIME_ERROR;
-                setAlreadyNotified(o, index, RUNTIME_ERROR_NOTIFIED, an);
-                msg = ref_ex.getMessage() == null ? "" : ref_ex.getMessage();
-                MONITOR_LOGGER.log(Level.TRACE, msg);
-                MONITOR_LOGGER.log(Level.TRACE, ref_ex::toString);
-            }
-        } catch (IOException io_ex) {
-            if (isAlreadyNotified(o, RUNTIME_ERROR_NOTIFIED))
-                return;
-            else {
-                notifType = RUNTIME_ERROR;
-                setAlreadyNotified(o, index, RUNTIME_ERROR_NOTIFIED, an);
-                msg = io_ex.getMessage() == null ? "" : io_ex.getMessage();
-                MONITOR_LOGGER.log(Level.TRACE, msg);
-                MONITOR_LOGGER.log(Level.TRACE, io_ex::toString);
-            }
-        } catch (RuntimeException rt_ex) {
-            if (isAlreadyNotified(o, RUNTIME_ERROR_NOTIFIED))
-                return;
-            else {
-                notifType = RUNTIME_ERROR;
-                setAlreadyNotified(o, index, RUNTIME_ERROR_NOTIFIED, an);
-                msg = rt_ex.getMessage() == null ? "" : rt_ex.getMessage();
-                MONITOR_LOGGER.log(Level.TRACE, msg);
-                MONITOR_LOGGER.log(Level.TRACE, rt_ex::toString);
+                MONITOR_LOGGER.log(Level.TRACE, e::toString);
             }
         }
 