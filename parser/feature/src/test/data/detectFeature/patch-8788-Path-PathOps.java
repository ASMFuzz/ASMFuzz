@@ -1412,10 +1412,10 @@ static void doWindowsTests() {
             .invalid();
         test("foo\u0000\bar")
             .invalid();
-        test("C:\\foo ")                // trailing space
-             .invalid();
+        test("C:\\foo ")
+            .string("C:\\foo ");// trailing space
         test("C:\\foo \\bar")
-            .invalid();
+            .string("C:\\foo \\bar");
         //test("C:\\foo.")              // trailing dot
             //.invalid();
         //test("C:\\foo...\\bar")