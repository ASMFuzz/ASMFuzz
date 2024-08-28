@@ -393,7 +393,7 @@ static boolean isPullModeBSM(MethodHandle bsm) {
      * The JVM wants a pointer to a MethodType.  Oblige it by finding or creating one.
      */
     static MethodType findMethodHandleType(Class<?> rtype, Class<?>[] ptypes) {
-        return MethodType.makeImpl(rtype, ptypes, true);
+        return MethodType.methodType(rtype, ptypes, true);
     }
 
     /**
@@ -561,7 +561,7 @@ private static MemberName varHandleOperationLinkerMethod(String name,
             }
             // Access descriptor at end
             guardParams[guardParams.length - 1] = VarHandle.AccessDescriptor.class;
-            MethodType guardType = MethodType.makeImpl(guardReturnType, guardParams, true);
+            MethodType guardType = MethodType.methodType(guardReturnType, guardParams, true);
 
             MemberName linker = new MemberName(
                     VarHandleGuards.class, getVarHandleGuardMethodName(guardType),