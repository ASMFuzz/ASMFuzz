@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -24,13 +24,16 @@
 
 import org.openjdk.jmh.annotations.Benchmark;
 import org.openjdk.jmh.annotations.BenchmarkMode;
+import org.openjdk.jmh.annotations.Fork;
+import org.openjdk.jmh.annotations.Measurement;
 import org.openjdk.jmh.annotations.Mode;
 import org.openjdk.jmh.annotations.OutputTimeUnit;
 import org.openjdk.jmh.annotations.Scope;
 import org.openjdk.jmh.annotations.Setup;
 import org.openjdk.jmh.annotations.State;
+import org.openjdk.jmh.annotations.Warmup;
+import org.openjdk.jmh.infra.Blackhole;
 
-import java.lang.invoke.CallSite;
 import java.lang.invoke.MethodHandles;
 import java.lang.invoke.MethodType;
 import java.lang.invoke.StringConcatFactory;
@@ -40,14 +43,27 @@
  * Check StringConcatFactory bootstrap overheads
  */
 @BenchmarkMode(Mode.AverageTime)
+@Warmup(iterations = 10, time = 2000, timeUnit = TimeUnit.MILLISECONDS)
+@Measurement(iterations = 10, time = 2000, timeUnit = TimeUnit.MILLISECONDS)
 @OutputTimeUnit(TimeUnit.NANOSECONDS)
 @State(Scope.Thread)
+@Fork(3)
 public class StringConcatFactoryBootstraps {
 
-    public MethodType mt =
+    public MethodType mt1 =
             MethodType.methodType(String.class, String.class, int.class,
                                   String.class, String.class);
-    public String recipe = "test\u0001foo\u0001\u0002bar\u0001\u0002baz\u0001";
+    public String recipe1 = "test\u0001foo\u0001bar\u0001baz\u0001";
+
+    public MethodType mt2 =
+            MethodType.methodType(String.class, String.class, String.class);
+    public String recipe2 = "test\u0001foo\u0001";
+
+    public MethodType mt3 =
+            MethodType.methodType(String.class, String.class, String.class, String.class,
+                                  String.class, String.class, String.class);
+    public String recipe3 = "\u0001test\u0001foo\u0001bar\u0001baz\u0001\u0001";
+
     public MethodHandles.Lookup lookup;
 
     @Setup
@@ -58,7 +74,9 @@ public void setup() {
     }
 
     @Benchmark
-    public CallSite makeConcatWithConstants() throws Throwable {
-        return StringConcatFactory.makeConcatWithConstants(lookup, "dummy", mt, recipe, "const1", "const2");
+    public void makeConcatWithConstants(Blackhole bh) throws Throwable {
+        bh.consume(StringConcatFactory.makeConcatWithConstants(lookup, "dummy", mt1, recipe1));
+        bh.consume(StringConcatFactory.makeConcatWithConstants(lookup, "dummy", mt2, recipe2));
+        bh.consume(StringConcatFactory.makeConcatWithConstants(lookup, "dummy", mt3, recipe3));
     }
 }