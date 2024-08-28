@@ -30,6 +30,8 @@
 import java.net.URLClassLoader;
 import java.nio.file.Path;
 import java.nio.file.Paths;
+import java.util.HashSet;
+import java.util.Set;
 
 public class NativeLibrariesTest implements Runnable {
     public static final String LIB_NAME = "nativeLibrariesTest";
@@ -52,6 +54,7 @@ static void nativeLibraryUnloaded() {
     }
 
     private final RawNativeLibraries nativeLibraries;
+    private final Set<NativeLibrary> loadedLibraries = new HashSet<>();
 
     public NativeLibrariesTest() {
         this.nativeLibraries = RawNativeLibraries.newInstance(MethodHandles.lookup());
@@ -74,7 +77,7 @@ public void runTest() throws Exception {
         NativeLibrary nl1 = nativeLibraries.load(lib);
         NativeLibrary nl2 = nativeLibraries.load(lib);
         assertTrue(nl1 != null && nl2 != null, "fail to load library");
-        assertTrue(nl1 == nl2, nl1 + " != " + nl2);
+        assertTrue(nl1 != nl2, "Expected different NativeLibrary instances");
         assertTrue(loadedCount == 0, "Native library loaded.  Expected: JNI_OnUnload not invoked");
         assertTrue(unloadedCount == 0, "native library never unloaded");
 
@@ -85,25 +88,40 @@ public void runTest() throws Exception {
         nativeLibraries.unload(nl1);
         assertTrue(unloadedCount == 0, "Native library unloaded.  Expected: JNI_OnUnload not invoked");
 
-        // reload the native library and expect new NativeLibrary instance
+        try {
+            nativeLibraries.unload(nl1);
+            throw new RuntimeException("Expect to fail as the library has already been unloaded");
+        } catch (IllegalArgumentException e) { }
+
+        // load the native library and expect new NativeLibrary instance
         NativeLibrary nl3 = nativeLibraries.load(lib);
         assertTrue(nl1 != nl3, nl1 + " == " + nl3);
         assertTrue(loadedCount == 0, "Native library loaded.  Expected: JNI_OnUnload not invoked");
 
         // load successfully even from another loader
         loadWithCustomLoader();
+
+        // keep the loaded NativeLibrary instances
+        loadedLibraries.add(nl2);
+        loadedLibraries.add(nl3);
     }
 
+    /*
+     * Unloads all loaded NativeLibrary instance
+     */
     public void unload() {
-        NativeLibrary nl = nativeLibraries.load(libraryPath());
-        // unload the native library
-        nativeLibraries.unload(nl);
-        assertTrue(unloadedCount == 0, "Native library unloaded.  Expected: JNI_OnUnload not invoked");
+        System.out.println("Unloading " + loadedLibraries.size() + " NativeLibrary instances");
+        for (NativeLibrary nl : loadedLibraries) {
+            nativeLibraries.unload(nl);
+            assertTrue(unloadedCount == 0, "Native library unloaded.  Expected: JNI_OnUnload not invoked");
+        }
+        loadedLibraries.clear();
     }
 
     public void loadTestLibrary() {
         NativeLibrary nl = nativeLibraries.load(libraryPath());
         assertTrue(nl != null, "fail to load " + libraryPath());
+        loadedLibraries.add(nl);
     }
 
     public void load(String pathname, boolean succeed) {