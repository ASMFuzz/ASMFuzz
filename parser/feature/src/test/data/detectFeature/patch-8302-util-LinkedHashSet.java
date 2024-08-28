@@ -126,6 +126,10 @@ public class LinkedHashSet<E>
      * Constructs a new, empty linked hash set with the specified initial
      * capacity and load factor.
      *
+     * @apiNote
+     * To create a {@code LinkedHashSet} with an initial capacity that accommodates
+     * an expected number of elements, use {@link #newLinkedHashSet(int) newLinkedHashSet}.
+     *
      * @param      initialCapacity the initial capacity of the linked hash set
      * @param      loadFactor      the load factor of the linked hash set
      * @throws     IllegalArgumentException  if the initial capacity is less
@@ -139,6 +143,10 @@ public LinkedHashSet(int initialCapacity, float loadFactor) {
      * Constructs a new, empty linked hash set with the specified initial
      * capacity and the default load factor (0.75).
      *
+     * @apiNote
+     * To create a {@code LinkedHashSet} with an initial capacity that accommodates
+     * an expected number of elements, use {@link #newLinkedHashSet(int) newLinkedHashSet}.
+     *
      * @param   initialCapacity   the initial capacity of the LinkedHashSet
      * @throws  IllegalArgumentException if the initial capacity is less
      *              than zero
@@ -166,7 +174,7 @@ public LinkedHashSet() {
      * @throws NullPointerException if the specified collection is null
      */
     public LinkedHashSet(Collection<? extends E> c) {
-        super(Math.max(2*c.size(), 11), .75f, true);
+        super(HashMap.calculateHashMapCapacity(Math.max(c.size(), 12)), .75f, true);
         addAll(c);
     }
 
@@ -193,4 +201,21 @@ public LinkedHashSet(Collection<? extends E> c) {
     public Spliterator<E> spliterator() {
         return Spliterators.spliterator(this, Spliterator.DISTINCT | Spliterator.ORDERED);
     }
+
+    /**
+     * Creates a new, empty LinkedHashSet suitable for the expected number of elements.
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
+    public static <T> LinkedHashSet<T> newLinkedHashSet(int numElements) {
+        return new LinkedHashSet<>(HashMap.calculateHashMapCapacity(numElements));
+    }
+
 }