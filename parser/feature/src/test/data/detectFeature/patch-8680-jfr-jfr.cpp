@@ -104,13 +104,17 @@ void Jfr::on_resolution(const CallInfo& info, TRAPS) {
   JfrResolution::on_runtime_resolution(info, THREAD);
 }
 
+#ifdef COMPILER1
 void Jfr::on_resolution(const GraphBuilder* builder, const ciKlass* holder, const ciMethod* target) {
   JfrResolution::on_c1_resolution(builder, holder, target);
 }
+#endif
 
+#ifdef COMPILER2
 void Jfr::on_resolution(const Parse* parse, const ciKlass* holder, const ciMethod* target) {
   JfrResolution::on_c2_resolution(parse, holder, target);
 }
+#endif
 
 void Jfr::on_vm_shutdown(bool exception_handler) {
   if (JfrRecorder::is_recording()) {