@@ -6760,12 +6760,12 @@ class StubGenerator: public StubCodeGenerator {
       __ leave();
       __ mov(r3, lr);
       __ br(r1); // the exception handler
+    } else {
+      // We're "returning" into the topmost thawed frame; see Thaw::push_return_frame
+      __ leave();
+      __ ret(lr);
     }
 
-    // We're "returning" into the topmost thawed frame; see Thaw::push_return_frame
-    __ leave();
-    __ ret(lr);
-
     return start;
   }
 