@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -690,7 +690,7 @@ class IntervalWalker : public CompilationResourceObj {
   void walk_to(IntervalState state, int from);
 
   // activate_current() is called when an unhandled interval becomes active (in current(), current_kind()).
-  // Return false if current() should not be moved the the active interval list.
+  // Return false if current() should not be moved the active interval list.
   // It is safe to append current to any interval list but the unhandled list.
   virtual bool activate_current() { return true; }
 