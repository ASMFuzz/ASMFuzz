@@ -177,12 +177,6 @@ class VectorSet;
 class VectorReinterpretNode;
 class ShiftVNode;
 
-// The type of all node counts and indexes.
-// It must hold at least 16 bits, but must also be fast to load and store.
-// This type, if less than 32 bits, could limit the number of possible nodes.
-// (To make this type platform-specific, move to globalDefinitions_xxx.hpp.)
-typedef unsigned int node_idx_t;
-
 
 #ifndef OPTO_DU_ITERATOR_ASSERT
 #ifdef ASSERT