@@ -106,10 +106,12 @@
  public:
   enum {
     pc_return_offset                                 =  0,
+
     // All frames
     link_offset                                      = -2,
     return_addr_offset                               = -1,
     sender_sp_offset                                 =  0,
+
     // Interpreter frames
     interpreter_frame_oop_temp_offset                =  1, // for native calls only
 