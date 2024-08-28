@@ -114,12 +114,6 @@ void throwFault(String message, Throwable t) {
      * Just exits if passes or throws an Error if failed.
      */
     public void run() {
-        if (System.getProperty("requiresCompressedClassSpace") != null &&
-                   !isCompressedClassSpaceAvailable()) {
-                System.out.println("Not applicalbe, Compressed Class Space is required");
-            return;
-        }
-
         try {
             log("Bootstrapping string concatenation for " + whoAmI );
             go();
@@ -240,15 +234,6 @@ boolean isMetaspaceError(OutOfMemoryError error) {
                         message.contains("Compressed class space"));
     }
 
-    boolean isCompressedClassSpaceAvailable() {
-        for (MemoryPoolMXBean pool : ManagementFactory.getMemoryPoolMXBeans()) {
-            if (pool.getName().equalsIgnoreCase("Compressed class space")) {
-                return true;
-            }
-        }
-        return false;
-    }
-
     /**
      * Runtime exception signaling test failure.
      */