@@ -222,10 +222,10 @@ static char basicTypeChar(Class<?> type) {
             return basicType(type).btChar;
         }
 
-        static byte[] basicTypesOrd(Class<?>[] types) {
-            byte[] ords = new byte[types.length];
+        static int[] basicTypesOrd(Class<?>[] types) {
+            int[] ords = new int[types.length];
             for (int i = 0; i < ords.length; i++) {
-                ords[i] = (byte)basicType(types[i]).ordinal();
+                ords[i] = basicType(types[i]).ordinal();
             }
             return ords;
         }