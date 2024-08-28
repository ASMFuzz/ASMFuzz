@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2004, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2004, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -33,15 +33,14 @@
  *     WeakReferences. It also checks that no unexpected exceptions and errors
  *     are thrown or the JVM is not crashed.
  *     The test starts a number of threads. Each thread run tests for some time
- *     or serveral iterations.  See javadoc StressOptions for configuration.
+ *     or serveral iterations.
  *     First of all each test defines what type to check (there are 10 types
  *     totally). As soon as the type is defined, a WeakReference is created that
  *     refers to an array of tested type and is registered with in a queue. A
  *     WeakReference for NonbranchyTree class does not refer to an array, but to
  *     instances of the class.
  *     After that a thread performs next checks for the reference:
- *         1. The reference is in queue after GC is provoked with
- *            Algorithms.eatMemory() method (a single thread eats the memory).
+ *         1. The reference is in queue after GC is provoked with WB.fullGC()
  *         2. queue.remove() returns reference from the queue.
  *         3. queue.poll() returns null.
  *         4. reference.clear() does not throw any exception.
@@ -51,31 +50,27 @@
  *
  * @library /vmTestbase
  *          /test/lib
- * @run main/othervm gc.gctests.WeakReference.weak001.weak001 -ms low
+ * @build jdk.test.whitebox.WhiteBox
+ * @run driver jdk.test.lib.helpers.ClassFileInstaller jdk.test.whitebox.WhiteBox
+ * @run main/othervm -Xbootclasspath/a:. -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI gc.gctests.WeakReference.weak001.weak001
  */
 
+
 package gc.gctests.WeakReference.weak001;
 
 import java.lang.ref.Reference;
 import java.lang.ref.ReferenceQueue;
 import java.lang.ref.WeakReference;
 
+import jdk.test.whitebox.WhiteBox;
 import nsk.share.gc.GC;
 import nsk.share.gc.NonbranchyTree;
-import nsk.share.gc.OOMStress;
 import nsk.share.gc.ThreadedGCTest;
-import nsk.share.gc.gp.GarbageProducer;
-import nsk.share.gc.gp.GarbageProducerAware;
-import nsk.share.gc.gp.GarbageUtils;
-import nsk.share.gc.gp.MemoryStrategy;
-import nsk.share.gc.gp.MemoryStrategyAware;
 import nsk.share.gc.gp.string.InternedStringProducer;
 import nsk.share.gc.gp.string.RandomStringProducer;
 
