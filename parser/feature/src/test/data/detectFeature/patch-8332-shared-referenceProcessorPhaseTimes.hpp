@@ -37,7 +37,7 @@ class GCTimer;
 class LogStream;
 
 class ReferenceProcessorPhaseTimes : public CHeapObj<mtGC> {
-  static const int number_of_subclasses_of_ref = REF_PHANTOM - REF_OTHER; // 5 - 1 = 4
+  static const int number_of_subclasses_of_ref = REF_PHANTOM - REF_NONE; // 4 - 0 = 4
 
   // Records per thread time information of each sub phase.
   WorkerDataArray<double>* _sub_phases_worker_time_sec[ReferenceProcessor::RefSubPhaseMax];