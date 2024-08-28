@@ -169,12 +169,26 @@ TEST_VM(LogFileOutput, invalid_file) {
   ResourceMark rm;
   stringStream ss;
 
+  // Generate sufficiently unique directory path and log spec for that path
+  ss.print("%s%s%s%d", os::get_temp_directory(), os::file_separator(), "tmplogdir", os::current_process_id());
+  char* path = ss.as_string();
+  ss.reset();
+
+  ss.print("%s%s", "file=", path);
+  char* log_spec = ss.as_string();
+  ss.reset();
+
+  ss.print("%s is not a regular file", path);
+  char* expected_output_substring = ss.as_string();
+  ss.reset();
+
   // Attempt to log to a directory (existing log not a regular file)
-  create_directory("tmplogdir");
-  LogFileOutput bad_file("file=tmplogdir");
+  create_directory(path);
+  LogFileOutput bad_file(log_spec);
   EXPECT_FALSE(bad_file.initialize("", &ss))
     << "file was initialized when there was an existing directory with the same name";
-  EXPECT_TRUE(string_contains_substring(ss.as_string(), "tmplogdir is not a regular file"))
-    << "missing expected error message, received msg: %s" << ss.as_string();
-  delete_empty_directory("tmplogdir");
+  char* logger_output = ss.as_string();
+  EXPECT_TRUE(string_contains_substring(logger_output, expected_output_substring))
+    << "missing expected error message, received msg: %s" << logger_output;
+  delete_empty_directory(path);
 }