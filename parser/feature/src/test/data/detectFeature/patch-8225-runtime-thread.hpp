@@ -335,7 +335,6 @@ class Thread: public ThreadShadow {
   virtual bool is_ConcurrentGC_thread() const        { return false; }
   virtual bool is_Named_thread() const               { return false; }
   virtual bool is_Worker_thread() const              { return false; }
-  virtual bool is_JfrSampler_thread() const          { return false; }
 
   // Can this thread make Java upcalls
   virtual bool can_call_java() const                 { return false; }