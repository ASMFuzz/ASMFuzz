@@ -755,6 +755,14 @@ private void addDeserializationCase(MethodHandleSymbol refSym, Type targetType,
         String functionalInterfaceClass = classSig(targetType);
         String functionalInterfaceMethodName = samSym.getSimpleName().toString();
         String functionalInterfaceMethodSignature = typeSig(types.erasure(samSym.type));
+        Symbol baseMethod = refSym.baseSymbol();
+        Symbol origMethod = baseMethod.baseSymbol();
+        if (baseMethod != origMethod && origMethod.owner == syms.objectType.tsym) {
+            //the implementation method is a java.lang.Object method transferred to an
+            //interface that does not declare it. Runtime will refer to this method as to
+            //a java.lang.Object method, so do the same:
+            refSym = ((MethodSymbol) origMethod).asHandle();
+        }
         String implClass = classSig(types.erasure(refSym.owner.type));
         String implMethodName = refSym.getQualifiedName().toString();
         String implMethodSignature = typeSig(types.erasure(refSym.type));