@@ -27,6 +27,7 @@
 
 #include "code/oopRecorder.hpp"
 #include "code/relocInfo.hpp"
+#include "compiler/compiler_globals.hpp"
 #include "utilities/align.hpp"
 #include "utilities/debug.hpp"
 #include "utilities/macros.hpp"
@@ -251,16 +252,19 @@ class CodeSection {
   void relocate(address at, RelocationHolder const& rspec, int format = 0);
   void relocate(address at,    relocInfo::relocType rtype, int format = 0, jint method_index = 0);
 
-  // alignment requirement for starting offset
-  // Requirements are that the instruction area and the
-  // stubs area must start on CodeEntryAlignment, and
-  // the ctable on sizeof(jdouble)
-  int alignment() const             { return MAX2((int)sizeof(jdouble), (int)CodeEntryAlignment); }
+  static int alignment(int section);
+  int alignment() { return alignment(_index); }
 
   // Slop between sections, used only when allocating temporary BufferBlob buffers.
   static csize_t end_slop()         { return MAX2((int)sizeof(jdouble), (int)CodeEntryAlignment); }
 
-  csize_t align_at_start(csize_t off) const { return (csize_t) align_up(off, alignment()); }
+  csize_t align_at_start(csize_t off, int section) const {
+    return (csize_t) align_up(off, alignment(section));
+  }
+
+  csize_t align_at_start(csize_t off) const {
+    return (csize_t) align_up(off, alignment(_index));
+  }
 
   // Ensure there's enough space left in the current section.
   // Return true if there was an expansion.
@@ -702,4 +706,19 @@ inline bool CodeSection::maybe_expand_to_ensure_remaining(csize_t amount) {
   return false;
 }
 
+inline int CodeSection::alignment(int section) {
+  if (section == CodeBuffer::SECT_CONSTS) {
+    return (int) sizeof(jdouble);
+  }
+  if (section == CodeBuffer::SECT_INSTS) {
+    return (int) CodeEntryAlignment;
+  }
+  if (CodeBuffer::SECT_STUBS) {
+    // CodeBuffer installer expects sections to be HeapWordSize aligned
+    return HeapWordSize;
+  }
+  ShouldNotReachHere();
+  return 0;
+}
+
 #endif // SHARE_ASM_CODEBUFFER_HPP