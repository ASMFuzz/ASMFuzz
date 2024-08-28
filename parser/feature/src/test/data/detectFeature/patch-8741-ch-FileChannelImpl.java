@@ -1014,6 +1014,10 @@ public void run() {
             unmap();
         }
 
+        public long capacity() {
+            return cap;
+        }
+
         public void unmap() {
             if (address == 0)
                 return;
@@ -1126,15 +1130,15 @@ public MappedByteBuffer map(MapMode mode, long position, long size) throws IOExc
             else
                 return Util.newMappedByteBuffer(0, 0, dummy, null, isSync);
         } else if ((!writable) || (prot == MAP_RO)) {
-            return Util.newMappedByteBufferR((int)unmapper.cap,
-                    unmapper.address + unmapper.pagePosition,
-                    unmapper.fd,
-                    unmapper, isSync);
+            return Util.newMappedByteBufferR((int)unmapper.capacity(),
+                    unmapper.address(),
+                    unmapper.fileDescriptor(),
+                    unmapper, unmapper.isSync());
         } else {
-            return Util.newMappedByteBuffer((int)unmapper.cap,
-                    unmapper.address + unmapper.pagePosition,
-                    unmapper.fd,
-                    unmapper, isSync);
+            return Util.newMappedByteBuffer((int)unmapper.capacity(),
+                    unmapper.address(),
+                    unmapper.fileDescriptor(),
+                    unmapper, unmapper.isSync());
         }
     }
 