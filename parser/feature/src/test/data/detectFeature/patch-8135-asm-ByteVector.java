@@ -97,6 +97,15 @@ public ByteVector(final int initialCapacity) {
         this.length = data.length;
     }
 
+    /**
+      * Returns the actual number of bytes in this vector.
+      *
+      * @return the actual number of bytes in this vector.
+      */
+    public int size() {
+        return length;
+    }
+
     /**
       * Puts a byte into this byte vector. The byte vector is automatically enlarged if necessary.
       *
@@ -384,6 +393,9 @@ public ByteVector putByteArray(
       * @param size number of additional bytes that this byte vector should be able to receive.
       */
     private void enlarge(final int size) {
+        if (length > data.length) {
+            throw new AssertionError("Internal error");
+        }
         int doubleCapacity = 2 * data.length;
         int minimalCapacity = length + size;
         byte[] newData = new byte[doubleCapacity > minimalCapacity ? doubleCapacity : minimalCapacity];