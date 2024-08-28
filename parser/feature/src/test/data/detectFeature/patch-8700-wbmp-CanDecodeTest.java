@@ -66,6 +66,7 @@ private static Vector<TestCase> getTestCases() {
                     (byte) 0x0a, (byte) 0x00}, 39693, false));
         v.add(new TestCase("ico", new byte[]{(byte) 0x00, (byte) 0x00,
                     (byte) 0x01, (byte) 0x00}, 1078, false));
+        v.add(new TestCase("empty", new byte[0], 0, false));
         return v;
     }
 