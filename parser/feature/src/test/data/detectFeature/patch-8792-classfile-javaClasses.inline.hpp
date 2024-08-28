@@ -326,12 +326,12 @@ inline void jdk_internal_vm_StackChunk::set_sp(HeapWord* chunk, int value) {
   *(int*)(((char*)chunk) + _sp_offset) = (int)value;
 }
 
-inline intptr_t jdk_internal_vm_StackChunk::pc(oop chunk) {
-  return chunk->long_field(_pc_offset);
+inline address jdk_internal_vm_StackChunk::pc(oop chunk) {
+  return chunk->address_field(_pc_offset);
 }
 
-inline void jdk_internal_vm_StackChunk::set_pc(oop chunk, intptr_t value) {
-  chunk->long_field_put(_pc_offset, value);
+inline void jdk_internal_vm_StackChunk::set_pc(oop chunk, address value) {
+  chunk->address_field_put(_pc_offset, value);
 }
 
 inline int jdk_internal_vm_StackChunk::argsize(oop chunk) {