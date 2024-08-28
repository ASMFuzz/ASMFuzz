@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2004, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2004, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -40,36 +40,35 @@
  *     PhantomRefence for NonbranchyTree and Referent calsses does not refer to
  *     arrays, but to instances of the classes.
  *     After that a thread performs next checks for the reference:
- *         1. The reference is in queue after GC is provoked with
- *            Algorithms.eatMemory() method (a single thread eats the memory).
+ *         1. The reference is in queue after GC is provoked with WB.fullGC()
  *         2. reference.get() returns null.
  *         3. queue.poll() returns the reference that was created.
  *         4. queue.poll() again returns null.
  *         5. If the checked type is class (Referent), then it must be finalized,
  *            since the reference is already enqueued.
- *         6. reference.clear() does not throw any exception.
  *     The test extends ThreadedGCTest and implements GarbageProducerAware and
  *     MemoryStrategyAware interfaces. The corresponding javadoc documentation
  *     for additional test configuration.
  *
  * @library /vmTestbase
  *          /test/lib
- * @run main/othervm gc.gctests.PhantomReference.phantom001.phantom001 -ms low
+ * @build jdk.test.whitebox.WhiteBox
+ * @run driver jdk.test.lib.helpers.ClassFileInstaller jdk.test.whitebox.WhiteBox
+ * @run main/othervm -Xbootclasspath/a:. -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI gc.gctests.PhantomReference.phantom001.phantom001
  */
 
 package gc.gctests.PhantomReference.phantom001;
 
 import java.lang.ref.*;
 import java.time.LocalTime;
+
+import jdk.test.whitebox.WhiteBox;
 import nsk.share.gc.*;
-import nsk.share.gc.gp.*;
 import nsk.share.gc.gp.string.InternedStringProducer;
 import nsk.share.gc.gp.string.RandomStringProducer;
 
