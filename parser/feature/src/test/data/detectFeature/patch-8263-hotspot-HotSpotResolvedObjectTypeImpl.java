@@ -525,11 +525,6 @@ public int layoutHelper() {
         return UNSAFE.getInt(getMetaspaceKlass() + config.klassLayoutHelperOffset);
     }
 
-    @Override
-    public long getFingerprint() {
-        return compilerToVM().getFingerprint(getMetaspaceKlass());
-    }
-
     synchronized HotSpotResolvedJavaMethod createMethod(long metaspaceHandle) {
         long metaspaceMethod = UNSAFE.getLong(metaspaceHandle);
         // Maintain cache as array.