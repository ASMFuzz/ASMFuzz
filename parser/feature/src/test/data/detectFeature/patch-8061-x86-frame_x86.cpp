@@ -715,7 +715,7 @@ intptr_t* frame::real_fp() const {
 #ifndef PRODUCT
 // This is a generic constructor which is only used by pns() in debug.cpp.
 frame::frame(void* sp, void* fp, void* pc) {
-  init((intptr_t*)sp, (intptr_t*)fp, (address)pc);
+  init((intptr_t*)sp, (intptr_t*)fp, (address)pc, CodeCache::find_blob((address)pc));
 }
 
 #endif