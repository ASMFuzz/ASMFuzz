@@ -692,7 +692,7 @@ OopMapSet* Runtime1::generate_code_for(StubID id, StubAssembler* sasm) {
           }
 #endif // ASSERT
 
-          // get the instance size (size is postive so movl is fine for 64bit)
+          // get the instance size (size is positive so movl is fine for 64bit)
           __ ldrw(obj_size, Address(klass, Klass::layout_helper_offset()));
 
           __ eden_allocate(obj, obj_size, 0, t1, slow_path);