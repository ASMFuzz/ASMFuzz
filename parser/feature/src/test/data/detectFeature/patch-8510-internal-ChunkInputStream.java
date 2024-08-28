@@ -110,11 +110,4 @@ public void close() throws IOException {
             }
         }
     }
-
-    @Override
-    @SuppressWarnings("removal")
-    protected void finalize() throws Throwable {
-        super.finalize();
-        close();
-    }
 }