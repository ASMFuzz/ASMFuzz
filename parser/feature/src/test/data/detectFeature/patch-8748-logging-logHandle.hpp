@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -32,35 +32,35 @@
 // polluting the surrounding API with template functions.
 class LogHandle {
 private:
-  LogTagSet* const _tagset;
+  LogTagSet& _tagset;
 
 public:
   template <LogTagType T0, LogTagType T1, LogTagType T2, LogTagType T3, LogTagType T4, LogTagType GuardTag>
-  LogHandle(const LogImpl<T0, T1, T2, T3, T4, GuardTag>& type_carrier) :
-      _tagset(&LogTagSetMapping<T0, T1, T2, T3, T4>::tagset()) {}
+  LogHandle(const LogImpl<T0, T1, T2, T3, T4, GuardTag>& type_carrier)
+    : _tagset(LogTagSetMapping<T0, T1, T2, T3, T4>::tagset()) {}
 
   bool is_level(LogLevelType level) {
-    return _tagset->is_level(level);
+    return _tagset.is_level(level);
   }
 
-  LogTagSet* const tagset() const {
+  LogTagSet& tagset() const {
     return _tagset;
   }
 
 #define LOG_LEVEL(level, name) ATTRIBUTE_PRINTF(2, 0)   \
   LogHandle& v##name(const char* fmt, va_list args) { \
-    _tagset->vwrite(LogLevel::level, fmt, args); \
+    _tagset.vwrite(LogLevel::level, fmt, args); \
     return *this; \
   } \
   LogHandle& name(const char* fmt, ...) ATTRIBUTE_PRINTF(2, 3) { \
     va_list args; \
     va_start(args, fmt); \
-    _tagset->vwrite(LogLevel::level, fmt, args); \
+    _tagset.vwrite(LogLevel::level, fmt, args); \
     va_end(args); \
     return *this; \
   } \
   bool is_##name() { \
-    return _tagset->is_level(LogLevel::level); \
+    return _tagset.is_level(LogLevel::level); \
   }
   LOG_LEVEL_LIST
 #undef LOG_LEVEL
@@ -73,15 +73,17 @@ class LogHandle {
 class LogTargetHandle {
 private:
   const LogLevelType _level;
-  LogTagSet* const   _tagset;
+  LogTagSet&         _tagset;
 
 public:
-  LogTargetHandle(LogLevelType level, LogTagSet* const tagset) : _level(level), _tagset(tagset) {}
+  LogTargetHandle(LogLevelType level, LogTagSet& tagset)
+    : _level(level),
+      _tagset(tagset) {}
 
   template <LogLevelType level, LogTagType T0, LogTagType T1, LogTagType T2, LogTagType T3, LogTagType T4, LogTagType GuardTag>
-  LogTargetHandle(const LogTargetImpl<level, T0, T1, T2, T3, T4, GuardTag>& type_carrier) :
-      _level(level),
-      _tagset(&LogTagSetMapping<T0, T1, T2, T3, T4>::tagset()) {}
+  LogTargetHandle(const LogTargetImpl<level, T0, T1, T2, T3, T4, GuardTag>& type_carrier)
+    : _level(level),
+      _tagset(LogTagSetMapping<T0, T1, T2, T3, T4>::tagset()) {}
 
   template <LogLevelType level, LogTagType T0, LogTagType T1, LogTagType T2, LogTagType T3, LogTagType T4, LogTagType GuardTag>
   static LogTargetHandle create() {
@@ -92,15 +94,14 @@ class LogTargetHandle {
     va_list args;
     va_start(args, fmt);
     if (is_enabled()) {
-      _tagset->vwrite(_level, fmt, args);
+      _tagset.vwrite(_level, fmt, args);
     }
     va_end(args);
   }
 
   bool is_enabled() const {
-    return _tagset->is_level(_level);
+    return _tagset.is_level(_level);
   }
-
 };
 
 #endif // SHARE_LOGGING_LOGHANDLE_HPP