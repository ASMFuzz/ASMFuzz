@@ -31,8 +31,8 @@
 import java.nio.file.Path;
 import java.security.AccessController;
 import java.security.PrivilegedAction;
-import java.util.Map;
 import java.util.Objects;
+import java.util.Set;
 import java.util.concurrent.ConcurrentHashMap;
 
 /**
@@ -45,7 +45,7 @@
  * 3. No relationship with class loaders.
  */
 public final class RawNativeLibraries {
-    final Map<String, RawNativeLibraryImpl> libraries = new ConcurrentHashMap<>();
+    final Set<RawNativeLibraryImpl> libraries = ConcurrentHashMap.newKeySet();
     final Class<?> caller;
 
     private RawNativeLibraries(MethodHandles.Lookup trustedCaller) {
@@ -70,6 +70,12 @@ public static RawNativeLibraries newInstance(MethodHandles.Lookup trustedCaller)
      * Load a native library from the given path.  Returns null if the given
      * library is determined to be non-loadable, which is system-dependent.
      *
+     * The library is opened with the platform-specific library loading
+     * mechanism. If this method is called with the same path multiple times,
+     * the library is opened the same number of times. To close the library
+     * of the given path, {@code #unload} must be called on all the
+     * {@code NativeLibrary} instances that load it.
+     *
      * @param path the path of the native library
      */
     @SuppressWarnings("removal")
@@ -106,28 +112,39 @@ public String run() {
      *     NativeLibrary lib = libs.load(System.mapLibraryName("blas"));
      * }
      *
+     * The library is opened with the platform-specific library loading
+     * mechanism. If this method is called with the same pathname multiple times,
+     * the library is opened the same number of times. To close the library
+     * of the given path, {@code #unload} must be called on all the
+     * {@code NativeLibrary} instances that load it.
+     *
      * @param pathname the pathname of the native library
      * @see System#mapLibraryName(String)
      */
     public NativeLibrary load(String pathname) {
-         return libraries.computeIfAbsent(pathname, this::get);
-    }
-
-    private RawNativeLibraryImpl get(String pathname) {
-        RawNativeLibraryImpl lib = new RawNativeLibraryImpl(caller, pathname);
+        RawNativeLibraryImpl lib = new RawNativeLibraryImpl(pathname);
         if (!lib.open()) {
             return null;
         }
+        libraries.add(lib);
         return lib;
     }
 
     /*
-     * Unloads the given native library.
+     * Unloads the given native library.  Each {@code NativeLibrary}
+     * instance can be unloaded only once.
+     *
+     * The native library may remain opened after this method is called.
+     * Refer to the platform-specific library loading mechanism, for example,
+     * dlopen/dlclose on Unix or LoadLibrary/FreeLibrary on Windows.
+     *
+     * @throws IllegalArgumentException if the given library is not
+     * loaded by this RawNativeLibraries or has already been unloaded
      */
     public void unload(NativeLibrary lib) {
         Objects.requireNonNull(lib);
-        if (!libraries.remove(lib.name(), lib)) {
-            throw new IllegalArgumentException(lib.name() + " not loaded by this RawNativeLibraries instance");
+        if (!libraries.remove(lib)) {
+            throw new IllegalArgumentException("can't unload " + lib.name() + " loaded from " + lib);
         }
         RawNativeLibraryImpl nl = (RawNativeLibraryImpl)lib;
         nl.close();
@@ -139,7 +156,7 @@ static class RawNativeLibraryImpl extends NativeLibrary {
         // opaque handle to raw native library, used in native code.
         long handle;
 
-        RawNativeLibraryImpl(Class<?> fromClass, String name) {
+        RawNativeLibraryImpl(String name) {
             this.name = name;
         }
 