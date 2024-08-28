@@ -191,13 +191,15 @@ public Object mapValue(final Object value) {
         }
         if (value instanceof Handle) {
             Handle handle = (Handle) value;
+            boolean isFieldHandle = handle.getTag() <= Opcodes.H_PUTSTATIC;
+
             return new Handle(
                     handle.getTag(),
                     mapType(handle.getOwner()),
-                    mapMethodName(handle.getOwner(), handle.getName(), handle.getDesc()),
-                    handle.getTag() <= Opcodes.H_PUTSTATIC
-                            ? mapDesc(handle.getDesc())
-                            : mapMethodDesc(handle.getDesc()),
+                    isFieldHandle
+                            ? mapFieldName(handle.getOwner(), handle.getName(), handle.getDesc())
+                            : mapMethodName(handle.getOwner(), handle.getName(), handle.getDesc()),
+                    isFieldHandle ? mapDesc(handle.getDesc()) : mapMethodDesc(handle.getDesc()),
                     handle.isInterface());
         }
         if (value instanceof ConstantDynamic) {