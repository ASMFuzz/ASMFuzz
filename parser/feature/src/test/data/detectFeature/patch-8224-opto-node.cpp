@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -2458,6 +2458,20 @@ void Node_List::yank( Node *n ) {
   }
 }
 
+//------------------------------replace-------------------------------------------
+// Replace o with n
+void Node_List::replace( Node *o, Node *n ) {
+  uint i;
+  for (i = 0; i < _cnt; i++) {
+    if (_nodes[i] == o) {
+      break;
+    }
+  }
+
+  if (i < _cnt) {
+    _nodes[i] = n;
+  }
+}
 //------------------------------dump-------------------------------------------
 void Node_List::dump() const {
 #ifndef PRODUCT