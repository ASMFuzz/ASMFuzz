@@ -388,9 +388,6 @@ void C2Access::fixup_decorators() {
 //--------------------------- atomic operations---------------------------------
 
 void BarrierSetC2::pin_atomic_op(C2AtomicParseAccess& access) const {
-  if (!access.needs_pinning()) {
-    return;
-  }
   // SCMemProjNodes represent the memory state of a LoadStore. Their
   // main role is to prevent LoadStore nodes from being optimized away
   // when their results aren't used.