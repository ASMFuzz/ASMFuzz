@@ -231,7 +231,6 @@ class MemTracker : AllStatic {
   static void tuning_statistics(outputStream* out);
 
  private:
-  static NMT_TrackingLevel init_tracking_level();
   static void report(bool summary_only, outputStream* output, size_t scale);
 
  private: