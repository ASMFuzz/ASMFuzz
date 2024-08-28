@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2014, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -24,11 +24,14 @@
 
 import org.openjdk.jmh.annotations.Benchmark;
 import org.openjdk.jmh.annotations.BenchmarkMode;
+import org.openjdk.jmh.annotations.Fork;
 import org.openjdk.jmh.annotations.Mode;
+import org.openjdk.jmh.annotations.Measurement;
 import org.openjdk.jmh.annotations.OutputTimeUnit;
 import org.openjdk.jmh.annotations.Scope;
 import org.openjdk.jmh.annotations.Setup;
 import org.openjdk.jmh.annotations.State;
+import org.openjdk.jmh.annotations.Warmup;
 
 import java.lang.invoke.MethodType;
 import java.util.concurrent.TimeUnit;
@@ -39,10 +42,16 @@
 @BenchmarkMode(Mode.AverageTime)
 @OutputTimeUnit(TimeUnit.NANOSECONDS)
 @State(Scope.Benchmark)
+@Warmup(iterations = 10, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
+@Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
+@Fork(3)
 public class MethodTypeAcquire {
 
     private MethodType pTypes;
 
+    private Class<?> objectType = Object.class;
+
+    private Class<?> otherType = A.class;
     @Setup
     public void setup() {
         pTypes = MethodType.methodType(A.class, B.class);
@@ -68,6 +77,21 @@ public MethodType testReturnObject() {
         return MethodType.methodType(Object.class);
     }
 
+    @Benchmark
+    public MethodType testGenericObject() {
+        return MethodType.genericMethodType(1);
+    }
+
+    @Benchmark
+    public MethodType testObjectObject() {
+        return MethodType.methodType(Object.class, Object.class);
+    }
+
+    @Benchmark
+    public MethodType testObjectObject_NonConst() {
+        return MethodType.methodType(objectType, objectType);
+    }
+
     @Benchmark
     public MethodType testSinglePType() {
         return MethodType.methodType(void.class, int.class);
@@ -78,6 +102,26 @@ public MethodType testMultiPType() {
         return MethodType.methodType(void.class, A.class, B.class);
     }
 
+    @Benchmark
+    public MethodType testMultiPType_ObjectAndA() {
+        return MethodType.methodType(Object.class, Object.class, Object.class, Object.class, Object.class, A.class, B.class);
+    }
+
+    @Benchmark
+    public MethodType testMultiPType_ObjectAndA_NonConst() {
+        return MethodType.methodType(objectType, objectType, objectType, objectType, objectType, otherType, otherType);
+    }
+
+    @Benchmark
+    public MethodType testMultiPType_ObjectOnly() {
+        return MethodType.methodType(Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class);
+    }
+
+    @Benchmark
+    public MethodType testMultiPType_ObjectOnly_NonConst() {
+        return MethodType.methodType(objectType, objectType, objectType, objectType, objectType, objectType, objectType);
+    }
+
     @Benchmark
     public MethodType testMultiPType_Arg() {
         return MethodType.methodType(void.class, pTypes);