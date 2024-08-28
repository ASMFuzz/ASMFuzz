@@ -99,8 +99,14 @@
     entry_frame_call_wrapper_offset                  = -8,
 
     // we don't need a save area
-    arg_reg_save_area_bytes                          =  0
-
+    arg_reg_save_area_bytes                          =  0,
+
+    // size, in words, of frame metadata (e.g. pc and link)
+    metadata_words                                   = sender_sp_offset,
+    // in bytes
+    frame_alignment                                  = 16,
+    // size, in words, of maximum shift in frame position due to alignment
+    align_wiggle                                     =  1
   };
 
   intptr_t ptr_at(int offset) const {
@@ -113,16 +119,23 @@
 
  private:
   // an additional field beyond _sp and _pc:
-  intptr_t*   _fp; // frame pointer
+  union {
+    intptr_t*  _fp; // frame pointer
+    int _offset_fp; // relative frame pointer for use in stack-chunk frames
+  };
   // The interpreter and adapters will extend the frame of the caller.
   // Since oopMaps are based on the sp of the caller before extension
   // we need to know that value. However in order to compute the address
   // of the return address we need the real "raw" sp. Since sparc already
   // uses sp() to mean "raw" sp and unextended_sp() to mean the caller's
   // original sp we use that convention.
 
-  intptr_t*     _unextended_sp;
-  void adjust_unextended_sp();
+  union {
+    intptr_t* _unextended_sp;
+    int _offset_unextended_sp; // for use in stack-chunk frames
+  };
+
+  void adjust_unextended_sp() NOT_DEBUG_RETURN;
 
   // true means _sp value is correct and we can use it to get the sender's sp
   // of the compiled frame, otherwise, _sp value may be invalid and we can use
@@ -138,37 +151,47 @@
   static void verify_deopt_original_pc(   CompiledMethod* nm, intptr_t* unextended_sp);
 #endif
 
+  const ImmutableOopMap* get_oop_map() const;
+
  public:
   // Constructors
 
   frame(intptr_t* sp, intptr_t* fp, address pc);
 
   frame(intptr_t* sp, intptr_t* unextended_sp, intptr_t* fp, address pc);
 
+  frame(intptr_t* sp, intptr_t* unextended_sp, intptr_t* fp, address pc, CodeBlob* cb);
+  // used for fast frame construction by continuations
+  frame(intptr_t* sp, intptr_t* unextended_sp, intptr_t* fp, address pc, CodeBlob* cb, const ImmutableOopMap* oop_map, bool on_heap);
+
   frame(intptr_t* sp, intptr_t* fp);
 
   void init(intptr_t* sp, intptr_t* fp, address pc);
+  void setup(address pc);
 
   // accessors for the instance variables
   // Note: not necessarily the real 'frame pointer' (see real_fp)
-  intptr_t*   fp() const { return _fp; }
+  intptr_t*   fp() const        { assert_absolute(); return _fp; }
+  void set_fp(intptr_t* newfp)  { _fp = newfp; }
+  int offset_fp() const         { assert_offset();  return _offset_fp; }
+  void set_offset_fp(int value) { assert_on_heap(); _offset_fp = value; }
 
   inline address* sender_pc_addr() const;
   inline address  sender_pc_maybe_signed() const;
 
   // expression stack tos if we are nested in a java call
   intptr_t* interpreter_frame_last_sp() const;
 
-  // helper to update a map with callee-saved RBP
-  static void update_map_with_saved_link(RegisterMap* map, intptr_t** link_addr);
+  template <typename RegisterMapT>
+  static void update_map_with_saved_link(RegisterMapT* map, intptr_t** link_addr);
 
   // deoptimization support
   void interpreter_frame_set_last_sp(intptr_t* sp);
 
   static jint interpreter_frame_expression_stack_direction() { return -1; }
 
   // returns the sending frame, without applying any barriers
-  frame sender_raw(RegisterMap* map) const;
+  inline frame sender_raw(RegisterMap* map) const;
 
   void set_sp_is_trusted() { _sp_is_trusted = true; }
 