@@ -191,7 +191,7 @@ CompileTask* CompilationPolicy::select_task_helper(CompileQueue* compile_queue)
 
 // Simple methods are as good being compiled with C1 as C2.
 // Determine if a given method is such a case.
-bool CompilationPolicy::is_trivial(Method* method) {
+bool CompilationPolicy::is_trivial(const methodHandle& method) {
   if (method->is_accessor() ||
       method->is_constant_getter()) {
     return true;
@@ -245,7 +245,7 @@ class LoopPredicate : AllStatic {
     }
   }
 
-  static bool apply(int i, int b, CompLevel cur_level, const methodHandle& method) {
+  static bool apply(const methodHandle& method, CompLevel cur_level, int i, int b) {
     double k = 1;
     switch(cur_level) {
     case CompLevel_none:
@@ -285,7 +285,7 @@ class CallPredicate : AllStatic {
     }
   }
 
-  static bool apply(int i, int b, CompLevel cur_level, const methodHandle& method) {
+  static bool apply(const methodHandle& method, CompLevel cur_level, int i, int b) {
     double k = 1;
     switch(cur_level) {
     case CompLevel_none:
@@ -596,7 +596,7 @@ CompLevel CompilationPolicy::initial_compile_level(const methodHandle& method) {
 }
 
 // Set carry flags on the counters if necessary
-void CompilationPolicy::handle_counter_overflow(Method* method) {
+void CompilationPolicy::handle_counter_overflow(const methodHandle& method) {
   MethodCounters *mcs = method->method_counters();
   if (mcs != NULL) {
     mcs->invocation_counter()->set_carry_on_overflow();
@@ -619,21 +619,25 @@ CompileTask* CompilationPolicy::select_task(CompileQueue* compile_queue) {
   // Iterate through the queue and find a method with a maximum rate.
   for (CompileTask* task = compile_queue->first(); task != NULL;) {
     CompileTask* next_task = task->next();
-    Method* method = task->method();
     // If a method was unloaded or has been stale for some time, remove it from the queue.
     // Blocking tasks and tasks submitted from whitebox API don't become stale
-    if (task->is_unloaded() || (task->can_become_stale() && is_stale(t, TieredCompileTaskTimeout, method) && !is_old(method))) {
-      if (!task->is_unloaded()) {
-        if (PrintTieredEvents) {
-          print_event(REMOVE_FROM_QUEUE, method, method, task->osr_bci(), (CompLevel) task->comp_level());
-        }
-        method->clear_queued_for_compilation();
+    if (task->is_unloaded()) {
+      compile_queue->remove_and_mark_stale(task);
+      task = next_task;
+      continue;
+    }
+    Method* method = task->method();
+    methodHandle mh(Thread::current(), method);
+    if (task->can_become_stale() && is_stale(t, TieredCompileTaskTimeout, mh) && !is_old(mh)) {
+      if (PrintTieredEvents) {
+        print_event(REMOVE_FROM_QUEUE, method, method, task->osr_bci(), (CompLevel) task->comp_level());
       }
+      method->clear_queued_for_compilation();
       compile_queue->remove_and_mark_stale(task);
       task = next_task;
       continue;
     }
-    update_rate(t, method);
+    update_rate(t, mh);
     if (max_task == NULL || compare_methods(method, max_method)) {
       // Select a method with the highest rate
       max_task = task;
@@ -711,9 +715,9 @@ nmethod* CompilationPolicy::event(const methodHandle& method, const methodHandle
     return NULL;
   }
 
-  handle_counter_overflow(method());
+  handle_counter_overflow(method);
   if (method() != inlinee()) {
-    handle_counter_overflow(inlinee());
+    handle_counter_overflow(inlinee);
   }
 
   if (bci == InvocationEntryBci) {
@@ -792,56 +796,56 @@ void CompilationPolicy::compile(const methodHandle& mh, int bci, CompLevel level
       print_event(COMPILE, mh(), mh(), bci, level);
     }
     int hot_count = (bci == InvocationEntryBci) ? mh->invocation_count() : mh->backedge_count();
-    update_rate(nanos_to_millis(os::javaTimeNanos()), mh());
+    update_rate(nanos_to_millis(os::javaTimeNanos()), mh);
     CompileBroker::compile_method(mh, bci, level, mh, hot_count, CompileTask::Reason_Tiered, THREAD);
   }
 }
 
 // update_rate() is called from select_task() while holding a compile queue lock.
-void CompilationPolicy::update_rate(jlong t, Method* m) {
+void CompilationPolicy::update_rate(jlong t, const methodHandle& method) {
   // Skip update if counters are absent.
   // Can't allocate them since we are holding compile queue lock.
-  if (m->method_counters() == NULL)  return;
+  if (method->method_counters() == NULL)  return;
 
-  if (is_old(m)) {
+  if (is_old(method)) {
     // We don't remove old methods from the queue,
     // so we can just zero the rate.
-    m->set_rate(0);
+    method->set_rate(0);
     return;
   }
 
   // We don't update the rate if we've just came out of a safepoint.
   // delta_s is the time since last safepoint in milliseconds.
   jlong delta_s = t - SafepointTracing::end_of_last_safepoint_ms();
-  jlong delta_t = t - (m->prev_time() != 0 ? m->prev_time() : start_time()); // milliseconds since the last measurement
+  jlong delta_t = t - (method->prev_time() != 0 ? method->prev_time() : start_time()); // milliseconds since the last measurement
   // How many events were there since the last time?
-  int event_count = m->invocation_count() + m->backedge_count();
-  int delta_e = event_count - m->prev_event_count();
+  int event_count = method->invocation_count() + method->backedge_count();
+  int delta_e = event_count - method->prev_event_count();
 
   // We should be running for at least 1ms.
   if (delta_s >= TieredRateUpdateMinTime) {
     // And we must've taken the previous point at least 1ms before.
     if (delta_t >= TieredRateUpdateMinTime && delta_e > 0) {
-      m->set_prev_time(t);
-      m->set_prev_event_count(event_count);
-      m->set_rate((float)delta_e / (float)delta_t); // Rate is events per millisecond
+      method->set_prev_time(t);
+      method->set_prev_event_count(event_count);
+      method->set_rate((float)delta_e / (float)delta_t); // Rate is events per millisecond
     } else {
       if (delta_t > TieredRateUpdateMaxTime && delta_e == 0) {
         // If nothing happened for 25ms, zero the rate. Don't modify prev values.
-        m->set_rate(0);
+        method->set_rate(0);
       }
     }
   }
 }
 
 // Check if this method has been stale for a given number of milliseconds.
 // See select_task().
-bool CompilationPolicy::is_stale(jlong t, jlong timeout, Method* m) {
+bool CompilationPolicy::is_stale(jlong t, jlong timeout, const methodHandle& method) {
   jlong delta_s = t - SafepointTracing::end_of_last_safepoint_ms();
-  jlong delta_t = t - m->prev_time();
+  jlong delta_t = t - method->prev_time();
   if (delta_t > timeout && delta_s > timeout) {
-    int event_count = m->invocation_count() + m->backedge_count();
-    int delta_e = event_count - m->prev_event_count();
+    int event_count = method->invocation_count() + method->backedge_count();
+    int delta_e = event_count - method->prev_event_count();
     // Return true if there were no events.
     return delta_e == 0;
   }
@@ -850,13 +854,16 @@ bool CompilationPolicy::is_stale(jlong t, jlong timeout, Method* m) {
 
 // We don't remove old methods from the compile queue even if they have
 // very low activity. See select_task().
-bool CompilationPolicy::is_old(Method* method) {
-  return method->invocation_count() > 50000 || method->backedge_count() > 500000;
+bool CompilationPolicy::is_old(const methodHandle& method) {
+  int i = method->invocation_count();
+  int b = method->backedge_count();
+  double k = TieredOldPercentage / 100.0;
+
+  return CallPredicate::apply_scaled(method, CompLevel_none, i, b, k) || LoopPredicate::apply_scaled(method, CompLevel_none, i, b, k);
 }
 
 double CompilationPolicy::weight(Method* method) {
-  return (double)(method->rate() + 1) *
-    (method->invocation_count() + 1) * (method->backedge_count() + 1);
+  return (double)(method->rate() + 1) * (method->invocation_count() + 1) * (method->backedge_count() + 1);
 }
 
 // Apply heuristics and return true if x should be compiled before y
@@ -909,13 +916,16 @@ bool CompilationPolicy::should_create_mdo(const methodHandle& method, CompLevel
   if (cur_level != CompLevel_none || force_comp_at_level_simple(method) || CompilationModeFlag::quick_only() || !ProfileInterpreter) {
     return false;
   }
+  if (is_old(method)) {
+    return true;
+  }
   int i = method->invocation_count();
   int b = method->backedge_count();
   double k = Tier0ProfilingStartPercentage / 100.0;
 
   // If the top level compiler is not keeping up, delay profiling.
   if (CompileBroker::queue_size(CompLevel_full_optimization) <= Tier0Delay * compiler_count(CompLevel_full_optimization)) {
-    return CallPredicate::apply_scaled(method, CompLevel_full_profile, i, b, k) || LoopPredicate::apply_scaled(method, CompLevel_full_profile, i, b, k);
+    return CallPredicate::apply_scaled(method, CompLevel_none, i, b, k) || LoopPredicate::apply_scaled(method, CompLevel_none, i, b, k);
   }
   return false;
 }
@@ -1005,7 +1015,7 @@ CompLevel CompilationPolicy::common(const methodHandle& method, CompLevel cur_le
   if (force_comp_at_level_simple(method)) {
     next_level = CompLevel_simple;
   } else {
-    if (is_trivial(method())) {
+    if (is_trivial(method)) {
       next_level = CompilationModeFlag::disable_intermediate() ? CompLevel_full_optimization : CompLevel_simple;
     } else {
       switch(cur_level) {
@@ -1014,7 +1024,7 @@ CompLevel CompilationPolicy::common(const methodHandle& method, CompLevel cur_le
         // If we were at full profile level, would we switch to full opt?
         if (common<Predicate>(method, CompLevel_full_profile, disable_feedback) == CompLevel_full_optimization) {
           next_level = CompLevel_full_optimization;
-        } else if (!CompilationModeFlag::disable_intermediate() && Predicate::apply(i, b, cur_level, method)) {
+        } else if (!CompilationModeFlag::disable_intermediate() && Predicate::apply(method, cur_level, i, b)) {
           // C1-generated fully profiled code is about 30% slower than the limited profile
           // code that has only invocation and backedge counters. The observation is that
           // if C2 queue is large enough we can spend too much time in the fully profiled code
@@ -1040,7 +1050,7 @@ CompLevel CompilationPolicy::common(const methodHandle& method, CompLevel cur_le
             if (mdo->would_profile()) {
               if (disable_feedback || (CompileBroker::queue_size(CompLevel_full_optimization) <=
                                        Tier3DelayOff * compiler_count(CompLevel_full_optimization) &&
-                                       Predicate::apply(i, b, cur_level, method))) {
+                                       Predicate::apply(method, cur_level, i, b))) {
                 next_level = CompLevel_full_profile;
               }
             } else {
@@ -1050,7 +1060,7 @@ CompLevel CompilationPolicy::common(const methodHandle& method, CompLevel cur_le
             // If there is no MDO we need to profile
             if (disable_feedback || (CompileBroker::queue_size(CompLevel_full_optimization) <=
                                      Tier3DelayOff * compiler_count(CompLevel_full_optimization) &&
-                                     Predicate::apply(i, b, cur_level, method))) {
+                                     Predicate::apply(method, cur_level, i, b))) {
               next_level = CompLevel_full_profile;
             }
           }
@@ -1063,7 +1073,7 @@ CompLevel CompilationPolicy::common(const methodHandle& method, CompLevel cur_le
             if (mdo->would_profile() || CompilationModeFlag::disable_intermediate()) {
               int mdo_i = mdo->invocation_count_delta();
               int mdo_b = mdo->backedge_count_delta();
-              if (Predicate::apply(mdo_i, mdo_b, cur_level, method)) {
+              if (Predicate::apply(method, cur_level, mdo_i, mdo_b)) {
                 next_level = CompLevel_full_optimization;
               }
             } else {
@@ -1083,7 +1093,7 @@ CompLevel CompilationPolicy::common(const methodHandle& method, CompLevel cur_le
 // Determine if a method should be compiled with a normal entry point at a different level.
 CompLevel CompilationPolicy::call_event(const methodHandle& method, CompLevel cur_level, Thread* thread) {
   CompLevel osr_level = MIN2((CompLevel) method->highest_osr_comp_level(), common<LoopPredicate>(method, cur_level, true));
-  CompLevel next_level = common<CallPredicate>(method, cur_level);
+  CompLevel next_level = common<CallPredicate>(method, cur_level, is_old(method));
 
   // If OSR method level is greater than the regular method level, the levels should be
   // equalized by raising the regular method level in order to avoid OSRs during each