@@ -352,7 +352,6 @@ class JfrThreadSampler : public NonJavaThread {
  public:
   virtual const char* name() const { return "JFR Thread Sampler"; }
   virtual const char* type_name() const { return "JfrThreadSampler"; }
-  bool is_JfrSampler_thread() const { return true; }
   void run();
   static Monitor* transition_block() { return JfrThreadSampler_lock; }
   static void on_javathread_suspend(JavaThread* thread);