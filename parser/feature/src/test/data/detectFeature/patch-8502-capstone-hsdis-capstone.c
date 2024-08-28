@@ -50,6 +50,7 @@
 */
 
 #include <inttypes.h>
+#include <string.h>
 
 #include <capstone.h>
 
@@ -81,14 +82,46 @@ static void* xml_event_callback(void* stream, const char* event, void* arg) {
   return NULL;
 }
 
+static const char* INTEL_SYNTAX_OP = "intel";
+
+typedef struct {
+  bool intel_syntax;
+} Options;
+
+static Options parse_options(const char* options, printf_callback_t printf_callback, void* printf_stream) {
+  Options ops;
+  // initialize with defaults
+  ops.intel_syntax = false;
+
+  const char* cursor = options;
+  while (*cursor != '\0') {
+    if (*cursor == ',') {
+      cursor++;
+    }
+    if (strncmp(cursor, INTEL_SYNTAX_OP, strlen(INTEL_SYNTAX_OP)) == 0) {
+      cursor += strlen(INTEL_SYNTAX_OP);
+      ops.intel_syntax = true;
+    } else {
+      const char* end = strchr(cursor, ',');
+      if (end == NULL) {
+        end = strchr(cursor, '\0');
+      }
+      print("Unknown PrintAssembly option: %.*s\n", (int) (end - cursor), cursor);
+      cursor = end;
+    }
+  }
+
+  return ops;
+}
+
 #ifdef _WIN32
 __declspec(dllexport)
 #endif
 void* decode_instructions_virtual(uintptr_t start_va, uintptr_t end_va,
                                   unsigned char* buffer, uintptr_t length,
-                                  void* (*event_callback)(void*, const char*, void*),
+                                  event_callback_t event_callback,
                                   void* event_stream,
-                                  int (*printf_callback)(void*, const char*, ...),
+                                  printf_callback_t printf_callback,
                                   void* printf_stream,
                                   const char* options,
                                   int newline /* bool value for nice new line */) {
@@ -114,8 +147,8 @@ void* decode_instructions_virtual(uintptr_t start_va, uintptr_t end_va,
     return NULL;
   }
 
-  // TODO: Support intel syntax
-  cs_option(cs_handle, CS_OPT_SYNTAX, CS_OPT_SYNTAX_ATT);
+  Options ops = parse_options(options, printf_callback, printf_stream);
+  cs_option(cs_handle, CS_OPT_SYNTAX, ops.intel_syntax ? CS_OPT_SYNTAX_INTEL : CS_OPT_SYNTAX_ATT);
 
   cs_insn *insn;
   size_t count = cs_disasm(cs_handle, buffer, length, (uintptr_t) buffer, 0 , &insn);