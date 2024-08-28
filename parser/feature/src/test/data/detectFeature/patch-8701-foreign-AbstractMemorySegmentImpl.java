@@ -31,8 +31,15 @@
 import java.lang.foreign.MemorySession;
 import java.lang.foreign.SegmentAllocator;
 import java.lang.foreign.ValueLayout;
+import java.nio.Buffer;
 import java.nio.ByteBuffer;
 import java.nio.ByteOrder;
+import java.nio.CharBuffer;
+import java.nio.DoubleBuffer;
+import java.nio.FloatBuffer;
+import java.nio.IntBuffer;
+import java.nio.LongBuffer;
+import java.nio.ShortBuffer;
 import java.util.*;
 import java.util.function.Consumer;
 import java.util.function.Function;
@@ -517,7 +524,7 @@ public int hashCode() {
         );
     }
 
-    public static AbstractMemorySegmentImpl ofBuffer(ByteBuffer bb) {
+    public static AbstractMemorySegmentImpl ofBuffer(Buffer bb) {
         Objects.requireNonNull(bb);
         long bbAddress = nioAccess.getBufferAddress(bb);
         Object base = nioAccess.getBufferBase(bb);
@@ -540,12 +547,50 @@ public static AbstractMemorySegmentImpl ofBuffer(ByteBuffer bb) {
         if (bb.isReadOnly()) {
             modes |= READ_ONLY;
         }
+        int scaleFactor = getScaleFactor(bb);
         if (base != null) {
-            return new HeapMemorySegmentImpl.OfByte(bbAddress + pos, (byte[])base, size, modes);
+            if (base instanceof byte[]) {
+                return new HeapMemorySegmentImpl.OfByte(bbAddress + (pos << scaleFactor), base, size << scaleFactor, modes);
+            } else if (base instanceof short[]) {
+                return new HeapMemorySegmentImpl.OfShort(bbAddress + (pos << scaleFactor), base, size << scaleFactor, modes);
+            } else if (base instanceof char[]) {
+                return new HeapMemorySegmentImpl.OfChar(bbAddress + (pos << scaleFactor), base, size << scaleFactor, modes);
+            } else if (base instanceof int[]) {
+                return new HeapMemorySegmentImpl.OfInt(bbAddress + (pos << scaleFactor), base, size << scaleFactor, modes);
+            } else if (base instanceof float[]) {
+                return new HeapMemorySegmentImpl.OfFloat(bbAddress + (pos << scaleFactor), base, size << scaleFactor, modes);
+            } else if (base instanceof long[]) {
+                return new HeapMemorySegmentImpl.OfLong(bbAddress + (pos << scaleFactor), base, size << scaleFactor, modes);
+            } else if (base instanceof double[]) {
+                return new HeapMemorySegmentImpl.OfDouble(bbAddress + (pos << scaleFactor), base, size << scaleFactor, modes);
+            } else {
+                throw new AssertionError("Cannot get here");
+            }
         } else if (unmapper == null) {
-            return new NativeMemorySegmentImpl(bbAddress + pos, size, modes, bufferSession);
+            return new NativeMemorySegmentImpl(bbAddress + (pos << scaleFactor), size << scaleFactor, modes, bufferSession);
         } else {
+            // we can ignore scale factor here, a mapped buffer is always a byte buffer, so scaleFactor == 0.
             return new MappedMemorySegmentImpl(bbAddress + pos, unmapper, size, modes, bufferSession);
         }
     }
+
+    private static int getScaleFactor(Buffer buffer) {
+        if (buffer instanceof ByteBuffer) {
+            return 0;
+        } else if (buffer instanceof CharBuffer) {
+            return 1;
+        } else if (buffer instanceof ShortBuffer) {
+            return 1;
+        } else if (buffer instanceof IntBuffer) {
+            return 2;
+        } else if (buffer instanceof FloatBuffer) {
+            return 2;
+        } else if (buffer instanceof LongBuffer) {
+            return 3;
+        } else if (buffer instanceof DoubleBuffer) {
+            return 3;
+        } else {
+            throw new AssertionError("Cannot get here");
+        }
+    }
 }