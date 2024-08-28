@@ -1788,7 +1788,7 @@ class StubGenerator: public StubCodeGenerator {
   //     'count' must not be less then the returned value
   //     'to' must be aligned by bytes_per_count but must not be aligned by wordSize
   //     shifts 'to' by the number of written bytes (so that it becomes the bound of memory to be written)
-  //     decreases 'count' by the the number of elements written
+  //     decreases 'count' by the number of elements written
   //     Rval's MSBs or LSBs remain to be written further by generate_{forward,backward}_shifted_copy_loop
   int align_dst(Register to, Register count, Register Rval, Register tmp,
                                         int to_remainder, int bytes_per_count, bool forward) {