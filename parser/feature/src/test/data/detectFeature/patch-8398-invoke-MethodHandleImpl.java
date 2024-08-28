@@ -323,7 +323,7 @@ static MethodHandle makePairwiseConvertByEditor(MethodHandle target, MethodType
                 for (int pos : positions) {
                     ptypes[pos - 1] = newType;
                 }
-                midType = MethodType.makeImpl(midType.rtype(), ptypes, true);
+                midType = MethodType.methodType(midType.rtype(), ptypes, true);
             }
             LambdaForm form2;
             if (positions.length > 1) {