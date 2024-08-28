@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -80,7 +80,7 @@ void C2_MacroAssembler::string_indexof(Register str2, Register str1,
   // if (substr.count == 0) return 0;
 
   // We have two strings, a source string in str2, cnt2 and a pattern string
-  // in str1, cnt1. Find the 1st occurence of pattern in source or return -1.
+  // in str1, cnt1. Find the 1st occurrence of pattern in source or return -1.
 
   // For larger pattern and source we use a simplified Boyer Moore algorithm.
   // With a small pattern and source we use linear scan.