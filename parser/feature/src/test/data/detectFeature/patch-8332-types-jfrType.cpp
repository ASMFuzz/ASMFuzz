@@ -219,7 +219,6 @@ void MetaspaceObjectTypeConstant::serialize(JfrCheckpointWriter& writer) {
 static const char* reference_type_to_string(ReferenceType rt) {
   switch (rt) {
     case REF_NONE: return "None reference";
-    case REF_OTHER: return "Other reference";
     case REF_SOFT: return "Soft reference";
     case REF_WEAK: return "Weak reference";
     case REF_FINAL: return "Final reference";