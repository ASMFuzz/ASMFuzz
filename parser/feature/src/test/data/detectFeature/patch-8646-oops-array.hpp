@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -91,30 +91,40 @@ class Array: public MetaspaceObj {
   Array(int length, T init) : _length(length) {
     assert(length >= 0, "illegal length");
     for (int i = 0; i < length; i++) {
-      _data[i] = init;
+      data()[i] = init;
     }
   }
 
  public:
 
   // standard operations
   int  length() const                 { return _length; }
-  T* data()                           { return _data; }
+
+  T* data() {
+    return reinterpret_cast<T*>(
+      reinterpret_cast<char*>(this) + base_offset_in_bytes());
+  }
+
+  const T* data() const {
+    return reinterpret_cast<const T*>(
+      reinterpret_cast<const char*>(this) + base_offset_in_bytes());
+  }
+
   bool is_empty() const               { return length() == 0; }
 
   int index_of(const T& x) const {
     int i = length();
-    while (i-- > 0 && _data[i] != x) ;
+    while (i-- > 0 && data()[i] != x) ;
 
     return i;
   }
 
   // sort the array.
   bool contains(const T& x) const      { return index_of(x) >= 0; }
 
-  T    at(int i) const                 { assert(i >= 0 && i< _length, "oob: 0 <= %d < %d", i, _length); return _data[i]; }
-  void at_put(const int i, const T& x) { assert(i >= 0 && i< _length, "oob: 0 <= %d < %d", i, _length); _data[i] = x; }
-  T*   adr_at(const int i)             { assert(i >= 0 && i< _length, "oob: 0 <= %d < %d", i, _length); return &_data[i]; }
+  T    at(int i) const                 { assert(i >= 0 && i< _length, "oob: 0 <= %d < %d", i, _length); return data()[i]; }
+  void at_put(const int i, const T& x) { assert(i >= 0 && i< _length, "oob: 0 <= %d < %d", i, _length); data()[i] = x; }
+  T*   adr_at(const int i)             { assert(i >= 0 && i< _length, "oob: 0 <= %d < %d", i, _length); return &data()[i]; }
   int  find(const T& x)                { return index_of(x); }
 
   T at_acquire(const int i)            { return Atomic::load_acquire(adr_at(i)); }