@@ -325,9 +325,7 @@ private byte[] toByteArray() {
         ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
         classNode.accept(cw);
         cw.visitEnd();
-        byte[] result = cw.toByteArray();
-        Utils.writeGeneratedASM(classNode.name, result);
-        return result;
+        return cw.toByteArray();
     }
 
     public byte[] buildUninstrumented() {