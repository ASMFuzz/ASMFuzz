@@ -441,6 +441,12 @@ void os::print_context(outputStream *st, const void *context) {
 #endif // AMD64
   st->cr();
   st->cr();
+}
+
+void os::print_tos_pc(outputStream *st, const void *context) {
+  if (context == NULL) return;
+
+  const CONTEXT* uc = (const CONTEXT*)context;
 
   intptr_t *sp = (intptr_t *)uc->REG_SP;
   st->print_cr("Top of Stack: (sp=" PTR_FORMAT ")", sp);
@@ -455,7 +461,6 @@ void os::print_context(outputStream *st, const void *context) {
   st->cr();
 }
 
-
 void os::print_register_info(outputStream *st, const void *context) {
   if (context == NULL) return;
 