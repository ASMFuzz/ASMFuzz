@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -146,7 +146,7 @@ class SymbolTable : public AllStatic {
   static Arena*  _arena;
   static Arena* arena() { return _arena; }  // called for statistics
 
-  static void print_table_statistics(outputStream* st, const char* table_name);
+  static void print_table_statistics(outputStream* st);
 
   static void try_rehash_table();
   static bool do_rehash();