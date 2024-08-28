@@ -45,17 +45,15 @@ public static void main(String... args) throws Exception {
         NativeLibrariesTest test = new NativeLibrariesTest();
         test.runTest();
 
-        try {
-            System.loadLibrary(NativeLibrariesTest.LIB_NAME);
-        } catch (UnsatisfiedLinkError e) { e.printStackTrace(); }
-
-        // unload the native library and then System::loadLibrary should succeed
-        test.unload();
+        // System::loadLibrary succeeds even the library is loaded as raw library
         System.loadLibrary(NativeLibrariesTest.LIB_NAME);
 
         // expect NativeLibraries to succeed even the library has been loaded by System::loadLibrary
         test.loadTestLibrary();
 
+        // unload all NativeLibrary instances
+        test.unload();
+
         // load zip library from JDK
         test.load(System.mapLibraryName("zip"), true /* succeed */);
 