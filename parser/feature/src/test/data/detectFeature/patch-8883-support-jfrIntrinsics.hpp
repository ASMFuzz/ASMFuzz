@@ -52,6 +52,7 @@ class JfrIntrinsicSupport : AllStatic {
   template(getEventWriter_signature,                                  "()Ljdk/jfr/internal/event/EventWriter;")      \
   template(eventConfiguration_name,                                   "eventConfiguration")                          \
   template(commit_name,                                               "commit")                                      \
+  template(jfr_chunk_rotation_monitor,                                "jdk/jfr/internal/JVM$ChunkRotationMonitor")   \
 
 #define JFR_INTRINSICS(do_intrinsic, do_class, do_name, do_signature, do_alias)                                      \
   do_intrinsic(_counterTime,        jdk_jfr_internal_JVM, counterTime_name, void_long_signature, F_SN)               \