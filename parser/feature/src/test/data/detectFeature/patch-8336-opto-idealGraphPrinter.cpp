@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2007, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2007, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -456,6 +456,9 @@ void IdealGraphPrinter::visit_node(Node *n, bool edges, VectorSet* temp_set) {
     if (flags & Node::Flag_has_call) {
       print_prop("has_call", "true");
     }
+    if (flags & Node::Flag_is_reduction) {
+      print_prop("is_reduction", "true");
+    }
 
     if (C->matcher() != NULL) {
       if (C->matcher()->is_shared(node)) {