@@ -226,7 +226,7 @@ public ClassReader(
         this.b = classFileBuffer;
         // Check the class' major_version. This field is after the magic and minor_version fields, which
         // use 4 and 2 bytes respectively.
-        if (checkClassVersion && readShort(classFileOffset + 6) > Opcodes.V19) {
+        if (checkClassVersion && readShort(classFileOffset + 6) > Opcodes.V20) {
             throw new IllegalArgumentException(
                     "Unsupported class file major version " + readShort(classFileOffset + 6));
         }