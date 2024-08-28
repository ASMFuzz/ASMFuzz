@@ -18,7 +18,7 @@ public static void t2(Object o) {
             default -> {}
         }
         switch (o) {
-            case RawTypeBindingWarning w when false -> {}
+            case RawTypeBindingWarning w when w == null -> {}
             default -> {}
         }
     }