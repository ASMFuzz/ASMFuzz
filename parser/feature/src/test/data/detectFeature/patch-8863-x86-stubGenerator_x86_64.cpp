@@ -7672,12 +7672,12 @@ address generate_avx_ghash_processBlocks() {
       __ pop(rbp);
       __ pop(rdx); // exception pc
       __ jmp(rbx);
+    } else {
+      // We are "returning" into the topmost thawed frame; see Thaw::push_return_frame
+      __ pop(rbp);
+      __ ret(0);
     }
 
-    // We are "returning" into the topmost thawed frame; see Thaw::push_return_frame
-    __ pop(rbp);
-    __ ret(0);
-
     return start;
   }
 