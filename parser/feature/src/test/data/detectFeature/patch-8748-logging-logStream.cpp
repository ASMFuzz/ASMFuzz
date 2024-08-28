@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -23,18 +23,16 @@
  */
 
 #include "precompiled.hpp"
-#include "logging/log.hpp"
 #include "logging/logStream.hpp"
 #include "runtime/os.hpp"
 #include "utilities/align.hpp"
 
-LogStream::LineBuffer::LineBuffer()
- : _buf(_smallbuf), _cap(sizeof(_smallbuf)), _pos(0)
-{
+LogStreamImplBase::LineBuffer::LineBuffer()
+  : _buf(_smallbuf), _cap(sizeof(_smallbuf)), _pos(0) {
   _buf[0] = '\0';
 }
 
-LogStream::LineBuffer::~LineBuffer() {
+LogStreamImplBase::LineBuffer::~LineBuffer() {
   assert(_pos == 0, "still outstanding bytes in the line buffer");
   if (_buf != _smallbuf) {
     os::free(_buf);
@@ -43,51 +41,56 @@ LogStream::LineBuffer::~LineBuffer() {
 
 // try_ensure_cap tries to enlarge the capacity of the internal buffer
 // to the given atleast value. May fail if either OOM happens or atleast
-// is larger than a reasonable max of 1 M. Caller must not assume
-// capacity without checking.
-void LogStream::LineBuffer::try_ensure_cap(size_t atleast) {
+// is larger than a reasonable max of 1 M.
+// Returns whether the capacity is at least atleast bytes.
+bool LogStreamImplBase::LineBuffer::try_ensure_cap(size_t atleast) {
+  // Cap out at a reasonable max to prevent runaway leaks.
+  const size_t reasonable_max = 1 * M;
+
   assert(_cap >= sizeof(_smallbuf), "sanity");
-  if (_cap < atleast) {
-    // Cap out at a reasonable max to prevent runaway leaks.
-    const size_t reasonable_max = 1 * M;
-    assert(_cap <= reasonable_max, "sanity");
-    if (_cap == reasonable_max) {
-      return;
-    }
+  assert(_cap <= reasonable_max, "sanity");
 
-    const size_t additional_expansion = 256;
-    size_t newcap = align_up(atleast + additional_expansion, additional_expansion);
-    if (newcap > reasonable_max) {
-      log_info(logging)("Suspiciously long log line: \"%.100s%s",
-              _buf, (_pos >= 100 ? "..." : ""));
-      newcap = reasonable_max;
-    }
+  if (_cap >= atleast) {
+    return true;
+  }
+  if (_cap == reasonable_max) {
+    return false;
+  }
 
-    char* const newbuf = (char*) os::malloc(newcap, mtLogging);
-    if (newbuf == NULL) { // OOM. Leave object unchanged.
-      return;
-    }
-    if (_pos > 0) { // preserve old content
-      memcpy(newbuf, _buf, _pos + 1); // ..including trailing zero
-    }
-    if (_buf != _smallbuf) {
-      os::free(_buf);
-    }
-    _buf = newbuf;
-    _cap = newcap;
+  const size_t additional_expansion = 256;
+  size_t newcap = align_up(atleast + additional_expansion, additional_expansion);
+
+  if (newcap > reasonable_max) {
+    log_info(logging)("Suspiciously long log line: \"%.100s%s",
+                      _buf, (_pos >= 100 ? "..." : ""));
+    newcap = reasonable_max;
+  }
+
+  char* const newbuf = (char*)os::malloc(newcap, mtLogging);
+  if (newbuf == NULL) { // OOM. Leave object unchanged.
+    return false;
+  }
+  if (_pos > 0) { // preserve old content
+    memcpy(newbuf, _buf, _pos + 1); // ..including trailing zero
   }
-  assert(_cap >= atleast, "sanity");
+  if (_buf != _smallbuf) {
+    os::free(_buf);
+  }
+  _buf = newbuf;
+  _cap = newcap;
+
+  return _cap >= atleast;
 }
 
-void LogStream::LineBuffer::append(const char* s, size_t len) {
+void LogStreamImplBase::LineBuffer::append(const char* s, size_t len) {
   assert(_buf[_pos] == '\0', "sanity");
   assert(_pos < _cap, "sanity");
   const size_t minimum_capacity_needed = _pos + len + 1;
-  try_ensure_cap(minimum_capacity_needed);
+  const bool has_capacity = try_ensure_cap(minimum_capacity_needed);
   // try_ensure_cap may not have enlarged the capacity to the full requested
-  // extend or may have not worked at all. In that case, just gracefully work
+  // extent or may have not worked at all. In that case, just gracefully work
   // with what we have already; just truncate if necessary.
-  if (_cap < minimum_capacity_needed) {
+  if (!has_capacity) {
     len = _cap - _pos - 1;
     if (len == 0) {
       return;
@@ -98,28 +101,30 @@ void LogStream::LineBuffer::append(const char* s, size_t len) {
   _buf[_pos] = '\0';
 }
 
-void LogStream::LineBuffer::reset() {
+void LogStreamImplBase::LineBuffer::reset() {
   _pos = 0;
   _buf[_pos] = '\0';
 }
 
-void LogStream::write(const char* s, size_t len) {
+template <typename BackingLog>
+LogStreamImpl<BackingLog>::~LogStreamImpl() {
+  if (!_current_line.is_empty()) {
+    _backing_log.print("%s", _current_line.buffer());
+    _current_line.reset();
+  }
+}
+
+template <typename BackingLog>
+void LogStreamImpl<BackingLog>::write(const char* s, size_t len) {
   if (len > 0 && s[len - 1] == '\n') {
     _current_line.append(s, len - 1); // omit the newline.
-    _log_handle.print("%s", _current_line.buffer());
+    _backing_log.print("%s", _current_line.buffer());
     _current_line.reset();
   } else {
     _current_line.append(s, len);
   }
   update_position(s, len);
 }
 
-// Destructor writes any unfinished output left in the line buffer.
-LogStream::~LogStream() {
-  if (_current_line.is_empty() == false) {
-    _log_handle.print("%s", _current_line.buffer());
-    _current_line.reset();
-  }
-}
-
-
+template class LogStreamImpl<LogTargetHandle>;
+template class LogStreamImpl<LogMessageHandle>;