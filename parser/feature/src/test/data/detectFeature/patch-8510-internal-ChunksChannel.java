@@ -135,11 +135,4 @@ public void close() throws IOException {
     public boolean isOpen() {
         return channel != null;
     }
-
-    @Override
-    @SuppressWarnings("removal")
-    protected void finalize() throws Throwable {
-        super.finalize();
-        close();
-    }
 }