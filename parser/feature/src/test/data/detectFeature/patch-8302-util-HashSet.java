@@ -125,6 +125,10 @@ public HashSet(Collection<? extends E> c) {
      * Constructs a new, empty set; the backing {@code HashMap} instance has
      * the specified initial capacity and the specified load factor.
      *
+     * @apiNote
+     * To create a {@code HashSet} with an initial capacity that accommodates
+     * an expected number of elements, use {@link #newHashSet(int) newHashSet}.
+     *
      * @param      initialCapacity   the initial capacity of the hash map
      * @param      loadFactor        the load factor of the hash map
      * @throws     IllegalArgumentException if the initial capacity is less
@@ -138,6 +142,10 @@ public HashSet(int initialCapacity, float loadFactor) {
      * Constructs a new, empty set; the backing {@code HashMap} instance has
      * the specified initial capacity and default load factor (0.75).
      *
+     * @apiNote
+     * To create a {@code HashSet} with an initial capacity that accommodates
+     * an expected number of elements, use {@link #newHashSet(int) newHashSet}.
+     *
      * @param      initialCapacity   the initial capacity of the hash table
      * @throws     IllegalArgumentException if the initial capacity is less
      *             than zero
@@ -372,4 +380,21 @@ public Object[] toArray() {
     public <T> T[] toArray(T[] a) {
         return map.keysToArray(map.prepareArray(a));
     }
+
+    /**
+     * Creates a new, empty HashSet suitable for the expected number of elements.
+     * The returned set uses the default load factor of 0.75, and its initial capacity is
+     * generally large enough so that the expected number of elements can be added
+     * without resizing the set.
+     *
+     * @param numElements    the expected number of elements
+     * @param <T>         the type of elements maintained by the new set
+     * @return the newly created set
+     * @throws IllegalArgumentException if numElements is negative
+     * @since 19
+     */
+    public static <T> HashSet<T> newHashSet(int numElements) {
+        return new HashSet<>(HashMap.calculateHashMapCapacity(numElements));
+    }
+
 }