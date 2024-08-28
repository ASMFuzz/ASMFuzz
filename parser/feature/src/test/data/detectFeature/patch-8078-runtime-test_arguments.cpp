@@ -572,7 +572,7 @@ TEST_VM_F(ArgumentsTest, set_numeric_flag_double) {
   check_numeric_flag<double>(flag, getvalue, valid_strings,
                              ARRAY_SIZE(valid_strings), /*is_double=*/true);
 
-  const char* more_valid_strings[] = {
+  const char* more_test_strings[] = {
     // These examples are from https://en.cppreference.com/w/cpp/language/floating_literal
     // (but with the L and F suffix removed).
     "1e10", "1e-5",
@@ -582,25 +582,33 @@ TEST_VM_F(ArgumentsTest, set_numeric_flag_double) {
     "0x1.p0", "0xf.p-1",
     "0x0.123p-1", "0xa.bp10",
     "0x1.4p3",
+
     // More test cases
     "1.5", "6.02e23", "-6.02e+23",
     "1.7976931348623157E+308", // max double
     "-0", "0",
     "0x1.91eb85p+1",
     "999999999999999999999999999999",
   };
-  for (uint i = 0; i < ARRAY_SIZE(more_valid_strings); i++) {
-    const char* str = more_valid_strings[i];
+  for (uint i = 0; i < ARRAY_SIZE(more_test_strings); i++) {
+    const char* str = more_test_strings[i];
 
     char* dummy;
+    errno = 0;
     double expected = strtod(str, &dummy);
-    ASSERT_TRUE(errno == 0);
-
-    ASSERT_TRUE(ArgumentsTest::parse_argument(flag->name(), str))
-        << "Valid string '" <<
+    if (errno == 0) {
+      ASSERT_TRUE(ArgumentsTest::parse_argument(flag->name(), str))
+        << "Test string '" <<
         str << "' did not parse for type " << flag->type_string() << ".";
-    double d = flag->get_double();
-    ASSERT_TRUE(d == expected)
+      double d = flag->get_double();
+      ASSERT_TRUE(d == expected)
         << "Parsed number " << d << " is not the same as expected " << expected;
+    } else {
+      // Some of the strings like "1.e-2" are not valid in certain locales.
+      // The decimal-point character is also locale dependent.
+      ASSERT_FALSE(ArgumentsTest::parse_argument(flag->name(), str))
+        << "Invalid string '" << str << "' parsed without error.";
+
+    }
   }
 }