@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2015, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2015, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -108,6 +108,10 @@ class LogTagSet {
     _output_list.clear();
   }
 
+  PrefixWriter write_prefix() {
+    return _write_prefix;
+  }
+
   void set_output_level(LogOutput* output, LogLevelType level) {
     _output_list.set_output_level(output, level);
   }