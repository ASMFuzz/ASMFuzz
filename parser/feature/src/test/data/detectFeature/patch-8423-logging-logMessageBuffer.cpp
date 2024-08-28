@@ -110,8 +110,14 @@ void LogMessageBuffer::vwrite(LogLevelType level, const char* fmt, va_list args)
 
     va_list copy;
     va_copy(copy, args);
-    written += (size_t)os::vsnprintf(current_buffer_position, remaining_buffer_length, fmt, copy) + 1;
+    int ret = os::vsnprintf(current_buffer_position, remaining_buffer_length, fmt, copy);
     va_end(copy);
+    assert(ret >= 0, "Log message buffer issue");
+    if (ret < 0) {
+      this->write(level, "%s", "Log message buffer issue");
+      return;
+    }
+    written += (size_t)ret + 1;
     if (written > _message_buffer_capacity - _message_buffer_size) {
       assert(attempts == 0, "Second attempt should always have a sufficiently large buffer (resized to fit).");
       grow(_message_buffer, _message_buffer_capacity, _message_buffer_size + written);