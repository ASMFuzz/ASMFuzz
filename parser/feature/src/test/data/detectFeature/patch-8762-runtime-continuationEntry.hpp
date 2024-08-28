@@ -37,11 +37,18 @@ class JavaThread;
 
 // Metadata stored in the continuation entry frame
 class ContinuationEntry {
-public:
 #ifdef ASSERT
+private:
+  static const int COOKIE_VALUE = 0x1234;
   int cookie;
+
+public:
+  static int cookie_value() { return COOKIE_VALUE; }
   static ByteSize cookie_offset() { return byte_offset_of(ContinuationEntry, cookie); }
-  void verify_cookie() { assert(this->cookie == 0x1234, ""); }
+
+  void verify_cookie() {
+    assert(cookie == COOKIE_VALUE, "Bad cookie: %#x, expected: %#x", cookie, COOKIE_VALUE);
+  }
 #endif
 
 public: