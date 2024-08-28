@@ -472,7 +472,7 @@ private static Type getTypeInternal(
             case '(':
                 return new Type(METHOD, descriptorBuffer, descriptorBegin, descriptorEnd);
             default:
-                throw new IllegalArgumentException();
+                throw new IllegalArgumentException("Invalid descriptor: " + descriptorBuffer);
         }
     }
 