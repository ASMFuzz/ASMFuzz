@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2014, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -24,30 +24,39 @@
 
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
 import org.openjdk.jmh.infra.Blackhole;
 
+import java.util.Locale;
 import java.util.Random;
 import java.util.concurrent.TimeUnit;
 
 @BenchmarkMode(Mode.AverageTime)
 @OutputTimeUnit(TimeUnit.NANOSECONDS)
 @State(Scope.Thread)
+@Warmup(iterations = 10, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
+@Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
+@Fork(3)
 public class StringOther {
 
     private String testString;
     private Random rnd;
 
     private String str1, str2, str3, str4;
+    private String str1UP;
 
     @Setup
     public void setup() {
         testString = "Idealism is what precedes experience; cynicism is what follows.";
         str1 = "vm-guld vm-guld vm-guld";
+        str1UP = str1.toUpperCase(Locale.ROOT);
         str2 = "vm-guld vm-guld vm-guldx";
         str3 = "vm-guld vm-guld vm-guldx";
         str4 = "adadaskasdjierudks";
@@ -85,4 +94,10 @@ public String internUnique() {
         return String.valueOf(rnd.nextInt()).intern();
     }
 
+    @Benchmark
+    public void regionMatchesLatin1(Blackhole bh) {
+        bh.consume(str1.regionMatches(true, 0, str2, 0, str1.length()));
+        bh.consume(str2.regionMatches(true, 16, str1UP, 0, 8));
+        bh.consume(str3.regionMatches(true, 6, str4, 1, 2));
+    }
 }