@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2021, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -23,7 +23,7 @@
 
 /*
  * @test
- * @bug 4926314
+ * @bug 4926314 8287003
  * @summary Test for InputStreamReader#read(CharBuffer).
  * @run testng ReadCharBuffer
  */
@@ -38,9 +38,11 @@
 import java.io.Reader;
 import java.nio.ByteBuffer;
 import java.nio.CharBuffer;
+import java.nio.charset.CodingErrorAction;
 import java.util.Arrays;
 
 import static java.nio.charset.StandardCharsets.US_ASCII;
+import static java.nio.charset.StandardCharsets.UTF_8;
 import static org.testng.Assert.assertEquals;
 
 public class ReadCharBuffer {
@@ -56,6 +58,13 @@ public Object[][] createBuffers() {
         };
     }
 
+    private void fillBuffer(CharBuffer buffer) {
+        char[] filler = new char[BUFFER_SIZE];
+        Arrays.fill(filler, 'x');
+        buffer.put(filler);
+        buffer.clear();
+    }
+
     @Test(dataProvider = "buffers")
     public void read(CharBuffer buffer) throws IOException {
         fillBuffer(buffer);
@@ -78,11 +87,19 @@ public void read(CharBuffer buffer) throws IOException {
         assertEquals(buffer.toString(), "xABCDEFxGHIJKLMNxxxxxxxx");
     }
 
-    private void fillBuffer(CharBuffer buffer) {
-        char[] filler = new char[BUFFER_SIZE];
-        Arrays.fill(filler, 'x');
-        buffer.put(filler);
-        buffer.clear();
+    @Test
+    public void readLeftover() throws IOException {
+        byte[] b = new byte[] {'a', 'b', (byte) 0xC2};
+        ByteArrayInputStream bais = new ByteArrayInputStream(b);
+        InputStreamReader r = new InputStreamReader(bais,
+            UTF_8.newDecoder().onMalformedInput(CodingErrorAction.IGNORE));
+        int n = r.read();
+        assertEquals((char)n, 'a');
+        char[] c = new char[3];
+        n = r.read(c, 0, 3);
+        assertEquals(n, 1);
+        assertEquals((char)c[0], 'b');
+        n = r.read();
+        assertEquals(n, -1);
     }
-
 }