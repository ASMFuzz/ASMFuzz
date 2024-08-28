@@ -598,7 +598,7 @@ default MemorySegment copyFrom(MemorySegment src) {
      * different from the native order, a byte swap operation will be performed on each array element.
      * @return a fresh byte array copy of this memory segment.
      * @throws IllegalStateException if the scope associated with this segment has been closed, or if access occurs from
-     * a thread other than the thread owning that scope, or if this segment's contents cannot be copied into a {@link byte[]} instance,
+     * a thread other than the thread owning that scope, or if this segment's contents cannot be copied into a {@code byte[]} instance,
      * e.g. its size is greater than {@link Integer#MAX_VALUE}.
      */
     byte[] toArray(ValueLayout.OfByte elementLayout);
@@ -609,7 +609,7 @@ default MemorySegment copyFrom(MemorySegment src) {
      * different from the native order, a byte swap operation will be performed on each array element.
      * @return a fresh short array copy of this memory segment.
      * @throws IllegalStateException if the scope associated with this segment has been closed, or if access occurs from
-     * a thread other than the thread owning that scope, or if this segment's contents cannot be copied into a {@link short[]} instance,
+     * a thread other than the thread owning that scope, or if this segment's contents cannot be copied into a {@code short[]} instance,
      * e.g. because {@code byteSize() % 2 != 0}, or {@code byteSize() / 2 > Integer#MAX_VALUE}
      */
     short[] toArray(ValueLayout.OfShort elementLayout);
@@ -620,7 +620,7 @@ default MemorySegment copyFrom(MemorySegment src) {
      * different from the native order, a byte swap operation will be performed on each array element.
      * @return a fresh char array copy of this memory segment.
      * @throws IllegalStateException if the scope associated with this segment has been closed, or if access occurs from
-     * a thread other than the thread owning that scope, or if this segment's contents cannot be copied into a {@link char[]} instance,
+     * a thread other than the thread owning that scope, or if this segment's contents cannot be copied into a {@code char[]} instance,
      * e.g. because {@code byteSize() % 2 != 0}, or {@code byteSize() / 2 > Integer#MAX_VALUE}.
      */
     char[] toArray(ValueLayout.OfChar elementLayout);
@@ -631,7 +631,7 @@ default MemorySegment copyFrom(MemorySegment src) {
      * different from the native order, a byte swap operation will be performed on each array element.
      * @return a fresh int array copy of this memory segment.
      * @throws IllegalStateException if the scope associated with this segment has been closed, or if access occurs from
-     * a thread other than the thread owning that scope, or if this segment's contents cannot be copied into a {@link int[]} instance,
+     * a thread other than the thread owning that scope, or if this segment's contents cannot be copied into a {@code int[]} instance,
      * e.g. because {@code byteSize() % 4 != 0}, or {@code byteSize() / 4 > Integer#MAX_VALUE}.
      */
     int[] toArray(ValueLayout.OfInt elementLayout);
@@ -642,7 +642,7 @@ default MemorySegment copyFrom(MemorySegment src) {
      * different from the native order, a byte swap operation will be performed on each array element.
      * @return a fresh float array copy of this memory segment.
      * @throws IllegalStateException if the scope associated with this segment has been closed, or if access occurs from
-     * a thread other than the thread owning that scope, or if this segment's contents cannot be copied into a {@link float[]} instance,
+     * a thread other than the thread owning that scope, or if this segment's contents cannot be copied into a {@code float[]} instance,
      * e.g. because {@code byteSize() % 4 != 0}, or {@code byteSize() / 4 > Integer#MAX_VALUE}.
      */
     float[] toArray(ValueLayout.OfFloat elementLayout);
@@ -653,7 +653,7 @@ default MemorySegment copyFrom(MemorySegment src) {
      * different from the native order, a byte swap operation will be performed on each array element.
      * @return a fresh long array copy of this memory segment.
      * @throws IllegalStateException if the scope associated with this segment has been closed, or if access occurs from
-     * a thread other than the thread owning that scope, or if this segment's contents cannot be copied into a {@link long[]} instance,
+     * a thread other than the thread owning that scope, or if this segment's contents cannot be copied into a {@code long[]} instance,
      * e.g. because {@code byteSize() % 8 != 0}, or {@code byteSize() / 8 > Integer#MAX_VALUE}.
      */
     long[] toArray(ValueLayout.OfLong elementLayout);
@@ -664,7 +664,7 @@ default MemorySegment copyFrom(MemorySegment src) {
      * different from the native order, a byte swap operation will be performed on each array element.
      * @return a fresh double array copy of this memory segment.
      * @throws IllegalStateException if the scope associated with this segment has been closed, or if access occurs from
-     * a thread other than the thread owning that scope, or if this segment's contents cannot be copied into a {@link double[]} instance,
+     * a thread other than the thread owning that scope, or if this segment's contents cannot be copied into a {@code double[]} instance,
      * e.g. because {@code byteSize() % 8 != 0}, or {@code byteSize() / 8 > Integer#MAX_VALUE}.
      */
     double[] toArray(ValueLayout.OfDouble elementLayout);