@@ -593,13 +593,13 @@ TEST_VM_F(ArgumentsTest, set_numeric_flag_double) {
   for (uint i = 0; i < ARRAY_SIZE(more_test_strings); i++) {
     const char* str = more_test_strings[i];
 
-    char* dummy;
+    char* end;
     errno = 0;
-    double expected = strtod(str, &dummy);
-    if (errno == 0) {
+    double expected = strtod(str, &end);
+    if (errno == 0 && end != NULL && *end == '\0') {
       ASSERT_TRUE(ArgumentsTest::parse_argument(flag->name(), str))
         << "Test string '" <<
-        str << "' did not parse for type " << flag->type_string() << ".";
+        str << "' did not parse for type " << flag->type_string() << ". (Expected value = " << expected << ")";
       double d = flag->get_double();
       ASSERT_TRUE(d == expected)
         << "Parsed number " << d << " is not the same as expected " << expected;