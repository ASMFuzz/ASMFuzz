@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -535,10 +535,17 @@ TableStatistics SymbolTable::get_table_statistics() {
   return ts;
 }
 
-void SymbolTable::print_table_statistics(outputStream* st,
-                                         const char* table_name) {
+void SymbolTable::print_table_statistics(outputStream* st) {
   SizeFunc sz;
-  _local_table->statistics_to(Thread::current(), sz, st, table_name);
+  _local_table->statistics_to(Thread::current(), sz, st, "SymbolTable");
+
+  if (!_shared_table.empty()) {
+    _shared_table.print_table_statistics(st, "Shared Symbol Table");
+  }
+
+  if (!_dynamic_shared_table.empty()) {
+    _dynamic_shared_table.print_table_statistics(st, "Dynamic Shared Symbol Table");
+  }
 }
 
 // Verification
@@ -562,6 +569,14 @@ void SymbolTable::verify() {
   }
 }
 
+static void print_symbol(outputStream* st, Symbol* sym) {
+  const char* utf8_string = (const char*)sym->bytes();
+  int utf8_length = sym->utf8_length();
+  st->print("%d %d: ", utf8_length, sym->refcount());
+  HashtableTextDump::put_utf8(st, utf8_string, utf8_length);
+  st->cr();
+}
+
 // Dumping
 class DumpSymbol : StackObj {
   Thread* _thr;
@@ -571,19 +586,24 @@ class DumpSymbol : StackObj {
   bool operator()(Symbol** value) {
     assert(value != NULL, "expected valid value");
     assert(*value != NULL, "value should point to a symbol");
-    Symbol* sym = *value;
-    const char* utf8_string = (const char*)sym->bytes();
-    int utf8_length = sym->utf8_length();
-    _st->print("%d %d: ", utf8_length, sym->refcount());
-    HashtableTextDump::put_utf8(_st, utf8_string, utf8_length);
-    _st->cr();
+    print_symbol(_st, *value);
     return true;
   };
 };
 
+class DumpSharedSymbol : StackObj {
+  outputStream* _st;
+public:
+  DumpSharedSymbol(outputStream* st) : _st(st) {}
+  void do_value(Symbol* value) {
+    assert(value != NULL, "value should point to a symbol");
+    print_symbol(_st, value);
+  };
+};
+
 void SymbolTable::dump(outputStream* st, bool verbose) {
   if (!verbose) {
-    print_table_statistics(st, "SymbolTable");
+    print_table_statistics(st);
   } else {
     Thread* thr = Thread::current();
     ResourceMark rm(thr);
@@ -592,6 +612,20 @@ void SymbolTable::dump(outputStream* st, bool verbose) {
     if (!_local_table->try_scan(thr, ds)) {
       log_info(symboltable)("dump unavailable at this moment");
     }
+    if (!_shared_table.empty()) {
+      st->print_cr("#----------------");
+      st->print_cr("# Shared symbols:");
+      st->print_cr("#----------------");
+      DumpSharedSymbol dss(st);
+      _shared_table.iterate(&dss);
+    }
+    if (!_dynamic_shared_table.empty()) {
+      st->print_cr("#------------------------");
+      st->print_cr("# Dynamic shared symbols:");
+      st->print_cr("#------------------------");
+      DumpSharedSymbol dss(st);
+      _dynamic_shared_table.iterate(&dss);
+    }
   }
 }
 