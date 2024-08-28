@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -72,7 +72,7 @@ class StringTable : public CHeapObj<mtSymbol>{
   static oop do_intern(Handle string_or_null, const jchar* name, int len, uintx hash, TRAPS);
   static oop do_lookup(const jchar* name, int len, uintx hash);
 
-  static void print_table_statistics(outputStream* st, const char* table_name);
+  static void print_table_statistics(outputStream* st);
 
   static bool do_rehash();
 