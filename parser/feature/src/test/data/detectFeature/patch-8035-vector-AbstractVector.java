@@ -62,6 +62,12 @@ abstract class AbstractVector<E> extends Vector<E> {
     /*package-private*/
     static final ByteOrder REGISTER_ENDIAN = ByteOrder.LITTLE_ENDIAN;
 
+    /*package-private*/
+    static final int OFFSET_IN_RANGE = 1;
+
+    /*package-private*/
+    static final int OFFSET_OUT_OF_RANGE = 0;
+
     /*package-private*/
     AbstractVector(Object bits) {
         super(bits);