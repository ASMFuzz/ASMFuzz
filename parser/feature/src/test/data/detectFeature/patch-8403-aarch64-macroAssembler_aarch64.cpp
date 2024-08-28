@@ -849,6 +849,37 @@ void MacroAssembler::call_VM_helper(Register oop_result, address entry_point, in
   call_VM_base(oop_result, noreg, noreg, entry_point, number_of_arguments, check_exceptions);
 }
 
+// Check the entry target is always reachable from any branch.
+static bool is_always_within_branch_range(Address entry) {
+  const address target = entry.target();
+
+  if (!CodeCache::contains(target)) {
+    // We always use trampolines for callees outside CodeCache.
+    assert(entry.rspec().type() == relocInfo::runtime_call_type, "non-runtime call of an external target");
+    return false;
+  }
+
+  if (!MacroAssembler::far_branches()) {
+    return true;
+  }
+
+  if (entry.rspec().type() == relocInfo::runtime_call_type) {
+    // Runtime calls are calls of a non-compiled method (stubs, adapters).
+    // Non-compiled methods stay forever in CodeCache.
+    // We check whether the longest possible branch is within the branch range.
+    assert(CodeCache::find_blob(target) != NULL &&
+          !CodeCache::find_blob(target)->is_compiled(),
+          "runtime call of compiled method");
+    const address right_longest_branch_start = CodeCache::high_bound() - NativeInstruction::instruction_size;
+    const address left_longest_branch_start = CodeCache::low_bound();
+    const bool is_reachable = Assembler::reachable_from_branch_at(left_longest_branch_start, target) &&
+                              Assembler::reachable_from_branch_at(right_longest_branch_start, target);
+    return is_reachable;
+  }
+
+  return false;
+}
+
 // Maybe emit a call via a trampoline. If the code cache is small
 // trampolines won't be emitted.
 address MacroAssembler::trampoline_call(Address entry, CodeBuffer* cbuf) {
@@ -859,22 +890,7 @@ address MacroAssembler::trampoline_call(Address entry, CodeBuffer* cbuf) {
 
   address target = entry.target();
 
-  // We might need a trampoline if branches are far.
-  bool need_trampoline = far_branches();
-  if (!need_trampoline && entry.rspec().type() == relocInfo::runtime_call_type && !CodeCache::contains(target)) {
-    // If it is a runtime call of an address outside small CodeCache,
-    // we need to check whether it is in range.
-    assert(target < CodeCache::low_bound() || target >= CodeCache::high_bound(), "target is inside CodeCache");
-    // Case 1: -------T-------L====CodeCache====H-------
-    //                ^-------longest branch---|
-    // Case 2: -------L====CodeCache====H-------T-------
-    //                |-------longest branch ---^
-    address longest_branch_start = (target < CodeCache::low_bound()) ? CodeCache::high_bound() - NativeInstruction::instruction_size
-                                                                     : CodeCache::low_bound();
-    need_trampoline = !reachable_from_branch_at(longest_branch_start, target);
-  }
-
-  if (need_trampoline) {
+  if (!is_always_within_branch_range(entry)) {
     if (!in_scratch_emit_size()) {
       // We don't want to emit a trampoline if C2 is generating dummy
       // code during its branch shortening phase.