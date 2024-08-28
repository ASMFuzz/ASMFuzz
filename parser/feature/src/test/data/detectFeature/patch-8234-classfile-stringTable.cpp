@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -584,10 +584,14 @@ TableStatistics StringTable::get_table_statistics() {
   return ts;
 }
 
-void StringTable::print_table_statistics(outputStream* st,
-                                         const char* table_name) {
+void StringTable::print_table_statistics(outputStream* st) {
   SizeFunc sz;
-  _local_table->statistics_to(Thread::current(), sz, st, table_name);
+  _local_table->statistics_to(Thread::current(), sz, st, "StringTable");
+#if INCLUDE_CDS_JAVA_HEAP
+  if (!_shared_table.empty()) {
+    _shared_table.print_table_statistics(st, "Shared String Table");
+  }
+#endif
 }
 
 // Verification
@@ -650,6 +654,32 @@ size_t StringTable::verify_and_compare_entries() {
   return vcs._errors;
 }
 
+static void print_string(Thread* current, outputStream* st, oop s) {
+  typeArrayOop value     = java_lang_String::value_no_keepalive(s);
+  int          length    = java_lang_String::length(s);
+  bool         is_latin1 = java_lang_String::is_latin1(s);
+
+  if (length <= 0) {
+    st->print("%d: ", length);
+  } else {
+    ResourceMark rm(current);
+    int utf8_length = length;
+    char* utf8_string;
+
+    if (!is_latin1) {
+      jchar* chars = value->char_at_addr(0);
+      utf8_string = UNICODE::as_utf8(chars, utf8_length);
+    } else {
+      jbyte* bytes = value->byte_at_addr(0);
+      utf8_string = UNICODE::as_utf8(bytes, utf8_length);
+    }
+
+    st->print("%d: ", utf8_length);
+    HashtableTextDump::put_utf8(st, utf8_string, utf8_length);
+  }
+  st->cr();
+}
+
 // Dumping
 class PrintString : StackObj {
   Thread* _thr;
@@ -661,36 +691,27 @@ class PrintString : StackObj {
     if (s == NULL) {
       return true;
     }
-    typeArrayOop value     = java_lang_String::value_no_keepalive(s);
-    int          length    = java_lang_String::length(s);
-    bool         is_latin1 = java_lang_String::is_latin1(s);
-
-    if (length <= 0) {
-      _st->print("%d: ", length);
-    } else {
-      ResourceMark rm(_thr);
-      int utf8_length = length;
-      char* utf8_string;
-
-      if (!is_latin1) {
-        jchar* chars = value->char_at_addr(0);
-        utf8_string = UNICODE::as_utf8(chars, utf8_length);
-      } else {
-        jbyte* bytes = value->byte_at_addr(0);
-        utf8_string = UNICODE::as_utf8(bytes, utf8_length);
-      }
+    print_string(_thr, _st, s);
+    return true;
+  };
+};
 
-      _st->print("%d: ", utf8_length);
-      HashtableTextDump::put_utf8(_st, utf8_string, utf8_length);
+class PrintSharedString : StackObj {
+  Thread* _thr;
+  outputStream* _st;
+public:
+  PrintSharedString(Thread* thr, outputStream* st) : _thr(thr), _st(st) {}
+  void do_value(oop s) {
+    if (s == NULL) {
+      return;
     }
-    _st->cr();
-    return true;
+    print_string(_thr, _st, s);
   };
 };
 
 void StringTable::dump(outputStream* st, bool verbose) {
   if (!verbose) {
-    print_table_statistics(st, "StringTable");
+    print_table_statistics(st);
   } else {
     Thread* thr = Thread::current();
     ResourceMark rm(thr);
@@ -699,6 +720,15 @@ void StringTable::dump(outputStream* st, bool verbose) {
     if (!_local_table->try_scan(thr, ps)) {
       st->print_cr("dump unavailable at this moment");
     }
+#if INCLUDE_CDS_JAVA_HEAP
+    if (!_shared_table.empty()) {
+      st->print_cr("#----------------");
+      st->print_cr("# Shared strings:");
+      st->print_cr("#----------------");
+      PrintSharedString pss(thr, st);
+      _shared_table.iterate(&pss);
+    }
+#endif
   }
 }
 