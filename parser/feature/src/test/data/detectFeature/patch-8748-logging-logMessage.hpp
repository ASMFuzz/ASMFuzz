@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -57,19 +57,19 @@
 // Log outputs on debug level will see the debug message,
 // but not the trace message.
 //
-#define LogMessage(...) LogMessageImpl<LOG_TAGS(__VA_ARGS__)>
-template <LogTagType T0, LogTagType T1 = LogTag::__NO_TAG, LogTagType T2 = LogTag::__NO_TAG,
-          LogTagType T3 = LogTag::__NO_TAG, LogTagType T4 = LogTag::__NO_TAG, LogTagType GuardTag = LogTag::__NO_TAG>
+#define LogMessage(...) LogMessageTemplate<LOG_TAGS(__VA_ARGS__)>
+
 class LogMessageImpl : public LogMessageBuffer {
- private:
-  bool _has_content;
+private:
   LogTagSet& _tagset;
- public:
-  LogMessageImpl() :
-    _has_content(false),
-    _tagset(LogTagSetMapping<T0, T1, T2, T3, T4, GuardTag>::tagset())
-  {}
+  bool _has_content;
+
+protected:
+  LogMessageImpl(LogTagSet& tagset)
+    : _tagset(tagset),
+      _has_content(false) {};
 
+public:
   ~LogMessageImpl() {
     if (_has_content) {
       flush();
@@ -90,11 +90,15 @@ class LogMessageImpl : public LogMessageBuffer {
   void vwrite(LogLevelType level, const char* fmt, va_list args) {
     if (!_has_content) {
       _has_content = true;
-      set_prefix(LogPrefix<T0, T1, T2, T3, T4>::prefix);
+      set_prefix(_tagset.write_prefix());
     }
     LogMessageBuffer::vwrite(level, fmt, args);
   }
 
+  bool is_level(LogLevelType level) const {
+    return _tagset.is_level(level);
+  }
+
 #define LOG_LEVEL(level, name) \
   bool is_##name() const { \
     return _tagset.is_level(LogLevel::level); \
@@ -103,4 +107,13 @@ class LogMessageImpl : public LogMessageBuffer {
 #undef LOG_LEVEL
 };
 
+template <LogTagType T0, LogTagType T1 = LogTag::__NO_TAG, LogTagType T2 = LogTag::__NO_TAG, LogTagType T3 = LogTag::__NO_TAG,
+          LogTagType T4 = LogTag::__NO_TAG, LogTagType GuardTag = LogTag::__NO_TAG>
+class LogMessageTemplate : public LogMessageImpl {
+public:
+  LogMessageTemplate(LogMessageTemplate&&) = default;
+  LogMessageTemplate()
+    : LogMessageImpl(LogTagSetMapping<T0, T1, T2, T3, T4>::tagset()) {}
+};
+
 #endif // SHARE_LOGGING_LOGMESSAGE_HPP