@@ -491,24 +491,25 @@ Node* PhaseIdealLoop::skip_loop_predicates(Node* entry) {
 }
 
 Node* PhaseIdealLoop::skip_all_loop_predicates(Node* entry) {
-  Node* predicate = NULL;
-  predicate = find_predicate_insertion_point(entry, Deoptimization::Reason_loop_limit_check);
-  if (predicate != NULL) {
-    entry = skip_loop_predicates(entry);
-  }
-  if (UseProfiledLoopPredicate) {
-    predicate = find_predicate_insertion_point(entry, Deoptimization::Reason_profile_predicate);
-    if (predicate != NULL) { // right pattern that can be used by loop predication
-      entry = skip_loop_predicates(entry);
-    }
-  }
-  if (UseLoopPredicate) {
-    predicate = find_predicate_insertion_point(entry, Deoptimization::Reason_predicate);
-    if (predicate != NULL) { // right pattern that can be used by loop predication
-      entry = skip_loop_predicates(entry);
+  Predicates predicates(entry);
+  return predicates.skip_all();
+}
+
+//--------------------------next_predicate---------------------------------
+// Find next related predicate, useful for iterating over all related predicates
+ProjNode* PhaseIdealLoop::next_predicate(ProjNode* predicate) {
+  IfNode* iff = predicate->in(0)->as_If();
+  ProjNode* uncommon_proj = iff->proj_out(1 - predicate->_con);
+  Node* rgn = uncommon_proj->unique_ctrl_out();
+  assert(rgn->is_Region() || rgn->is_Call(), "must be a region or call uct");
+  Node* next = iff->in(0);
+  if (next != nullptr && next->is_Proj() && next->in(0)->is_If()) {
+    uncommon_proj = next->in(0)->as_If()->proj_out(1 - next->as_Proj()->_con);
+    if (uncommon_proj->unique_ctrl_out() == rgn) { // lead into same region
+      return next->as_Proj();
     }
   }
-  return entry;
+  return nullptr;
 }
 
 //--------------------------find_predicate_insertion_point-------------------
@@ -522,6 +523,28 @@ ProjNode* PhaseIdealLoop::find_predicate_insertion_point(Node* start_c, Deoptimi
   return NULL;
 }
 
+//--------------------------Predicates::Predicates--------------------------
+// given loop entry, find all predicates above loop
+PhaseIdealLoop::Predicates::Predicates(Node* entry) {
+  _loop_limit_check = find_predicate_insertion_point(entry, Deoptimization::Reason_loop_limit_check);
+  if (_loop_limit_check != nullptr) {
+    entry = skip_loop_predicates(entry);
+  }
+  if (UseProfiledLoopPredicate) {
+    _profile_predicate = find_predicate_insertion_point(entry, Deoptimization::Reason_profile_predicate);
+    if (_profile_predicate != nullptr) {
+      entry = skip_loop_predicates(entry);
+    }
+  }
+  if (UseLoopPredicate) {
+    _predicate = find_predicate_insertion_point(entry, Deoptimization::Reason_predicate);
+    if (_predicate != nullptr) {
+      entry = skip_loop_predicates(entry);
+    }
+  }
+  _entry_to_all_predicates = entry;
+}
+
 //--------------------------find_predicate------------------------------------
 // Find a predicate
 Node* PhaseIdealLoop::find_predicate(Node* entry) {