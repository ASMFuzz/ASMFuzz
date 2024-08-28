@@ -245,7 +245,9 @@ public sealed interface MemorySegment extends Addressable permits AbstractMemory
      * {@return the base memory address associated with this native memory segment}
      * @throws UnsupportedOperationException if this segment is not a {@linkplain #isNative() native} segment.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      */
     @Override
     MemoryAddress address();
@@ -420,7 +422,9 @@ default MemorySegment asSlice(long offset) {
      * @param value the value to fill into this segment
      * @return this memory segment
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws UnsupportedOperationException if this segment is read-only (see {@link #isReadOnly()}).
      */
     MemorySegment fill(byte value);
@@ -437,9 +441,13 @@ default MemorySegment asSlice(long offset) {
      * @param src the source segment.
      * @throws IndexOutOfBoundsException if {@code src.byteSize() > this.byteSize()}.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with {@code src} is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with {@code src}.
      * @throws UnsupportedOperationException if this segment is read-only (see {@link #isReadOnly()}).
      * @return this segment.
      */
@@ -467,9 +475,13 @@ default MemorySegment copyFrom(MemorySegment src) {
      * @return the relative offset, in bytes, of the first mismatch between this
      * and the given other segment, otherwise -1 if no mismatch
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with {@code other} is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with {@code other}.
      */
     long mismatch(MemorySegment other);
 
@@ -492,7 +504,9 @@ default MemorySegment copyFrom(MemorySegment src) {
      *          is resident in physical memory
      *
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws UnsupportedOperationException if this segment is not a mapped memory segment, e.g. if
      * {@code isMapped() == false}.
      */
@@ -507,7 +521,9 @@ default MemorySegment copyFrom(MemorySegment src) {
      * occur. </p>
      *
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws UnsupportedOperationException if this segment is not a mapped memory segment, e.g. if
      * {@code isMapped() == false}.
      */
@@ -522,7 +538,9 @@ default MemorySegment copyFrom(MemorySegment src) {
      * occur (as this segment's contents might need to be paged back in). </p>
      *
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws UnsupportedOperationException if this segment is not a mapped memory segment, e.g. if
      * {@code isMapped() == false}.
      */
@@ -549,7 +567,9 @@ default MemorySegment copyFrom(MemorySegment src) {
      * </p>
      *
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws UnsupportedOperationException if this segment is not a mapped memory segment, e.g. if
      * {@code isMapped() == false}.
      * @throws UncheckedIOException if there is an I/O error writing the contents of this segment to the associated storage device
@@ -569,7 +589,10 @@ default MemorySegment copyFrom(MemorySegment src) {
      * returned if this segment' size is greater than {@link Integer#MAX_VALUE}.
      * <p>
      * The life-cycle of the returned buffer will be tied to that of this segment. That is, accessing the returned buffer
-     * after the memory session associated with this segment has been closed (see {@link MemorySession#close()}), will throw an {@link IllegalStateException}.
+     * after the memory session associated with this segment has been closed (see {@link MemorySession#close()}), will
+     * throw an {@link IllegalStateException}. Similarly, accessing the returned buffer from a thread other than
+     * the thread {@linkplain MemorySession#ownerThread() owning} this segment's memory session will throw
+     * a {@link WrongThreadException}.
      * <p>
      * If this segment is associated with a confined memory session, calling read/write I/O operations on the resulting buffer
      * might result in an unspecified exception being thrown. Examples of such problematic operations are
@@ -592,7 +615,9 @@ default MemorySegment copyFrom(MemorySegment src) {
      * different from the {@linkplain ByteOrder#nativeOrder native order}, a byte swap operation will be performed on each array element.
      * @return a new byte array whose contents are copied from this memory segment.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalStateException if this segment's contents cannot be copied into a {@code byte[]} instance,
      * e.g. its size is greater than {@link Integer#MAX_VALUE}.
      */
@@ -604,7 +629,9 @@ default MemorySegment copyFrom(MemorySegment src) {
      * different from the {@linkplain ByteOrder#nativeOrder native order}, a byte swap operation will be performed on each array element.
      * @return a new short array whose contents are copied from this memory segment.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalStateException if this segment's contents cannot be copied into a {@code short[]} instance,
      * e.g. because {@code byteSize() % 2 != 0}, or {@code byteSize() / 2 > Integer#MAX_VALUE}
      */
@@ -616,7 +643,9 @@ default MemorySegment copyFrom(MemorySegment src) {
      * different from the {@linkplain ByteOrder#nativeOrder native order}, a byte swap operation will be performed on each array element.
      * @return a new char array whose contents are copied from this memory segment.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalStateException if this segment's contents cannot be copied into a {@code char[]} instance,
      * e.g. because {@code byteSize() % 2 != 0}, or {@code byteSize() / 2 > Integer#MAX_VALUE}.
      */
@@ -628,7 +657,9 @@ default MemorySegment copyFrom(MemorySegment src) {
      * different from the {@linkplain ByteOrder#nativeOrder native order}, a byte swap operation will be performed on each array element.
      * @return a new int array whose contents are copied from this memory segment.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalStateException if this segment's contents cannot be copied into a {@code int[]} instance,
      * e.g. because {@code byteSize() % 4 != 0}, or {@code byteSize() / 4 > Integer#MAX_VALUE}.
      */
@@ -640,7 +671,9 @@ default MemorySegment copyFrom(MemorySegment src) {
      * different from the {@linkplain ByteOrder#nativeOrder native order}, a byte swap operation will be performed on each array element.
      * @return a new float array whose contents are copied from this memory segment.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalStateException if this segment's contents cannot be copied into a {@code float[]} instance,
      * e.g. because {@code byteSize() % 4 != 0}, or {@code byteSize() / 4 > Integer#MAX_VALUE}.
      */
@@ -652,7 +685,9 @@ default MemorySegment copyFrom(MemorySegment src) {
      * different from the {@linkplain ByteOrder#nativeOrder native order}, a byte swap operation will be performed on each array element.
      * @return a new long array whose contents are copied from this memory segment.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalStateException if this segment's contents cannot be copied into a {@code long[]} instance,
      * e.g. because {@code byteSize() % 8 != 0}, or {@code byteSize() / 8 > Integer#MAX_VALUE}.
      */
@@ -664,7 +699,9 @@ default MemorySegment copyFrom(MemorySegment src) {
      * different from the {@linkplain ByteOrder#nativeOrder native order}, a byte swap operation will be performed on each array element.
      * @return a new double array whose contents are copied from this memory segment.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalStateException if this segment's contents cannot be copied into a {@code double[]} instance,
      * e.g. because {@code byteSize() % 8 != 0}, or {@code byteSize() / 8 > Integer#MAX_VALUE}.
      */
@@ -685,7 +722,9 @@ default MemorySegment copyFrom(MemorySegment src) {
      * @throws IndexOutOfBoundsException if {@code S + offset > byteSize()}, where {@code S} is the size of the UTF-8
      * string (including the terminator character).
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      */
     default String getUtf8String(long offset) {
         return SharedUtils.toJavaStringInternal(this, offset);
@@ -703,7 +742,9 @@ default String getUtf8String(long offset) {
      * @param str the Java string to be written into this segment.
      * @throws IndexOutOfBoundsException if {@code str.getBytes().length() + offset >= byteSize()}.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      */
     default void setUtf8String(long offset, String str) {
         Utils.toCString(str.getBytes(StandardCharsets.UTF_8), SegmentAllocator.prefixAllocator(asSlice(offset)));
@@ -830,8 +871,9 @@ static MemorySegment ofArray(double[] arr) {
      * @param session the native segment memory session.
      * @return a native memory segment with the given base address, size and memory session.
      * @throws IllegalArgumentException if {@code bytesSize < 0}.
-     * @throws IllegalStateException if {@code session} is not {@linkplain MemorySession#isAlive() alive}, or if access occurs from
-     * a thread other than the thread {@linkplain MemorySession#ownerThread() owning} {@code session}.
+     * @throws IllegalStateException if {@code session} is not {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread
+     * {@linkplain MemorySession#ownerThread() owning} {@code session}.
      * @throws IllegalCallerException if access to this method occurs from a module {@code M} and the command line option
      * {@code --enable-native-access} is specified, but does not mention the module name {@code M}, or
      * {@code ALL-UNNAMED} in case {@code M} is an unnamed module.
@@ -862,8 +904,9 @@ static MemorySegment ofAddress(MemoryAddress address, long bytesSize, MemorySess
      * @param layout the layout of the off-heap memory block backing the native memory segment.
      * @param session the segment memory session.
      * @return a new native memory segment.
-     * @throws IllegalStateException if {@code session} is not {@linkplain MemorySession#isAlive() alive}, or if access occurs from
-     * a thread other than the thread {@linkplain MemorySession#ownerThread() owning} {@code session}.
+     * @throws IllegalStateException if {@code session} is not {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread
+     * {@linkplain MemorySession#ownerThread() owning} {@code session}.
      */
     static MemorySegment allocateNative(MemoryLayout layout, MemorySession session) {
         Objects.requireNonNull(session);
@@ -887,8 +930,9 @@ static MemorySegment allocateNative(MemoryLayout layout, MemorySession session)
      * @param session the segment temporal bounds.
      * @return a new native memory segment.
      * @throws IllegalArgumentException if {@code bytesSize < 0}.
-     * @throws IllegalStateException if {@code session} is not {@linkplain MemorySession#isAlive() alive}, or if access occurs from
-     * a thread other than the thread {@linkplain MemorySession#ownerThread() owning} {@code session}.
+     * @throws IllegalStateException if {@code session} is not {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread
+     * {@linkplain MemorySession#ownerThread() owning} {@code session}.
      */
     static MemorySegment allocateNative(long bytesSize, MemorySession session) {
         return allocateNative(bytesSize, 1, session);
@@ -907,8 +951,9 @@ static MemorySegment allocateNative(long bytesSize, MemorySession session) {
      * @return a new native memory segment.
      * @throws IllegalArgumentException if {@code bytesSize < 0}, {@code alignmentBytes <= 0}, or if {@code alignmentBytes}
      * is not a power of 2.
-     * @throws IllegalStateException if {@code session} is not {@linkplain MemorySession#isAlive() alive}, or if access occurs from
-     * a thread other than the thread {@linkplain MemorySession#ownerThread() owning} {@code session}.
+     * @throws IllegalStateException if {@code session} is not {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread
+     * {@linkplain MemorySession#ownerThread() owning} {@code session}.
      */
     static MemorySegment allocateNative(long bytesSize, long alignmentBytes, MemorySession session) {
         Objects.requireNonNull(session);
@@ -948,9 +993,13 @@ static MemorySegment allocateNative(long bytesSize, long alignmentBytes, MemoryS
      * @param dstOffset the starting offset, in bytes, of the destination segment.
      * @param bytes the number of bytes to be copied.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with {@code srcSegment} is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with {@code srcSegment}.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with {@code dstSegment} is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with {@code dstSegment}.
      * @throws IndexOutOfBoundsException if {@code srcOffset + bytes > srcSegment.byteSize()} or if
      * {@code dstOffset + bytes > dstSegment.byteSize()}, or if either {@code srcOffset}, {@code dstOffset}
      * or {@code bytes} are {@code < 0}.
@@ -991,9 +1040,13 @@ static void copy(MemorySegment srcSegment, long srcOffset, MemorySegment dstSegm
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the source
      * (resp. destination) element layout, or if the source (resp. destination) element layout alignment is greater than its size.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with {@code srcSegment} is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this {@code srcSegment}.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with {@code dstSegment} is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with {@code dstSegment}.
      * @throws IndexOutOfBoundsException if {@code srcOffset + (elementCount * S) > srcSegment.byteSize()} or if
      * {@code dstOffset + (elementCount * S) > dstSegment.byteSize()}, where {@code S} is the byte size
      * of the element layouts, or if either {@code srcOffset}, {@code dstOffset} or {@code elementCount} are {@code < 0}.
@@ -1041,7 +1094,9 @@ static void copy(MemorySegment srcSegment, ValueLayout srcElementLayout, long sr
      *               the final address of this read operation can be expressed as {@code address().toRowLongValue() + offset}.
      * @return a byte value read from this address.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout.
      * @throws IndexOutOfBoundsException when the dereference operation falls outside the <em>spatial bounds</em> of the
@@ -1060,7 +1115,9 @@ default byte get(ValueLayout.OfByte layout, long offset) {
      *               the final address of this write operation can be expressed as {@code address().toRowLongValue() + offset}.
      * @param value the byte value to be written.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout.
      * @throws IndexOutOfBoundsException when the dereference operation falls outside the <em>spatial bounds</em> of the
@@ -1080,7 +1137,9 @@ default void set(ValueLayout.OfByte layout, long offset, byte value) {
      *               the final address of this read operation can be expressed as {@code address().toRowLongValue() + offset}.
      * @return a boolean value read from this address.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout.
      * @throws IndexOutOfBoundsException when the dereference operation falls outside the <em>spatial bounds</em> of the
@@ -1099,7 +1158,9 @@ default boolean get(ValueLayout.OfBoolean layout, long offset) {
      *               the final address of this write operation can be expressed as {@code address().toRowLongValue() + offset}.
      * @param value the boolean value to be written.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout.
      * @throws IndexOutOfBoundsException when the dereference operation falls outside the <em>spatial bounds</em> of the
@@ -1119,7 +1180,9 @@ default void set(ValueLayout.OfBoolean layout, long offset, boolean value) {
      *               the final address of this read operation can be expressed as {@code address().toRowLongValue() + offset}.
      * @return a char value read from this address.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout.
      * @throws IndexOutOfBoundsException when the dereference operation falls outside the <em>spatial bounds</em> of the
@@ -1138,7 +1201,9 @@ default char get(ValueLayout.OfChar layout, long offset) {
      *               the final address of this write operation can be expressed as {@code address().toRowLongValue() + offset}.
      * @param value the char value to be written.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout.
      * @throws IndexOutOfBoundsException when the dereference operation falls outside the <em>spatial bounds</em> of the
@@ -1158,7 +1223,9 @@ default void set(ValueLayout.OfChar layout, long offset, char value) {
      *               the final address of this read operation can be expressed as {@code address().toRowLongValue() + offset}.
      * @return a short value read from this address.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout.
      * @throws IndexOutOfBoundsException when the dereference operation falls outside the <em>spatial bounds</em> of the
@@ -1177,7 +1244,9 @@ default short get(ValueLayout.OfShort layout, long offset) {
      *               the final address of this write operation can be expressed as {@code address().toRowLongValue() + offset}.
      * @param value the short value to be written.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout.
      * @throws IndexOutOfBoundsException when the dereference operation falls outside the <em>spatial bounds</em> of the
@@ -1197,7 +1266,9 @@ default void set(ValueLayout.OfShort layout, long offset, short value) {
      *               the final address of this read operation can be expressed as {@code address().toRowLongValue() + offset}.
      * @return an int value read from this address.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout.
      * @throws IndexOutOfBoundsException when the dereference operation falls outside the <em>spatial bounds</em> of the
@@ -1216,7 +1287,9 @@ default int get(ValueLayout.OfInt layout, long offset) {
      *               the final address of this write operation can be expressed as {@code address().toRowLongValue() + offset}.
      * @param value the int value to be written.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout.
      * @throws IndexOutOfBoundsException when the dereference operation falls outside the <em>spatial bounds</em> of the
@@ -1236,7 +1309,9 @@ default void set(ValueLayout.OfInt layout, long offset, int value) {
      *               the final address of this read operation can be expressed as {@code address().toRowLongValue() + offset}.
      * @return a float value read from this address.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout.
      * @throws IndexOutOfBoundsException when the dereference operation falls outside the <em>spatial bounds</em> of the
@@ -1255,7 +1330,9 @@ default float get(ValueLayout.OfFloat layout, long offset) {
      *               the final address of this write operation can be expressed as {@code address().toRowLongValue() + offset}.
      * @param value the float value to be written.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout.
      * @throws IndexOutOfBoundsException when the dereference operation falls outside the <em>spatial bounds</em> of the
@@ -1275,7 +1352,9 @@ default void set(ValueLayout.OfFloat layout, long offset, float value) {
      *               the final address of this read operation can be expressed as {@code address().toRowLongValue() + offset}.
      * @return a long value read from this address.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout.
      * @throws IndexOutOfBoundsException when the dereference operation falls outside the <em>spatial bounds</em> of the
@@ -1294,7 +1373,9 @@ default long get(ValueLayout.OfLong layout, long offset) {
      *               the final address of this write operation can be expressed as {@code address().toRowLongValue() + offset}.
      * @param value the long value to be written.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout.
      * @throws IndexOutOfBoundsException when the dereference operation falls outside the <em>spatial bounds</em> of the
@@ -1314,7 +1395,9 @@ default void set(ValueLayout.OfLong layout, long offset, long value) {
      *               the final address of this read operation can be expressed as {@code address().toRowLongValue() + offset}.
      * @return a double value read from this address.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout.
      * @throws IndexOutOfBoundsException when the dereference operation falls outside the <em>spatial bounds</em> of the
@@ -1333,7 +1416,9 @@ default double get(ValueLayout.OfDouble layout, long offset) {
      *               the final address of this write operation can be expressed as {@code address().toRowLongValue() + offset}.
      * @param value the double value to be written.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout.
      * @throws IndexOutOfBoundsException when the dereference operation falls outside the <em>spatial bounds</em> of the
@@ -1353,7 +1438,9 @@ default void set(ValueLayout.OfDouble layout, long offset, double value) {
      *               the final address of this read operation can be expressed as {@code address().toRowLongValue() + offset}.
      * @return an address value read from this address.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout.
      * @throws IndexOutOfBoundsException when the dereference operation falls outside the <em>spatial bounds</em> of the
@@ -1372,7 +1459,9 @@ default MemoryAddress get(ValueLayout.OfAddress layout, long offset) {
      *               the final address of this write operation can be expressed as {@code address().toRowLongValue() + offset}.
      * @param value the address value to be written.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout.
      * @throws IndexOutOfBoundsException when the dereference operation falls outside the <em>spatial bounds</em> of the
@@ -1392,7 +1481,9 @@ default void set(ValueLayout.OfAddress layout, long offset, Addressable value) {
      *               the final address of this read operation can be expressed as {@code address().toRowLongValue() + (index * layout.byteSize())}.
      * @return a char value read from this address.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout,
      * or if the layout alignment is greater than its size.
@@ -1414,7 +1505,9 @@ default char getAtIndex(ValueLayout.OfChar layout, long index) {
      *               the final address of this write operation can be expressed as {@code address().toRowLongValue() + (index * layout.byteSize())}.
      * @param value the char value to be written.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout,
      * or if the layout alignment is greater than its size.
@@ -1437,7 +1530,9 @@ default void setAtIndex(ValueLayout.OfChar layout, long index, char value) {
      *               the final address of this read operation can be expressed as {@code address().toRowLongValue() + (index * layout.byteSize())}.
      * @return a short value read from this address.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout,
      * or if the layout alignment is greater than its size.
@@ -1459,7 +1554,9 @@ default short getAtIndex(ValueLayout.OfShort layout, long index) {
      *               the final address of this write operation can be expressed as {@code address().toRowLongValue() + (index * layout.byteSize())}.
      * @param value the short value to be written.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout,
      * or if the layout alignment is greater than its size.
@@ -1482,7 +1579,9 @@ default void setAtIndex(ValueLayout.OfShort layout, long index, short value) {
      *               the final address of this read operation can be expressed as {@code address().toRowLongValue() + (index * layout.byteSize())}.
      * @return an int value read from this address.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout,
      * or if the layout alignment is greater than its size.
@@ -1504,7 +1603,9 @@ default int getAtIndex(ValueLayout.OfInt layout, long index) {
      *               the final address of this write operation can be expressed as {@code address().toRowLongValue() + (index * layout.byteSize())}.
      * @param value the int value to be written.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout,
      * or if the layout alignment is greater than its size.
@@ -1527,7 +1628,9 @@ default void setAtIndex(ValueLayout.OfInt layout, long index, int value) {
      *               the final address of this read operation can be expressed as {@code address().toRowLongValue() + (index * layout.byteSize())}.
      * @return a float value read from this address.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout,
      * or if the layout alignment is greater than its size.
@@ -1549,7 +1652,9 @@ default float getAtIndex(ValueLayout.OfFloat layout, long index) {
      *               the final address of this write operation can be expressed as {@code address().toRowLongValue() + (index * layout.byteSize())}.
      * @param value the float value to be written.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout,
      * or if the layout alignment is greater than its size.
@@ -1572,7 +1677,9 @@ default void setAtIndex(ValueLayout.OfFloat layout, long index, float value) {
      *               the final address of this read operation can be expressed as {@code address().toRowLongValue() + (index * layout.byteSize())}.
      * @return a long value read from this address.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout,
      * or if the layout alignment is greater than its size.
@@ -1594,7 +1701,9 @@ default long getAtIndex(ValueLayout.OfLong layout, long index) {
      *               the final address of this write operation can be expressed as {@code address().toRowLongValue() + (index * layout.byteSize())}.
      * @param value the long value to be written.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout,
      * or if the layout alignment is greater than its size.
@@ -1617,7 +1726,9 @@ default void setAtIndex(ValueLayout.OfLong layout, long index, long value) {
      *               the final address of this read operation can be expressed as {@code address().toRowLongValue() + (index * layout.byteSize())}.
      * @return a double value read from this address.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout,
      * or if the layout alignment is greater than its size.
@@ -1639,7 +1750,9 @@ default double getAtIndex(ValueLayout.OfDouble layout, long index) {
      *               the final address of this write operation can be expressed as {@code address().toRowLongValue() + (index * layout.byteSize())}.
      * @param value the double value to be written.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout,
      * or if the layout alignment is greater than its size.
@@ -1662,7 +1775,9 @@ default void setAtIndex(ValueLayout.OfDouble layout, long index, double value) {
      *               the final address of this read operation can be expressed as {@code address().toRowLongValue() + (index * layout.byteSize())}.
      * @return an address value read from this address.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout,
      * or if the layout alignment is greater than its size.
@@ -1684,7 +1799,9 @@ default MemoryAddress getAtIndex(ValueLayout.OfAddress layout, long index) {
      *               the final address of this write operation can be expressed as {@code address().toRowLongValue() + (index * layout.byteSize())}.
      * @param value the address value to be written.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this segment is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this segment.
      * @throws IllegalArgumentException if the dereference operation is
      * <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the provided layout,
      * or if the layout alignment is greater than its size.
@@ -1743,7 +1860,9 @@ default void setAtIndex(ValueLayout.OfAddress layout, long index, Addressable va
      * @param dstIndex the starting index of the destination array.
      * @param elementCount the number of array elements to be copied.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with {@code srcSegment} is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with {@code srcSegment}.
      * @throws  IllegalArgumentException if {@code dstArray} is not an array, or if it is an array but whose type is not supported,
      * if the destination array component type does not match the carrier of the source element layout, if the source
      * segment/offset are <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the source element layout,
@@ -1793,7 +1912,9 @@ static void copy(
      * @param dstOffset the starting offset, in bytes, of the destination segment.
      * @param elementCount the number of array elements to be copied.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with {@code dstSegment} is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with {@code dstSegment}.
      * @throws  IllegalArgumentException if {@code srcArray} is not an array, or if it is an array but whose type is not supported,
      * if the source array component type does not match the carrier of the destination element layout, if the destination
      * segment/offset are <a href="MemorySegment.html#segment-alignment">incompatible with the alignment constraints</a> in the destination element layout,