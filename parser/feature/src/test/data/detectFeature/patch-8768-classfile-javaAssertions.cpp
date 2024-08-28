@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -58,7 +58,7 @@ int JavaAssertions::OptionList::count(OptionList* p) {
 void JavaAssertions::addOption(const char* name, bool enable) {
   assert(name != 0, "must have a name");
 
-  // Copy the name.  The storage needs to exist for the the lifetime of the vm;
+  // Copy the name.  The storage needs to exist for the lifetime of the vm;
   // it is never freed, so will be leaked (along with other option strings -
   // e.g., bootclasspath) if a process creates/destroys multiple VMs.
   int len = (int)strlen(name);