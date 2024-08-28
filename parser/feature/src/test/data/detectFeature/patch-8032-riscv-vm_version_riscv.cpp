@@ -112,11 +112,6 @@ void VM_Version::initialize() {
     }
   }
 
-  if (UseRVB && !(_features & CPU_B)) {
-    warning("RVB is not supported on this CPU");
-    FLAG_SET_DEFAULT(UseRVB, false);
-  }
-
   if (UseRVC && !(_features & CPU_C)) {
     warning("RVC is not supported on this CPU");
     FLAG_SET_DEFAULT(UseRVC, false);
@@ -126,7 +121,7 @@ void VM_Version::initialize() {
     FLAG_SET_DEFAULT(AvoidUnalignedAccesses, true);
   }
 
-  if (UseRVB) {
+  if (UseZbb) {
     if (FLAG_IS_DEFAULT(UsePopCountInstruction)) {
       FLAG_SET_DEFAULT(UsePopCountInstruction, true);
     }