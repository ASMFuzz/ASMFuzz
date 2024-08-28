@@ -1115,6 +1115,16 @@ public Void visitValue(ValueTree tree, Void ignore) {
             if (!isConstant(e))
                 env.messages.error(REFERENCE, tree, "dc.value.not.a.constant");
         }
+        TextTree format = tree.getFormat();
+        if (format != null) {
+            String f = format.getBody().toString();
+            long count = format.getBody().toString().chars()
+                    .filter(ch -> ch == '%')
+                    .count();
+            if (count != 1) {
+                env.messages.error(REFERENCE, format, "dc.value.bad.format", f);
+            }
+        }
 
         markEnclosingTag(Flag.HAS_INLINE_TAG);
         return super.visitValue(tree, ignore);