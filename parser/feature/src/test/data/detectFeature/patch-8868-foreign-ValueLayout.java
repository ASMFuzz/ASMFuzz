@@ -137,7 +137,7 @@ public boolean equals(Object other) {
      * Can be used to access a multi-dimensional array whose layout is as follows:
      *
      * {@snippet lang=java :
-     * MemoryLayout arrayLayout = MemoryLayout.sequenceLayout(-1,
+     * SequenceLayout arrayLayout = MemoryLayout.sequenceLayout(-1,
      *                                      MemoryLayout.sequenceLayout(10,
      *                                                  MemoryLayout.sequenceLayout(20, ValueLayout.JAVA_INT)));
      * }
@@ -151,6 +151,22 @@ public boolean equals(Object other) {
      * offset = (10 * 20 * 4 * x) + (20 * 4 * y) + (4 * z)
      * }</pre></blockquote>
      *
+     * Additionally, the values of {@code x}, {@code y} and {@code z} are constrained as follows:
+     * <ul>
+     *     <li>{@code 0 <= x < arrayLayout.elementCount() }</li>
+     *     <li>{@code 0 <= y < 10 }</li>
+     *     <li>{@code 0 <= z < 20 }</li>
+     * </ul>
+     * <p>
+     * Consider the following access expressions:
+     * {@snippet lang=java :
+     * int value1 = arrayHandle.get(10, 2, 4); // ok, accessed offset = 8176
+     * int value2 = arrayHandle.get(0, 0, 30); // out of bounds value for z
+     * }
+     * In the first case, access is well-formed, as the values for {@code x}, {@code y} and {@code z} conform to
+     * the bounds specified above. In the second case, access fails with {@link IndexOutOfBoundsException},
+     * as the value for {@code z} is outside its specified bounds.
+     *
      * @param shape the size of each nested array dimension.
      * @return a var handle which can be used to dereference a multi-dimensional array, featuring {@code shape.length + 1}
      * {@code long} coordinates.