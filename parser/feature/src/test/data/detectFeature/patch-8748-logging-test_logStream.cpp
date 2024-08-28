@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -26,7 +26,9 @@
 #include "logTestFixture.hpp"
 #include "logTestUtils.inline.hpp"
 #include "logging/log.hpp"
+#include "logging/logMessage.hpp"
 #include "logging/logStream.hpp"
+#include "memory/resourceArea.hpp"
 #include "unittest.hpp"
 
 class LogStreamTest : public LogTestFixture {
@@ -90,6 +92,47 @@ TEST_VM_F(LogStreamTest, TestLineBufferAllocation) {
   }
 }
 
+// LogStream allows interleaving of other messages.
+// Compare this to NonInterLeavingLogStreamTest_NonInterleavingStream
+TEST_VM_F(LogStreamTest, InterleavingStream) {
+  set_log_config(TestLogFileName, "gc=info");
+  const char* message_order[] = {"1", "I am one line", "2", "but", "3", "I am not", NULL};
+  {
+    LogStream foo(Log(gc)::info());
+    if (foo.is_enabled()) {
+      foo.print("I am");
+      log_info(gc)("1");
+      foo.print_cr(" one line");
+      log_info(gc)("2");
+      foo.print_cr("but");
+      log_info(gc)("3");
+      foo.print_cr("I am not");
+    }
+  }
+  EXPECT_TRUE(file_contains_substrings_in_order(TestLogFileName, message_order));
+}
+
+// NonInterleavingLogStream does not allow interleaving of other messages.
+// Compare this to LogStreamTest_InterleavingStream
+TEST_VM_F(LogStreamTest, NonInterleavingStream) {
+  set_log_config(TestLogFileName, "gc=info");
+  const char* message_order[] = {"1", "2" , "3", "I am one line", "but", "I am not", NULL};
+  {
+    LogMessage(gc) lm ;
+    NonInterleavingLogStream foo{LogLevelType::Info, lm};
+    if (foo.is_enabled()) {
+      foo.print("I am");
+      log_info(gc)("1");
+      foo.print_cr(" one line");
+      log_info(gc)("2");
+      foo.print_cr("but");
+      log_info(gc)("3");
+      foo.print_cr("I am not");
+    }
+  }
+  EXPECT_TRUE(file_contains_substrings_in_order(TestLogFileName, message_order));
+}
+
 // Test, in release build, that the internal line buffer of a LogStream
 // object caps out at 1M.
 TEST_VM_F(LogStreamTest, TestLineBufferAllocationCap) {