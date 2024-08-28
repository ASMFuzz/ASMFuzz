@@ -25,18 +25,15 @@
  */
 package java.lang.foreign;
 
-import java.lang.invoke.MethodHandle;
-import java.lang.invoke.MethodType;
-
+import jdk.internal.foreign.abi.AbstractLinker;
 import jdk.internal.foreign.abi.SharedUtils;
-import jdk.internal.foreign.abi.aarch64.linux.LinuxAArch64Linker;
-import jdk.internal.foreign.abi.aarch64.macos.MacOsAArch64Linker;
-import jdk.internal.foreign.abi.x64.sysv.SysVx64Linker;
-import jdk.internal.foreign.abi.x64.windows.Windowsx64Linker;
 import jdk.internal.javac.PreviewFeature;
 import jdk.internal.reflect.CallerSensitive;
 import jdk.internal.reflect.Reflection;
 
+import java.lang.invoke.MethodHandle;
+import java.lang.invoke.MethodType;
+
 /**
  * A linker provides access to foreign functions from Java code, and access to Java code from foreign functions.
  * <p>
@@ -148,7 +145,7 @@
  * @since 19
  */
 @PreviewFeature(feature=PreviewFeature.Feature.FOREIGN)
-public sealed interface Linker permits Windowsx64Linker, SysVx64Linker, LinuxAArch64Linker, MacOsAArch64Linker {
+public sealed interface Linker permits AbstractLinker {
 
     /**
      * Returns a linker for the ABI associated with the underlying native platform. The underlying native platform