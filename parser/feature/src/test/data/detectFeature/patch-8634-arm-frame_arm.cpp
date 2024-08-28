@@ -518,7 +518,7 @@ void frame::describe_pd(FrameValues& values, int frame_no) {
 
 // This is a generic constructor which is only used by pns() in debug.cpp.
 frame::frame(void* sp, void* fp, void* pc) {
-  init((intptr_t*)sp, (intptr_t*)fp, (address)pc);
+  init((intptr_t*)sp, (intptr_t*)sp, (intptr_t*)fp, (address)pc);
 }
 
 #endif