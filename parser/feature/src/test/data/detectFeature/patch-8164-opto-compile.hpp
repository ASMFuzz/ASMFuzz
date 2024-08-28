@@ -103,7 +103,12 @@ enum LoopOptsMode {
   LoopOptsVerify
 };
 
+// The type of all node counts and indexes.
+// It must hold at least 16 bits, but must also be fast to load and store.
+// This type, if less than 32 bits, could limit the number of possible nodes.
+// (To make this type platform-specific, move to globalDefinitions_xxx.hpp.)
 typedef unsigned int node_idx_t;
+
 class NodeCloneInfo {
  private:
   uint64_t _idx_clone_orig;