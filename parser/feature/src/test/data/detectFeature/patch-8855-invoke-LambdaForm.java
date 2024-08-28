@@ -199,13 +199,8 @@ static BasicType basicType(char type) {
                 default -> throw newInternalError("Unknown type char: '" + type + "'");
             };
         }
-        static BasicType basicType(Wrapper type) {
-            char c = type.basicTypeChar();
-            return basicType(c);
-        }
         static BasicType basicType(Class<?> type) {
-            if (!type.isPrimitive())  return L_TYPE;
-            return basicType(Wrapper.forPrimitiveType(type));
+            return basicType(Wrapper.basicTypeChar(type));
         }
         static int[] basicTypeOrds(BasicType[] types) {
             if (types == null) {