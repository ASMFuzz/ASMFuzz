@@ -3613,7 +3613,7 @@ class StubGenerator: public StubCodeGenerator {
 #define BLK_OFFSETOF(x) (offsetof(constant_block, x))
 
 // In little-endian mode, the lxv instruction loads the element at EA into
-// element 15 of the the vector register, EA+1 goes into element 14, and so
+// element 15 of the vector register, EA+1 goes into element 14, and so
 // on.
 //
 // To make a look-up table easier to read, ARRAY_TO_LXV_ORDER reverses the