@@ -6521,7 +6521,7 @@ class StubGenerator: public StubCodeGenerator {
     assert(is_even(framesize/2), "sp not 16-byte aligned");
 
     // lr and fp are already in place
-    __ sub(sp, rfp, ((unsigned)framesize-4) << LogBytesPerInt); // prolog
+    __ sub(sp, rfp, ((uint64_t)framesize-4) << LogBytesPerInt); // prolog
 
     int frame_complete = __ pc() - start;
 