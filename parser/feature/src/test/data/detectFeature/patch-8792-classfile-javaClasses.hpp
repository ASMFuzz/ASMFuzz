@@ -1168,8 +1168,8 @@ class jdk_internal_vm_StackChunk: AllStatic {
   static inline int sp(oop chunk);
   static inline void set_sp(oop chunk, int value);
   static inline void set_sp(HeapWord* chunk, int value); // used while allocating
-  static inline intptr_t pc(oop chunk);
-  static inline void set_pc(oop chunk, intptr_t value);
+  static inline address pc(oop chunk);
+  static inline void set_pc(oop chunk, address value);
   static inline int argsize(oop chunk);
   static inline void set_argsize(oop chunk, int value);
   static inline uint8_t flags(oop chunk);