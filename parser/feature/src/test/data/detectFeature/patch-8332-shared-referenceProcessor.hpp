@@ -293,7 +293,7 @@ class ReferenceProcessor : public ReferenceDiscoverer {
     _current_soft_ref_policy->setup();   // snapshot the policy threshold
   }
 public:
-  static int number_of_subclasses_of_ref() { return (REF_PHANTOM - REF_OTHER); }
+  static int number_of_subclasses_of_ref() { return (REF_PHANTOM - REF_NONE); }
 
   uint num_queues() const                  { return _num_queues; }
   uint max_num_queues() const              { return _max_num_queues; }