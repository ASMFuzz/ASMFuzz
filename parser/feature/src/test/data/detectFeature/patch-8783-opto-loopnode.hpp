@@ -927,13 +927,16 @@ class PhaseIdealLoop : public PhaseTransform {
   void copy_skeleton_predicates_to_main_loop(CountedLoopNode* pre_head, Node* init, Node* stride, IdealLoopTree* outer_loop, LoopNode* outer_main_head,
                                              uint dd_main_head, const uint idx_before_pre_post, const uint idx_after_post_before_pre,
                                              Node* zero_trip_guard_proj_main, Node* zero_trip_guard_proj_post, const Node_List &old_new);
-  Node* clone_skeleton_predicate_for_main_or_post_loop(Node* iff, Node* new_init, Node* new_stride, Node* predicate, Node* uncommon_proj, Node* control,
-                                                       IdealLoopTree* outer_loop, Node* input_proj);
+  Node* clone_skeleton_predicate_and_initialize(Node* iff, Node* new_init, Node* new_stride, Node* predicate, Node* uncommon_proj, Node* control,
+                                                IdealLoopTree* outer_loop, Node* input_proj);
   Node* clone_skeleton_predicate_bool(Node* iff, Node* new_init, Node* new_stride, Node* control);
   static bool skeleton_predicate_has_opaque(IfNode* iff);
   static void get_skeleton_predicates(Node* predicate, Unique_Node_List& list, bool get_opaque = false);
   void update_main_loop_skeleton_predicates(Node* ctrl, CountedLoopNode* loop_head, Node* init, int stride_con);
   void copy_skeleton_predicates_to_post_loop(LoopNode* main_loop_head, CountedLoopNode* post_loop_head, Node* init, Node* stride);
+  void initialize_skeleton_predicates_for_peeled_loop(ProjNode* predicate, LoopNode* outer_loop_head, int dd_outer_loop_head,
+                                                      Node* init, Node* stride, IdealLoopTree* outer_loop,
+                                                      const uint idx_before_clone, const Node_List& old_new);
   void insert_loop_limit_check(ProjNode* limit_check_proj, Node* cmp_limit, Node* bol);
 #ifdef ASSERT
   bool only_has_infinite_loops();
@@ -1328,9 +1331,43 @@ class PhaseIdealLoop : public PhaseTransform {
 
   static Node* skip_all_loop_predicates(Node* entry);
   static Node* skip_loop_predicates(Node* entry);
+  static ProjNode* next_predicate(ProjNode* predicate);
 
   // Find a good location to insert a predicate
   static ProjNode* find_predicate_insertion_point(Node* start_c, Deoptimization::DeoptReason reason);
+
+  class Predicates {
+  public:
+    // given loop entry, find all predicates above loop
+    Predicates(Node* entry);
+
+    // Proj of empty loop limit check predicate
+    ProjNode* loop_limit_check() {
+      return _loop_limit_check;
+    }
+
+    // Proj of empty profile predicate
+    ProjNode* profile_predicate() {
+      return _profile_predicate;
+    }
+
+    // Proj of empty predicate
+    ProjNode* predicate() {
+      return _predicate;
+    }
+
+    // First control node above all predicates
+    Node* skip_all() {
+      return _entry_to_all_predicates;
+    }
+
+  private:
+    ProjNode*_loop_limit_check = nullptr;
+    ProjNode* _profile_predicate = nullptr;
+    ProjNode* _predicate = nullptr;
+    Node* _entry_to_all_predicates = nullptr;
+  };
+
   // Find a predicate
   static Node* find_predicate(Node* entry);
   // Construct a range check for a predicate if