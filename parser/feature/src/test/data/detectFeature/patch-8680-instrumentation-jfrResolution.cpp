@@ -23,18 +23,24 @@
  */
 
 #include "precompiled.hpp"
-#include "c1/c1_GraphBuilder.hpp"
 #include "ci/ciKlass.hpp"
 #include "ci/ciMethod.hpp"
 #include "classfile/vmSymbols.hpp"
 #include "interpreter/linkResolver.hpp"
 #include "jfr/instrumentation/jfrResolution.hpp"
 #include "jfr/recorder/checkpoint/types/traceid/jfrTraceIdMacros.hpp"
 #include "oops/method.inline.hpp"
-#include "opto/parse.hpp"
 #include "runtime/thread.hpp"
 #include "runtime/vframe.inline.hpp"
 
+#ifdef COMPILER1
+#include "c1/c1_GraphBuilder.hpp"
+#endif
+
+#ifdef COMPILER2
+#include "opto/parse.hpp"
+#endif
+
 static const char* const link_error_msg = "illegal access linking method 'jdk.jfr.internal.event.EventWriterFactory.getEventWriter(long)'";
 
 static const Method* ljf_sender_method(JavaThread* jt) {
@@ -88,16 +94,20 @@ static inline bool is_compiler_linking_event_writer(const ciKlass * holder, cons
   return target->name()->get_symbol() == event_writer_method_name;
 }
 
+#ifdef COMPILER1
 // C1
 void JfrResolution::on_c1_resolution(const GraphBuilder * builder, const ciKlass * holder, const ciMethod * target) {
   if (is_compiler_linking_event_writer(holder, target) && !IS_METHOD_BLESSED(builder->method()->get_Method())) {
     builder->bailout(link_error_msg);
   }
 }
+#endif
 
+#ifdef COMPILER2
 // C2
 void JfrResolution::on_c2_resolution(const Parse * parse, const ciKlass * holder, const ciMethod * target) {
   if (is_compiler_linking_event_writer(holder, target) && !IS_METHOD_BLESSED(parse->method()->get_Method())) {
     parse->C->record_failure(link_error_msg);
   }
 }
+#endif