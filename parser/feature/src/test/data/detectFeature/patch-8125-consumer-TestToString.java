@@ -64,12 +64,12 @@ public static void main(String[] args) throws Throwable {
             RecordedEvent e = events.get(0);
             String toString = e.toString();
             System.out.println(toString);
-            Asserts.assertTrue(toString.contains("hello, world"), "Missing String field value in RecordedEvent#toSting()");
-            Asserts.assertTrue(toString.contains("4711"), "Missing integer fields value in RecordedEvent#toSting()");
-            Asserts.assertTrue(toString.contains("313"), "Missing double value in RecordedEvent#toSting()");
-            Asserts.assertTrue(toString.contains("HashMap"), "Missing class value in RecordedEvent#toSting()");
-            Asserts.assertTrue(toString.contains("1234567890"), "Missing long value in RecordedEvent#toSting()");
-            Asserts.assertTrue(toString.contains("&"), "Missing char value in RecordedEvent#toSting()");
+            Asserts.assertTrue(toString.contains("hello, world"), "Missing String field value in RecordedEvent#toString()");
+            Asserts.assertTrue(toString.contains("4711"), "Missing integer fields value in RecordedEvent#toString()");
+            Asserts.assertTrue(toString.contains("313"), "Missing double value in RecordedEvent#toString()");
+            Asserts.assertTrue(toString.contains("HashMap"), "Missing class value in RecordedEvent#toString()");
+            Asserts.assertTrue(toString.contains("1234567890"), "Missing long value in RecordedEvent#toString()");
+            Asserts.assertTrue(toString.contains("&"), "Missing char value in RecordedEvent#toString()");
             Asserts.assertTrue(toString.contains("123"), "Missing byte value in RecordedEvent#toString()");
             Asserts.assertTrue(toString.contains("64"), "Missing short value in RecordedEvent#toString()");
             Asserts.assertTrue(toString.contains("false"), "Missing boolean value in RecordedEvent#toString()");