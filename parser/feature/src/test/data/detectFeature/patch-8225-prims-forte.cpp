@@ -458,7 +458,6 @@ static void forte_fill_call_trace_given_top(JavaThread* thd,
                                             ASGCT_CallTrace* trace,
                                             int depth,
                                             frame top_frame) {
-  NoHandleMark nhm;
 
   frame initial_Java_frame;
   Method* method;
@@ -505,68 +504,11 @@ static void forte_fill_call_trace_given_top(JavaThread* thd,
 }
 
 
-// Forte Analyzer AsyncGetCallTrace() entry point. Currently supported
-// on Linux X86, Solaris SPARC and Solaris X86.
-//
-// Async-safe version of GetCallTrace being called from a signal handler
-// when a LWP gets interrupted by SIGPROF but the stack traces are filled
-// with different content (see below).
-//
-// This function must only be called when JVM/TI
-// CLASS_LOAD events have been enabled since agent startup. The enabled
-// event will cause the jmethodIDs to be allocated at class load time.
-// The jmethodIDs cannot be allocated in a signal handler because locks
-// cannot be grabbed in a signal handler safely.
-//
-// void (*AsyncGetCallTrace)(ASGCT_CallTrace *trace, jint depth, void* ucontext)
-//
-// Called by the profiler to obtain the current method call stack trace for
-// a given thread. The thread is identified by the env_id field in the
-// ASGCT_CallTrace structure. The profiler agent should allocate a ASGCT_CallTrace
-// structure with enough memory for the requested stack depth. The VM fills in
-// the frames buffer and the num_frames field.
-//
-// Arguments:
-//
-//   trace    - trace data structure to be filled by the VM.
-//   depth    - depth of the call stack trace.
-//   ucontext - ucontext_t of the LWP
-//
-// ASGCT_CallTrace:
-//   typedef struct {
-//       JNIEnv *env_id;
-//       jint num_frames;
-//       ASGCT_CallFrame *frames;
-//   } ASGCT_CallTrace;
-//
-// Fields:
-//   env_id     - ID of thread which executed this trace.
-//   num_frames - number of frames in the trace.
-//                (< 0 indicates the frame is not walkable).
-//   frames     - the ASGCT_CallFrames that make up this trace. Callee followed by callers.
-//
-//  ASGCT_CallFrame:
-//    typedef struct {
-//        jint lineno;
-//        jmethodID method_id;
-//    } ASGCT_CallFrame;
-//
-//  Fields:
-//    1) For Java frame (interpreted and compiled),
-//       lineno    - bci of the method being executed or -1 if bci is not available
-//       method_id - jmethodID of the method being executed
-//    2) For native method
-//       lineno    - (-3)
-//       method_id - jmethodID of the method being executed
-
-extern "C" {
-JNIEXPORT
-void AsyncGetCallTrace(ASGCT_CallTrace *trace, jint depth, void* ucontext) {
+static void asyncGetCallTraceImpl(ASGCT_CallTrace *trace, jint depth, void* ucontext) {
 
-  JavaThread* thread;
+  JavaThread* thread = JavaThread::current_or_null();
 
-  if (trace->env_id == NULL ||
-      (thread = JavaThread::thread_from_jni_environment(trace->env_id))->is_exiting()) {
+  if (trace->env_id == NULL || thread == NULL || thread->is_terminated() || thread->is_exiting()) {
     // bad env_id, thread has exited or thread is exiting
     trace->num_frames = ticks_thread_exit; // -8
     return;
@@ -578,7 +520,7 @@ void AsyncGetCallTrace(ASGCT_CallTrace *trace, jint depth, void* ucontext) {
     return;
   }
 
-  assert(JavaThread::current() == thread,
+  assert(thread == JavaThread::thread_from_jni_environment(trace->env_id),
          "AsyncGetCallTrace must be called by the current interrupted thread");
 
   if (!JvmtiExport::should_post_class_load()) {
@@ -650,6 +592,98 @@ void AsyncGetCallTrace(ASGCT_CallTrace *trace, jint depth, void* ucontext) {
   }
 }
 
+// Helps to wrap ASGCT in crash protection similar to JFR
+class AsyncGetCallTraceCallBack : public os::CrashProtectionCallback {
+public:
+  AsyncGetCallTraceCallBack(ASGCT_CallTrace *trace, jint depth, void* ucontext) :
+    _trace(trace), _depth(depth), _ucontext(ucontext) {
+  }
+  virtual void call() {
+    asyncGetCallTraceImpl(_trace, _depth, _ucontext);
+  }
+ private:
+  ASGCT_CallTrace* _trace;
+  jint _depth;
+  void* _ucontext;
+};
+
+// Forte Analyzer AsyncGetCallTrace() entry point. Currently supported
+// on Linux X86, Solaris SPARC and Solaris X86.
+//
+// Async-safe version of GetCallTrace being called from a signal handler
+// when a LWP gets interrupted by SIGPROF but the stack traces are filled
+// with different content (see below).
+//
+// This function must only be called when JVM/TI
+// CLASS_LOAD events have been enabled since agent startup. The enabled
+// event will cause the jmethodIDs to be allocated at class load time.
+// The jmethodIDs cannot be allocated in a signal handler because locks
+// cannot be grabbed in a signal handler safely.
+//
+// void (*AsyncGetCallTrace)(ASGCT_CallTrace *trace, jint depth, void* ucontext)
+//
+// Called by the profiler to obtain the current method call stack trace for
+// a given thread. The thread is identified by the env_id field in the
+// ASGCT_CallTrace structure. The profiler agent should allocate a ASGCT_CallTrace
+// structure with enough memory for the requested stack depth. The VM fills in
+// the frames buffer and the num_frames field.
+//
+// Arguments:
+//
+//   trace    - trace data structure to be filled by the VM.
+//   depth    - depth of the call stack trace.
+//   ucontext - ucontext_t of the LWP
+//
+// ASGCT_CallTrace:
+//   typedef struct {
+//       JNIEnv *env_id;
+//       jint num_frames;
+//       ASGCT_CallFrame *frames;
+//   } ASGCT_CallTrace;
+//
+// Fields:
+//   env_id     - ID of thread which executed this trace.
+//   num_frames - number of frames in the trace.
+//                (< 0 indicates the frame is not walkable).
+//   frames     - the ASGCT_CallFrames that make up this trace. Callee followed by callers.
+//
+//  ASGCT_CallFrame:
+//    typedef struct {
+//        jint lineno;
+//        jmethodID method_id;
+//    } ASGCT_CallFrame;
+//
+//  Fields:
+//    1) For Java frame (interpreted and compiled),
+//       lineno    - bci of the method being executed or -1 if bci is not available
+//       method_id - jmethodID of the method being executed
+//    2) For native method
+//       lineno    - (-3)
+//       method_id - jmethodID of the method being executed
+
+extern "C" {
+JNIEXPORT
+void AsyncGetCallTrace(ASGCT_CallTrace *trace, jint depth, void* ucontext) {
+  NoHandleMark nhm;
+  if (Thread::current_or_null_safe() == NULL) {
+    // we need the current Thread object for crash protection
+    trace->num_frames = ticks_thread_exit;
+    return;
+  }
+  if (CrashProtectAsyncGetCallTrace) {
+    trace->num_frames = ticks_unknown_state;
+    AsyncGetCallTraceCallBack cb(trace, depth, ucontext);
+    os::ThreadCrashProtection crash_protection;
+    if (!crash_protection.call(cb)) {
+      if (trace->num_frames >= 0) {
+        trace->num_frames = ticks_unknown_state;
+      }
+    }
+  } else {
+    asyncGetCallTraceImpl(trace, depth, ucontext);
+  }
+}
+
 
 #ifndef _WINDOWS
 // Support for the Forte(TM) Peformance Tools collector.