@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -728,8 +728,15 @@ static objArrayHandle get_parameter_types(const methodHandle& method,
                                           int parameter_count,
                                           oop* return_type,
                                           TRAPS) {
-  // Allocate array holding parameter types (java.lang.Class instances)
-  objArrayOop m = oopFactory::new_objArray(vmClasses::Class_klass(), parameter_count, CHECK_(objArrayHandle()));
+  objArrayOop m;
+  if (parameter_count == 0) {
+    // Avoid allocating an array for the empty case
+    // Still need to parse the signature for the return type below
+    m = Universe::the_empty_class_array();
+  } else {
+    // Allocate array holding parameter types (java.lang.Class instances)
+    m = oopFactory::new_objArray(vmClasses::Class_klass(), parameter_count, CHECK_(objArrayHandle()));
+  }
   objArrayHandle mirrors(THREAD, m);
   int index = 0;
   // Collect parameter types