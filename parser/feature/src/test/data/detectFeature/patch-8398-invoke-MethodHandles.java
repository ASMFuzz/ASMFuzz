@@ -5601,7 +5601,7 @@ private static MethodHandle filterRepeatedArgument(MethodHandle adapter, MethodH
         for (int pos : positions) {
             ptypes[pos - 1] = newParamType;
         }
-        MethodType newType = MethodType.makeImpl(targetType.rtype(), ptypes, true);
+        MethodType newType = MethodType.methodType(targetType.rtype(), ptypes, true);
 
         LambdaForm lform = result.editor().filterRepeatedArgumentForm(BasicType.basicType(newParamType), positions);
         return result.copyWithExtendL(newType, lform, filter);