-public class weak001 extends ThreadedGCTest implements GarbageProducerAware, MemoryStrategyAware {
+public class weak001 extends ThreadedGCTest {
 
-    private GarbageProducer garbageProducer;
-    private MemoryStrategy memoryStrategy;
     private InternedStringProducer internedStringProducer = new InternedStringProducer(new RandomStringProducer(10));
     // Total number of types to test
     final static int TYPES_COUNT = 11;
@@ -87,114 +82,105 @@ protected Runnable createRunnable(int i) {
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
         GC.runTest(new weak001(), args);
     }
 
     // The class implements the logic of the testcase
-    class Test implements Runnable, OOMStress {
+    class Test implements Runnable {
 
         int iteration;
 
         public void run() {
-            // Pre-allocated OOME message to avoid OOME when logging it
-            String oomMsg = "Ignored OOME in run()";
-            try {
-
-                log.info("iteration " + iteration);
-                ReferenceQueue queue = new ReferenceQueue();
-                WeakReference reference;
-                int code = iteration % TYPES_COUNT;
-                String type;
-                // Define a specific type for each thread to test
-                switch (code) {
-                    case 0:
-                        reference = new WeakReference(new byte[SIZE], queue);
-                        type = "byte";
-                        break;
-                    case 1:
-                        reference = new WeakReference(new short[SIZE], queue);
-                        type = "short";
-                        break;
-                    case 2:
-                        reference = new WeakReference(new int[SIZE], queue);
-                        type = "int";
-                        break;
-                    case 3:
-                        reference = new WeakReference(new long[SIZE], queue);
-                        type = "long";
-                        break;
-                    case 4:
-                        reference = new WeakReference(new char[SIZE], queue);
-                        type = "char";
-                        break;
-                    case 5:
-                        reference = new WeakReference(new boolean[SIZE], queue);
-                        type = "boolean";
-                        break;
-                    case 6:
-                        reference = new WeakReference(new double[SIZE], queue);
-                        type = "double";
-                        break;
-                    case 7:
-                        reference = new WeakReference(new float[SIZE], queue);
-                        type = "float";
-                        break;
-                    case 8:
-                        reference = new WeakReference(new Object[SIZE], queue);
-                        type = "Object";
-                        break;
-                    case 9:
-                        reference = new WeakReference(internedStringProducer.create(SIZE), queue);
-                        type = "InternedString";
-                        break;
-                    default:
-                        reference = new WeakReference(new NonbranchyTree(SIZE, 0.3f, SIZE),
-                                queue);
-                        type = "NonbranchyTree";
-                        break;
-                }
-                int initialFactor = memoryStrategy.equals(MemoryStrategy.HIGH) ? 1 : (memoryStrategy.equals(MemoryStrategy.LOW) ? 10 : 2);
-                GarbageUtils.eatMemory(getExecutionController(), garbageProducer, initialFactor , 10, 0);
+            log.info("iteration " + iteration);
+            ReferenceQueue queue = new ReferenceQueue();
+            WeakReference reference;
+            int code = iteration % TYPES_COUNT;
+            String type;
+            // Define a specific type for each thread to test
+            switch (code) {
+                case 0:
+                    reference = new WeakReference(new byte[SIZE], queue);
+                    type = "byte";
+                    break;
+                case 1:
+                    reference = new WeakReference(new short[SIZE], queue);
+                    type = "short";
+                    break;
+                case 2:
+                    reference = new WeakReference(new int[SIZE], queue);
+                    type = "int";
+                    break;
+                case 3:
+                    reference = new WeakReference(new long[SIZE], queue);
+                    type = "long";
+                    break;
+                case 4:
+                    reference = new WeakReference(new char[SIZE], queue);
+                    type = "char";
+                    break;
+                case 5:
+                    reference = new WeakReference(new boolean[SIZE], queue);
+                    type = "boolean";
+                    break;
+                case 6:
+                    reference = new WeakReference(new double[SIZE], queue);
+                    type = "double";
+                    break;
+                case 7:
+                    reference = new WeakReference(new float[SIZE], queue);
+                    type = "float";
+                    break;
+                case 8:
+                    reference = new WeakReference(new Object[SIZE], queue);
+                    type = "Object";
+                    break;
+                case 9:
+                    reference = new WeakReference(internedStringProducer.create(SIZE), queue);
+                    type = "InternedString";
+                    break;
+                default:
+                    reference = new WeakReference(new NonbranchyTree(SIZE, 0.3f, SIZE),
+                            queue);
+                    type = "NonbranchyTree";
+                    break;
+            }
+            Reference polledReference = null;
+            for (int i = 0; i < 10 && polledReference == null; i++) {
+                WhiteBox.getWhiteBox().fullGC();
                 if (!getExecutionController().continueExecution()) {
                     // we were interrrupted by stresser. just exit...
                     return;
                 }
-                Reference polledReference = null;
                 try {
-                    polledReference = queue.remove();
+                    polledReference = queue.remove(i * 100);
                 } catch (InterruptedException e) {
                     log.error("Unexpected InterruptedException during queue.remove().");
                     setFailed(true);
                 }
-                // Check the reference and the queue
-                // The polled reference must be equal to the one enqueued to
-                // the queue
+            }
 
-                if (polledReference != reference) {
-                    log.error("The original reference is not equal to polled reference.");
-                    setFailed(true);
-                }
+            if (polledReference == null) {
+                log.error("Haven't polled reference after 10 GC.");
+                setFailed(true);
+            }
 
-                // queue.poll() once again must return null now, since there is
-                // only one reference in the queue
-                polledReference = queue.poll();
-                if (polledReference != null) {
-                    log.error("There are more  than one references in the queue.");
-                    setFailed(true);
-                }
-                reference.clear();
-            } catch (OutOfMemoryError e) {
-                log.info(oomMsg);
+            // Check the reference and the queue
+            // The polled reference must be equal to the one enqueued to
+            // the queue
+            if (polledReference != reference) {
+                log.error("The original reference is not equal to polled reference.");
+                setFailed(true);
+            }
+
+            // queue.poll() once again must return null now, since there is
+            // only one reference in the queue
+            polledReference = queue.poll();
+            if (polledReference != null) {
+                log.error("There are more  than one references in the queue.");
+                setFailed(true);
             }
+            reference.clear();
             iteration++;
         }
     }