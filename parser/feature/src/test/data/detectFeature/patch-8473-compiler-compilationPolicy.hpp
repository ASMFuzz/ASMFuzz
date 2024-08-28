@@ -169,7 +169,7 @@ class CompilationPolicy : AllStatic {
   static double _increase_threshold_at_ratio;
 
   // Set carry flags in the counters (in Method* and MDO).
-  inline static void handle_counter_overflow(Method* method);
+  inline static void handle_counter_overflow(const methodHandle& method);
   // Verify that a level is consistent with the compilation mode
   static bool verify_level(CompLevel level);
   // Clamp the request level according to various constraints.
@@ -188,17 +188,17 @@ class CompilationPolicy : AllStatic {
   // Has a method been long around?
   // We don't remove old methods from the compile queue even if they have
   // very low activity (see select_task()).
-  inline static bool is_old(Method* method);
+  inline static bool is_old(const methodHandle& method);
   // Was a given method inactive for a given number of milliseconds.
   // If it is, we would remove it from the queue (see select_task()).
-  inline static bool is_stale(jlong t, jlong timeout, Method* m);
+  inline static bool is_stale(jlong t, jlong timeout, const methodHandle& method);
   // Compute the weight of the method for the compilation scheduling
   inline static double weight(Method* method);
   // Apply heuristics and return true if x should be compiled before y
   inline static bool compare_methods(Method* x, Method* y);
   // Compute event rate for a given method. The rate is the number of event (invocations + backedges)
   // per millisecond.
-  inline static void update_rate(jlong t, Method* m);
+  inline static void update_rate(jlong t, const methodHandle& method);
   // Compute threshold scaling coefficient
   inline static double threshold_scale(CompLevel level, int feedback_k);
   // If a method is old enough and is still in the interpreter we would want to
@@ -219,7 +219,7 @@ class CompilationPolicy : AllStatic {
   static void compile(const methodHandle& mh, int bci, CompLevel level, TRAPS);
   // Simple methods are as good being compiled with C1 as C2.
   // This function tells if it's such a function.
-  inline static bool is_trivial(Method* method);
+  inline static bool is_trivial(const methodHandle& method);
   // Force method to be compiled at CompLevel_simple?
   inline static bool force_comp_at_level_simple(const methodHandle& method);
 