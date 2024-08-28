@@ -57,8 +57,8 @@ inline int stackChunkOopDesc::stack_size() const        { return jdk_internal_vm
 inline int stackChunkOopDesc::sp() const                { return jdk_internal_vm_StackChunk::sp(as_oop()); }
 inline void stackChunkOopDesc::set_sp(int value)        { jdk_internal_vm_StackChunk::set_sp(this, value); }
 
-inline address stackChunkOopDesc::pc() const            { return (address)jdk_internal_vm_StackChunk::pc(as_oop()); }
-inline void stackChunkOopDesc::set_pc(address value)    { jdk_internal_vm_StackChunk::set_pc(this, (intptr_t)value); }
+inline address stackChunkOopDesc::pc() const            { return jdk_internal_vm_StackChunk::pc(as_oop()); }
+inline void stackChunkOopDesc::set_pc(address value)    { jdk_internal_vm_StackChunk::set_pc(this, value); }
 
 inline int stackChunkOopDesc::argsize() const           { return jdk_internal_vm_StackChunk::argsize(as_oop()); }
 inline void stackChunkOopDesc::set_argsize(int value)   { jdk_internal_vm_StackChunk::set_argsize(as_oop(), value); }