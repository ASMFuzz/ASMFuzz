@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2014, Red Hat Inc. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -137,7 +137,7 @@ static Assembler::Condition j_not(TemplateTable::Condition cc) {
 }
 
 
-// Miscelaneous helper routines
+// Miscellaneous helper routines
 // Store an oop (or NULL) at the Address described by obj.
 // If val == noreg this means store a NULL
 static void do_oop_store(InterpreterMacroAssembler* _masm,
@@ -2230,7 +2230,7 @@ void TemplateTable::_return(TosState state)
 //
 // According to the new Java Memory Model (JMM):
 // (1) All volatiles are serialized wrt to each other.  ALSO reads &
-//     writes act as aquire & release, so:
+//     writes act as acquire & release, so:
 // (2) A read cannot let unrelated NON-volatile memory refs that
 //     happen after the read float up to before the read.  It's OK for
 //     non-volatile memory refs that happen before the volatile read to
@@ -3854,7 +3854,7 @@ void TemplateTable::monitorenter()
 
   // Increment bcp to point to the next bytecode, so exception
   // handling for async. exceptions work correctly.
-  // The object has already been poped from the stack, so the
+  // The object has already been popped from the stack, so the
   // expression stack looks correct.
   __ increment(rbcp);
 