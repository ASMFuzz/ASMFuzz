@@ -133,20 +133,6 @@ public synchronized void release() {
         }
     }
 
-    @Override
-    @SuppressWarnings("removal")
-    protected void finalize() {
-        boolean destroy = false;
-        synchronized (this) {
-            if (refCount > 0) {
-                destroy = true;
-            }
-        }
-        if (destroy) {
-            destroy();
-        }
-    }
-
     public long getSize() {
         return size;
     }