-public class phantom001 extends ThreadedGCTest implements GarbageProducerAware, MemoryStrategyAware {
+public class phantom001 extends ThreadedGCTest {
 
-    private GarbageProducer garbageProducer;
-    private MemoryStrategy memoryStrategy;
     private InternedStringProducer internedStringProducer = new InternedStringProducer(new RandomStringProducer(10));
     // Total number of types to test
     final static int TYPES_COUNT = 12;
@@ -81,20 +80,12 @@ protected Runnable createRunnable(int i) {
         return new Test();
     }
 
-    public void setGarbageProducer(GarbageProducer garbageProducer) {
-        this.garbageProducer = garbageProducer;
-    }
-
-    public void setMemoryStrategy(MemoryStrategy memoryStrategy) {
-        this.memoryStrategy = memoryStrategy;
-    }
-
     public static void main(String[] args) {
         GC.runTest(new phantom001(), args);
     }
 
     // The class implements the logic of the testcase
-    class Test implements Runnable, OOMStress {
+    class Test implements Runnable {
 
         int iteration;
         private volatile boolean finalized;
@@ -124,131 +115,120 @@ private boolean shouldTerminate() {
             return !getExecutionController().continueExecution();
         }
 
-        private void eatMemory(int initialFactor) {
-            GarbageUtils.eatMemory(getExecutionController(),
-                                   garbageProducer,
-                                   initialFactor, 10, 0);
-        }
-
         public void run() {
-            try {
-                int code = iteration % TYPES_COUNT;
-                info("start code " + code);
-                ReferenceQueue queue = new ReferenceQueue();
-                PhantomReference reference;
-                String type;
-                // Define a specific type for each thread to test
-                switch (code) {
-                    case 0:
-                        reference = new PhantomReference(new byte[SIZE], queue);
-                        type = "byte";
-                        break;
-                    case 1:
-                        reference = new PhantomReference(new short[SIZE], queue);
-                        type = "short";
-                        break;
-                    case 2:
-                        reference = new PhantomReference(new int[SIZE], queue);
-                        type = "int";
-                        break;
-                    case 3:
-                        reference = new PhantomReference(new long[SIZE], queue);
-                        type = "long";
-                        break;
-                    case 4:
-                        reference = new PhantomReference(new char[SIZE], queue);
-                        type = "char";
-                        break;
-                    case 5:
-                        reference = new PhantomReference(new boolean[SIZE], queue);
-                        type = "boolean";
-                        break;
-                    case 6:
-                        reference = new PhantomReference(new double[SIZE], queue);
-                        type = "double";
-                        break;
-                    case 7:
-                        reference = new PhantomReference(new float[SIZE], queue);
-                        type = "float";
-                        break;
-                    case 8:
-                        reference = new PhantomReference(new Object[SIZE], queue);
-                        type = "Object";
-                        break;
-                    case 9:
-                        reference = new PhantomReference(new NonbranchyTree(SIZE, 0.3f, SIZE),
-                                queue);
-                        type = "NonbranchyTree";
-                        break;
-                    case 10:
-                        reference = new PhantomReference(internedStringProducer.create(SIZE), queue);
-                        type = "InternedString";
-                        break;
-                    default:
-                        reference = new PhantomReference(new Referent(), queue);
-                        type = "class";
-                }
-
-                int initialFactor = memoryStrategy.equals(MemoryStrategy.HIGH) ? 1 : (memoryStrategy.equals(MemoryStrategy.LOW) ? 10 : 2);
 
-                // If referent is finalizable, provoke GCs and wait for finalization.
-                if (type.equals("class")) {
-                    progress("Waiting for finalization: " + type);
-                    for (int checks = 0; !finalized && !shouldTerminate(); ++checks) {
-                        // There are scenarios where one eatMemory() isn't enough,
-                        // but 10 iterations really ought to be sufficient.
-                        if (checks > 10) {
-                            fail("Waiting for finalization: " + type);
-                            return;
-                        }
-                        eatMemory(initialFactor);
-                        // Give some time for finalizer to run.
-                        try {
-                            Thread.sleep(100);
-                        } catch (InterruptedException e) {}
-                    }
-                }
+            int code = iteration % TYPES_COUNT;
+            info("start code " + code);
+            ReferenceQueue queue = new ReferenceQueue();
+            PhantomReference reference;
+            String type;
+            // Define a specific type for each thread to test
+            switch (code) {
+                case 0:
+                    reference = new PhantomReference(new byte[SIZE], queue);
+                    type = "byte";
+                    break;
+                case 1:
+                    reference = new PhantomReference(new short[SIZE], queue);
+                    type = "short";
+                    break;
+                case 2:
+                    reference = new PhantomReference(new int[SIZE], queue);
+                    type = "int";
+                    break;
+                case 3:
+                    reference = new PhantomReference(new long[SIZE], queue);
+                    type = "long";
+                    break;
+                case 4:
+                    reference = new PhantomReference(new char[SIZE], queue);
+                    type = "char";
+                    break;
+                case 5:
+                    reference = new PhantomReference(new boolean[SIZE], queue);
+                    type = "boolean";
+                    break;
+                case 6:
+                    reference = new PhantomReference(new double[SIZE], queue);
+                    type = "double";
+                    break;
+                case 7:
+                    reference = new PhantomReference(new float[SIZE], queue);
+                    type = "float";
+                    break;
+                case 8:
+                    reference = new PhantomReference(new Object[SIZE], queue);
+                    type = "Object";
+                    break;
+                case 9:
+                    reference = new PhantomReference(new NonbranchyTree(SIZE, 0.3f, SIZE),
+                            queue);
+                    type = "NonbranchyTree";
+                    break;
+                case 10:
+                    reference = new PhantomReference(internedStringProducer.create(SIZE), queue);
+                    type = "InternedString";
+                    break;
+                default:
+                    reference = new PhantomReference(new Referent(), queue);
+                    type = "class";
+            }
 
-                // Provoke GCs and wait for reference to be enqueued.
-                progress("Waiting for enqueue: " + type);
-                Reference polled = queue.poll();
-                for (int checks = 0; polled == null && !shouldTerminate(); ++checks) {
-                    // There are scenarios where one eatMemory() isn't enough,
+            // If referent is finalizable, provoke GCs and wait for finalization.
+            if (type.equals("class")) {
+                progress("Waiting for finalization: " + type);
+                for (int checks = 0; !finalized && !shouldTerminate(); ++checks) {
+                    // There are scenarios where one WB.fillGC() isn't enough,
                     // but 10 iterations really ought to be sufficient.
                     if (checks > 10) {
-                        fail("Waiting for enqueue: " + type);
+                        fail("Waiting for finalization: " + type);
                         return;
                     }
-                    eatMemory(initialFactor);
-                    // Give some time for reference to be enqueued.
+                    WhiteBox.getWhiteBox().fullGC();
+                    // Give some time for finalizer to run.
                     try {
-                        polled = queue.remove(100);
+                        Thread.sleep(checks * 100);
                     } catch (InterruptedException e) {}
                 }
+            }
 
-                if (polled == null && shouldTerminate()) {
-                    info("Terminated: " + type);
+            // Provoke GCs and wait for reference to be enqueued.
+            progress("Waiting for enqueue: " + type);
+            Reference polled = queue.poll();
+            for (int checks = 0; polled == null && !shouldTerminate(); ++checks) {
+                // There are scenarios where one WB.fillGC() isn't enough,
+                // but 10 iterations really ought to be sufficient.
+                if (checks > 10) {
+                    fail("Waiting for enqueue: " + type);
                     return;
                 }
+                WhiteBox.getWhiteBox().fullGC();
+                // Give some time for reference to be enqueued.
+                try {
+                    polled = queue.remove(checks * 100);
+                } catch (InterruptedException e) {}
+            }
 
-                // The polled reference must be equal to the one enqueued to
-                // the queue
-                if (polled != reference) {
-                    fail("The original reference is not equal to polled reference.");
-                    return;
-                }
+            if (polled == null && shouldTerminate()) {
+                info("Terminated: " + type);
+                return;
+            }
 
-                // queue.poll() once again must return null now, since there is
-                // only one reference in the queue
-                if (queue.poll() != null) {
-                    fail("There are more than one reference in the queue.");
-                    return;
-                }
-                progress("Finished: " + type);
-            } catch (OutOfMemoryError e) {
-            } finally {
-                iteration++;
+            // The polled reference must be equal to the one enqueued to
+            // the queue
+            if (polled != reference) {
+                fail("The original reference is not equal to polled reference.");
+                return;
+            }
+
+            // queue.poll() once again must return null now, since there is
+            // only one reference in the queue
+            if (queue.poll() != null) {
+                fail("There are more than one reference in the queue.");
+                return;
             }
+            progress("Finished: " + type);
+            iteration++;
         }
 
         class Referent {