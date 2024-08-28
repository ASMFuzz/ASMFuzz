@@ -879,6 +879,14 @@ void VMError::report(outputStream* st, bool _verbose) {
        st->cr();
      }
 
+  STEP("printing registers")
+
+     // printing registers
+     if (_verbose && _context) {
+       os::print_context(st, _context);
+       st->cr();
+     }
+
   STEP("printing register info")
 
      // decode register contents if possible
@@ -888,11 +896,11 @@ void VMError::report(outputStream* st, bool _verbose) {
        st->cr();
      }
 
-  STEP("printing registers, top of stack, instructions near pc")
+  STEP("printing top of stack, instructions near pc")
 
-     // registers, top of stack, instructions near pc
+     // printing top of stack, instructions near pc
      if (_verbose && _context) {
-       os::print_context(st, _context);
+       os::print_tos_pc(st, _context);
        st->cr();
      }
 