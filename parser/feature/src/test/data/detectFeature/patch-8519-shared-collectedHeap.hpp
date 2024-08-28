@@ -104,6 +104,10 @@ class CollectedHeap : public CHeapObj<mtGC> {
   size_t _capacity_at_last_gc;
   size_t _used_at_last_gc;
 
+  // First, set it to java_lang_Object.
+  // Then, set it to FillerObject after the FillerObject_klass loading is complete.
+  static Klass* _filler_object_klass;
+
  protected:
   // Not used by all GCs
   MemRegion _reserved;
@@ -204,6 +208,14 @@ class CollectedHeap : public CHeapObj<mtGC> {
     return _filler_array_max_size;
   }
 
+  static inline Klass* filler_object_klass() {
+    return _filler_object_klass;
+  }
+
+  static inline void set_filler_object_klass(Klass* k) {
+    _filler_object_klass = k;
+  }
+
   virtual Name kind() const = 0;
 
   virtual const char* name() const = 0;