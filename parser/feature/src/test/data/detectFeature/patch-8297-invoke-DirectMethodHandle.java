@@ -896,11 +896,11 @@ private static NamedFunction createFunction(byte func) {
                 case NF_constructorMethod:
                     return getNamedFunction("constructorMethod", OBJ_OBJ_TYPE);
                 case NF_UNSAFE:
-                    MemberName member = new MemberName(MethodHandleStatics.class, "UNSAFE", Unsafe.class, REF_getField);
+                    MemberName member = new MemberName(MethodHandleStatics.class, "UNSAFE", Unsafe.class, REF_getStatic);
                     return new NamedFunction(
-                            MemberName.getFactory().resolveOrFail(REF_getField, member,
+                            MemberName.getFactory().resolveOrFail(REF_getStatic, member,
                                                                   DirectMethodHandle.class, LM_TRUSTED,
-                                                                  NoSuchMethodException.class));
+                                                                  NoSuchFieldException.class));
                 case NF_checkReceiver:
                     member = new MemberName(DirectMethodHandle.class, "checkReceiver", OBJ_OBJ_TYPE, REF_invokeVirtual);
                     return new NamedFunction(