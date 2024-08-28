@@ -477,6 +477,7 @@ address TemplateInterpreterGenerator::generate_abstract_entry(void) {
 }
 
 address TemplateInterpreterGenerator::generate_Continuation_doYield_entry(void) {
+  if (!Continuations::enabled()) return nullptr;
   Unimplemented();
   return NULL;
 }