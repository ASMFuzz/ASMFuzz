@@ -369,6 +369,9 @@ default MethodHandle byteOffsetHandle(PathElement... elements) {
      * arguments, whereas {@code c_1}, {@code c_2}, ... {@code c_m} are <em>static</em> offset constants
      * and {@code s_1}, {@code s_2}, ... {@code s_n} are <em>static</em> stride constants which are derived from
      * the layout path.
+     * <p>
+     * Additionally, the provided dynamic values must conform to some bound which is derived from the layout path, that is,
+     * {@code 0 <= x_i < b_i}, where {@code 1 <= i <= n}, or {@link IndexOutOfBoundsException} is thrown.
      *
      * @apiNote the resulting var handle will feature an additional {@code long} access coordinate for every
      * unspecified sequence access component contained in this layout path. Moreover, the resulting var handle
@@ -515,6 +518,7 @@ static PathElement sequenceElement(long index) {
          * Returns a path element which selects the element layout in a <em>range</em> of positions in a sequence layout.
          * The range is expressed as a pair of starting index (inclusive) {@code S} and step factor (which can also be negative)
          * {@code F}.
+         * <p>
          * If a path with free dimensions {@code n} is combined with the path element returned by this method,
          * the number of free dimensions of the resulting path will be {@code 1 + n}. If the free dimension associated
          * with this path is bound by an index {@code I}, the resulting accessed offset can be obtained with the following
@@ -525,6 +529,14 @@ static PathElement sequenceElement(long index) {
          * }</pre></blockquote>
          *
          * where {@code E} is the size (in bytes) of the sequence element layout.
+         * <p>
+         * Additionally, if {@code C} is the sequence element count, it follows that {@code 0 <= I < B},
+         * where {@code B} is computed as follows:
+         *
+         * <ul>
+         *    <li>if {@code F > 0}, then {@code B = ceilDiv(C - S, F)}</li>
+         *    <li>if {@code F < 0}, then {@code B = ceilDiv(-(S + 1), -F)}</li>
+         * </ul>
          *
          * @param start the index of the first sequence element to be selected.
          * @param step the step factor at which subsequence sequence elements are to be selected.
@@ -544,8 +556,19 @@ static PathElement sequenceElement(long start, long step) {
 
         /**
          * Returns a path element which selects an unspecified element layout in a sequence layout.
+         * <p>
          * If a path with free dimensions {@code n} is combined with the path element returned by this method,
-         * the number of free dimensions of the resulting path will be {@code 1 + n}.
+         * the number of free dimensions of the resulting path will be {@code 1 + n}. If the free dimension associated
+         * with this path is bound by an index {@code I}, the resulting accessed offset can be obtained with the following
+         * formula:
+         *
+         * <blockquote><pre>{@code
+         * E * I
+         * }</pre></blockquote>
+         *
+         * where {@code E} is the size (in bytes) of the sequence element layout.
+         * <p>
+         * Additionally, if {@code C} is the sequence element count, it follows that {@code 0 <= I < C}.
          *
          * @return a path element which selects an unspecified sequence element layout.
          */