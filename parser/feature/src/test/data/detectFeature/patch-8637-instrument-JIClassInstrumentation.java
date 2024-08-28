@@ -37,7 +37,6 @@
 import jdk.internal.org.objectweb.asm.Opcodes;
 import jdk.internal.org.objectweb.asm.tree.ClassNode;
 import jdk.jfr.internal.SecuritySupport;
-import jdk.jfr.internal.Utils;
 
 /**
  * This class will perform byte code instrumentation given an "instrumentor" class.
@@ -72,7 +71,6 @@ final class JIClassInstrumentation {
         this.targetClassReader = new ClassReader(old_target_bytes);
         this.instrClassReader = new ClassReader(getOriginalClassBytes(instrumentor));
         this.newBytes = makeBytecode();
-        Utils.writeGeneratedASM(target.getName(), newBytes);
     }
 
     private static byte[] getOriginalClassBytes(Class<?> clazz) throws IOException {