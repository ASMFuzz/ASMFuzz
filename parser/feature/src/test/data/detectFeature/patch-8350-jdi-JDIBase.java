@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -165,18 +165,21 @@ protected void getEventSetForThreadStartDeath(String threadName) throws JDITestR
             Event event = eventIterator.nextEvent();
             if (event instanceof ThreadStartEvent evt) {
                 if (evt.thread().name().equals(threadName)) {
+                    log2("Got ThreadStartEvent for '" + evt.thread().name());
                     break;
                 }
                 log2("Got ThreadStartEvent for '" + evt.thread().name()
                         + "' instead of '" + threadName + "', skipping");
             } else if (event instanceof ThreadDeathEvent evt) {
                 if (evt.thread().name().equals(threadName)) {
+                    log2("Got ThreadDeathEvent for '" + evt.thread().name());
                     break;
                 }
                 log2("Got ThreadDeathEvent for '" + evt.thread().name()
                         + "' instead of '" + threadName + "', skipping");
             } else {
                 // not ThreadStartEvent nor ThreadDeathEvent
+                log2("Did't get ThreadStartEvent or ThreadDeathEvent: " + event);
                 break;
             }
             eventSet.resume();
@@ -188,15 +191,22 @@ protected void getEventSetForThreadStartDeath(String threadName) throws JDITestR
     protected void breakpointForCommunication() throws JDITestRuntimeException {
 
         log2("breakpointForCommunication");
-        getEventSet();
+        while (true) {
+            getEventSet();
 
-        Event event = eventIterator.nextEvent();
-        if (event instanceof BreakpointEvent) {
-            bpEvent = (BreakpointEvent) event;
-            return;
-        }
+            Event event = eventIterator.nextEvent();
+            if (event instanceof BreakpointEvent) {
+                bpEvent = (BreakpointEvent) event;
+                return;
+            }
 
-        throw new JDITestRuntimeException("** event '" + event + "' IS NOT a breakpoint **");
+            if (EventFilters.filtered(event)) {
+                // We filter out spurious ThreadStartEvents
+                continue;
+            }
+
+            throw new JDITestRuntimeException("** event '" + event + "' IS NOT a breakpoint **");
+        }
     }
 
     // Similar to breakpointForCommunication, but skips Locatable events from unexpected locations.