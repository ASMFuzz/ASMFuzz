@@ -68,7 +68,7 @@ final class ProcessEnvironment
         // We cache the C environment.  This means that subsequent calls
         // to putenv/setenv from C will not be visible from Java code.
         byte[][] environ = environ();
-        theEnvironment = new HashMap<>(environ.length/2 + 3);
+        theEnvironment = HashMap.newHashMap(environ.length);
         // Read environment variables back to front,
         // so that earlier variables override later ones.
         for (int i = environ.length-1; i > 0; i-=2)