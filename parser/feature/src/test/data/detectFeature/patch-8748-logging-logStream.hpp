@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -27,14 +27,17 @@
 
 #include "logging/log.hpp"
 #include "logging/logHandle.hpp"
+#include "logging/logMessage.hpp"
 #include "utilities/ostream.hpp"
 
-
-class LogStream : public outputStream {
-  // see test/hotspot/gtest/logging/test_logStream.cpp
+class LogStreamImplBase : public outputStream {
   friend class LogStreamTest_TestLineBufferAllocation_vm_Test;
   friend class LogStreamTest_TestLineBufferAllocationCap_vm_Test;
 
+  // No heap allocation of LogStream.
+  static void* operator new   (size_t) = delete;
+  static void* operator new[] (size_t) = delete;
+
   // Helper class, maintains the line buffer. For small line lengths,
   // we avoid malloc and use a fixed sized member char array. If LogStream
   // is allocated on the stack, this means small lines are assembled
@@ -44,60 +47,83 @@ class LogStream : public outputStream {
     char* _buf;
     size_t _cap;
     size_t _pos;
-    void try_ensure_cap(size_t cap);
+    bool try_ensure_cap(size_t cap);
+
   public:
     LineBuffer();
     ~LineBuffer();
-    bool is_empty() const { return _pos == 0; }
-    const char* buffer() const { return _buf; }
+    bool is_empty() const {
+      return _pos == 0;
+    }
+    const char* buffer() const {
+      return _buf;
+    }
     void append(const char* s, size_t len);
     void reset();
   };
-  LineBuffer  _current_line;
-  LogTargetHandle _log_handle;
 
-  // Prevent operator new for LogStream.
-  static void* operator new (size_t);
-  static void* operator new[] (size_t);
+protected:
+  LineBuffer _current_line;
+};
+
+template <typename BackingLog>
+class LogStreamImpl : public LogStreamImplBase {
+private:
+  BackingLog _backing_log;
+
+public:
+  explicit LogStreamImpl(BackingLog bl)
+    : _backing_log(bl) {};
+
+  ~LogStreamImpl() override;
+
+  bool is_enabled() {
+    return _backing_log.is_enabled();
+  }
+
+  void write(const char* s, size_t len) override;
+};
+
+class LogStream : public LogStreamImpl<LogTargetHandle> {
+  // see test/hotspot/gtest/logging/test_logStream.cpp
+  friend class LogStreamTest_TestLineBufferAllocation_vm_Test;
+  friend class LogStreamTest_TestLineBufferAllocationCap_vm_Test;
+
+  NONCOPYABLE(LogStream);
 
 public:
   // Constructor to support creation from a LogTarget instance.
   //
   // LogTarget(Debug, gc) log;
   // LogStream(log) stream;
   template <LogLevelType level, LogTagType T0, LogTagType T1, LogTagType T2, LogTagType T3, LogTagType T4, LogTagType GuardTag>
-  LogStream(const LogTargetImpl<level, T0, T1, T2, T3, T4, GuardTag>& type_carrier) :
-      _log_handle(level, &LogTagSetMapping<T0, T1, T2, T3, T4>::tagset()) {}
+  LogStream(const LogTargetImpl<level, T0, T1, T2, T3, T4, GuardTag>& type_carrier)
+    : LogStreamImpl(LogTargetHandle(level, LogTagSetMapping<T0, T1, T2, T3, T4>::tagset())) {}
 
   // Constructor to support creation from typed (likely NULL) pointer. Mostly used by the logging framework.
   //
   // LogStream stream(log.debug());
   //  or
   // LogStream stream((LogTargetImpl<level, T0, T1, T2, T3, T4, GuardTag>*)NULL);
   template <LogLevelType level, LogTagType T0, LogTagType T1, LogTagType T2, LogTagType T3, LogTagType T4, LogTagType GuardTag>
-  LogStream(const LogTargetImpl<level, T0, T1, T2, T3, T4, GuardTag>* type_carrier) :
-      _log_handle(level, &LogTagSetMapping<T0, T1, T2, T3, T4>::tagset()) {}
-
-  // Destructor writes any unfinished output left in the line buffer.
-  ~LogStream();
+  LogStream(const LogTargetImpl<level, T0, T1, T2, T3, T4, GuardTag>* type_carrier)
+    : LogStreamImpl(LogTargetHandle(level, LogTagSetMapping<T0, T1, T2, T3, T4>::tagset())) {}
 
   // Constructor to support creation from a LogTargetHandle.
   //
   // LogTarget(Debug, gc) log;
   // LogTargetHandle(log) handle;
   // LogStream stream(handle);
-  LogStream(LogTargetHandle handle) : _log_handle(handle) {}
+  LogStream(LogTargetHandle handle)
+    : LogStreamImpl(handle) {}
 
   // Constructor to support creation from a log level and tagset.
   //
   // LogStream(level, tageset);
-  LogStream(LogLevelType level, LogTagSet* const tagset) : _log_handle(level, tagset) {}
-
-  bool is_enabled() const {
-    return _log_handle.is_enabled();
-  }
+  LogStream(LogLevelType level, LogTagSet& tagset)
+    : LogStreamImpl(LogTargetHandle(level, tagset)) {}
 
-  void write(const char* s, size_t len);
+  // Destructor writes any unfinished output left in the line buffer.
 };
 
 // Support creation of a LogStream without having to provide a LogTarget pointer.
@@ -106,7 +132,36 @@ class LogStream : public outputStream {
 template <LogLevelType level, LogTagType T0, LogTagType T1, LogTagType T2, LogTagType T3, LogTagType T4, LogTagType GuardTag>
 class LogStreamTemplate : public LogStream {
 public:
-  LogStreamTemplate() : LogStream((LogTargetImpl<level, T0, T1, T2, T3, T4, GuardTag>*)NULL) {}
+  LogStreamTemplate()
+    : LogStream((LogTargetImpl<level, T0, T1, T2, T3, T4, GuardTag>*)NULL) {}
+};
+
+class LogMessageHandle {
+  const LogLevelType _level;
+  LogMessageImpl& _lm;
+
+public:
+  LogMessageHandle(const LogLevelType level, LogMessageImpl& lm)
+    : _level(level), _lm(lm) {}
+
+  bool is_enabled() {
+    return _lm.is_level(_level);
+  }
+
+  void print(const char* fmt, ...) ATTRIBUTE_PRINTF(2, 3) {
+    va_list args;
+    va_start(args, fmt);
+    if (is_enabled()) {
+      _lm.vwrite(_level, fmt, args);
+    }
+    va_end(args);
+  }
+};
+
+class NonInterleavingLogStream : public LogStreamImpl<LogMessageHandle> {
+public:
+  NonInterleavingLogStream(LogLevelType level, LogMessageImpl& lm)
+    : LogStreamImpl(LogMessageHandle(level, lm)) {}
 };
 
 #endif // SHARE_LOGGING_LOGSTREAM_HPP