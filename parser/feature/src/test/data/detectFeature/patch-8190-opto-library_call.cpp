@@ -2194,32 +2194,49 @@ bool LibraryCallKit::inline_number_methods(vmIntrinsics::ID id) {
 }
 
 //--------------------------inline_unsigned_divmod_methods-----------------------------
-// inline int Integer.divideUnsigned(init, int)
+// inline int Integer.divideUnsigned(int, int)
 // inline int Integer.remainderUnsigned(int, int)
+// inline long Long.divideUnsigned(long, long)
+// inline long Long.remainderUnsigned(long, long)
 bool LibraryCallKit::inline_divmod_methods(vmIntrinsics::ID id) {
   Node* n = NULL;
-  switch(id) {
-    case vmIntrinsics::_divideUnsigned_i:
+  switch (id) {
+    case vmIntrinsics::_divideUnsigned_i: {
       zero_check_int(argument(1));
-      // Compile-time detect of null-exception?
-      if (stopped()) return false;
+      // Compile-time detect of null-exception
+      if (stopped()) {
+        return true; // keep the graph constructed so far
+      }
       n = new UDivINode(control(), argument(0), argument(1));
       break;
-    case vmIntrinsics::_divideUnsigned_l:
+    }
+    case vmIntrinsics::_divideUnsigned_l: {
       zero_check_long(argument(2));
-      // Compile-time detect of null-exception?
-      if (stopped()) return false;
-      n = new UDivLNode(control(), argument(0), argument(2));  break;
-    case vmIntrinsics::_remainderUnsigned_i:
+      // Compile-time detect of null-exception
+      if (stopped()) {
+        return true; // keep the graph constructed so far
+      }
+      n = new UDivLNode(control(), argument(0), argument(2));
+      break;
+    }
+    case vmIntrinsics::_remainderUnsigned_i: {
       zero_check_int(argument(1));
-      // Compile-time detect of null-exception?
-      if (stopped()) return false;
-      n = new UModINode(control(), argument(0), argument(1));  break;
-    case vmIntrinsics::_remainderUnsigned_l:
+      // Compile-time detect of null-exception
+      if (stopped()) {
+        return true; // keep the graph constructed so far
+      }
+      n = new UModINode(control(), argument(0), argument(1));
+      break;
+    }
+    case vmIntrinsics::_remainderUnsigned_l: {
       zero_check_long(argument(2));
-      // Compile-time detect of null-exception?
-      if (stopped()) return false;
-      n = new UModLNode(control(), argument(0), argument(2));  break;
+      // Compile-time detect of null-exception
+      if (stopped()) {
+        return true; // keep the graph constructed so far
+      }
+      n = new UModLNode(control(), argument(0), argument(2));
+      break;
+    }
     default:  fatal_unexpected_iid(id);  break;
   }
   set_result(_gvn.transform(n));