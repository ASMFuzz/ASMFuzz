@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2001, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2001, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -247,8 +247,8 @@ private void testRun()
         getEventSet();
         cpRequest.disable();
 
-        ClassPrepareEvent event = (ClassPrepareEvent) eventIterator.next();
-        debuggeeClass = event.referenceType();
+        ClassPrepareEvent cpEvent = (ClassPrepareEvent) eventIterator.next();
+        debuggeeClass = cpEvent.referenceType();
 
         if (!debuggeeClass.name().equals(debuggeeName))
            throw new JDITestRuntimeException("** Unexpected ClassName for ClassPrepareEvent **");
@@ -371,13 +371,14 @@ private void testRun()
             }
 
             mainThread.resume();
-            getEventSet();
+            getEventSetForThreadStartDeath("thread" + i);
 
-            if ( !(eventIterator.nextEvent() instanceof ThreadStartEvent)) {
-                 log3("ERROR: new event is not ThreadStartEvent");
+            Event event = eventIterator.nextEvent();
+            if (!(event instanceof ThreadStartEvent)) {
+                log3("ERROR: new event is not ThreadStartEvent: " + event);
                  testExitCode = FAILED;
             } else {
-                log2("......got : instanceof ThreadStartEvent");
+                log2("......got : instanceof ThreadStartEvent: " + event);
                 policy = eventSet.suspendPolicy();
                 if (policy != policyExpected[i]) {
                     log3("ERROR: eventSet.suspendPolicy() != policyExpected");
@@ -418,8 +419,6 @@ private ThreadStartRequest settingThreadStartRequest(int suspendPolicy,
             throws JDITestRuntimeException {
         try {
             ThreadStartRequest tsr = eventRManager.createThreadStartRequest();
-//            tsr.addThreadFilter(mainThread);
-            tsr.addCountFilter(1);
             tsr.setSuspendPolicy(suspendPolicy);
             tsr.putProperty("number", property);
             return tsr;