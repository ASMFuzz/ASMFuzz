@@ -52,6 +52,14 @@ public class StringOther {
     private String str1, str2, str3, str4;
     private String str1UP;
 
+    private String lowerU1024Latin1;
+
+    private String upperU1024Latin1;
+
+    private String lowerU1024Utf;
+
+    private String upperU1024Utf;
+
     @Setup
     public void setup() {
         testString = "Idealism is what precedes experience; cynicism is what follows.";
@@ -61,6 +69,36 @@ public void setup() {
         str3 = "vm-guld vm-guld vm-guldx";
         str4 = "adadaskasdjierudks";
         rnd = new Random();
+        {
+            StringBuilder stringBuilder = new StringBuilder();
+            for (int i = 0; i < 1024; ++i) {
+                stringBuilder.append('u');
+            }
+            lowerU1024Latin1 = stringBuilder.toString();
+        }
+        {
+            StringBuilder stringBuilder = new StringBuilder();
+            for (int i = 0; i < 1024; ++i) {
+                stringBuilder.append('U');
+            }
+            upperU1024Latin1 = stringBuilder.toString();
+        }
+        {
+            StringBuilder stringBuilder = new StringBuilder();
+            for (int i = 0; i < 1020; ++i) {
+                stringBuilder.append('u');
+            }
+            stringBuilder.append("\u7530\u6240\u6d69\u4e8c");
+            lowerU1024Utf = stringBuilder.toString();
+        }
+        {
+            StringBuilder stringBuilder = new StringBuilder();
+            for (int i = 0; i < 1020; ++i) {
+                stringBuilder.append('U');
+            }
+            stringBuilder.append("\u7530\u6240\u6d69\u4e8c");
+            upperU1024Utf = stringBuilder.toString();
+        }
     }
 
     @Benchmark
@@ -100,4 +138,25 @@ public void regionMatchesLatin1(Blackhole bh) {
         bh.consume(str2.regionMatches(true, 16, str1UP, 0, 8));
         bh.consume(str3.regionMatches(true, 6, str4, 1, 2));
     }
+
+    @Benchmark
+    public boolean regionMatchesU1024LL() {
+        return lowerU1024Latin1.regionMatches(true, 0, lowerU1024Utf, 0, 1024);
+    }
+
+    @Benchmark
+    public boolean regionMatchesU1024LU() {
+        return lowerU1024Latin1.regionMatches(true, 0, upperU1024Utf, 0, 1024);
+    }
+
+    @Benchmark
+    public boolean regionMatchesU1024UL() {
+        return upperU1024Latin1.regionMatches(true, 0, lowerU1024Utf, 0, 1024);
+    }
+
+    @Benchmark
+    public boolean regionMatchesU1024UU() {
+        return upperU1024Latin1.regionMatches(true, 0, upperU1024Utf, 0, 1024);
+    }
+
 }