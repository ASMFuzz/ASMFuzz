@@ -49,6 +49,10 @@
  * designed for use only in the rare cases wherein reference-equality
  * semantics are required.</b>
  *
+ * <p>The view collections of this map also have reference-equality semantics
+ * for their elements. See the {@link keySet() keySet}, {@link values() values},
+ * and {@link entrySet() entrySet} methods for further information.
+ *
  * <p>A typical use of this class is <i>topology-preserving object graph
  * transformations</i>, such as serialization or deep-copying.  To perform such
  * a transformation, a program must maintain a "node table" that keeps track
@@ -346,7 +350,8 @@ public V get(Object key) {
 
     /**
      * Tests whether the specified object reference is a key in this identity
-     * hash map.
+     * hash map. Returns {@code true} if and only if this map contains a mapping
+     * with key {@code k} such that {@code (key == k)}.
      *
      * @param   key   possible key
      * @return  {@code true} if the specified object reference is a key
@@ -370,7 +375,8 @@ public boolean containsKey(Object key) {
 
     /**
      * Tests whether the specified object reference is a value in this identity
-     * hash map.
+     * hash map. Returns {@code true} if and only if this map contains a mapping
+     * with value {@code v} such that {@code (value == v)}.
      *
      * @param value value whose presence in this map is to be tested
      * @return {@code true} if this map maps one or more keys to the
@@ -411,8 +417,9 @@ private boolean containsMapping(Object key, Object value) {
 
     /**
      * Associates the specified value with the specified key in this identity
-     * hash map.  If the map previously contained a mapping for the key, the
-     * old value is replaced.
+     * hash map. If this map already {@link containsKey(Object) contains}
+     * a mapping for the key, the old value is replaced, otherwise, a new mapping
+     * is inserted into this map.
      *
      * @param key the key with which the specified value is to be associated
      * @param value the value to be associated with the specified key
@@ -497,8 +504,10 @@ private boolean resize(int newCapacity) {
 
     /**
      * Copies all of the mappings from the specified map to this map.
-     * These mappings will replace any mappings that this map had for
-     * any of the keys currently in the specified map.
+     * For each mapping in the specified map, if this map already
+     * {@link containsKey(Object) contains} a mapping for the key,
+     * its value is replaced with the value from the specified map;
+     * otherwise, a new mapping is inserted into this map.
      *
      * @param m mappings to be stored in this map
      * @throws NullPointerException if the specified map is null
@@ -516,6 +525,8 @@ public void putAll(Map<? extends K, ? extends V> m) {
 
     /**
      * Removes the mapping for this key from this map if present.
+     * The mapping is removed if and only if the mapping has a key
+     * {@code k} such that (key == k).
      *
      * @param key key whose mapping is to be removed from the map
      * @return the previous value associated with {@code key}, or
@@ -632,7 +643,9 @@ public void clear() {
      * {@code true} if the given object is also a map and the two maps
      * represent identical object-reference mappings.  More formally, this
      * map is equal to another map {@code m} if and only if
-     * {@code this.entrySet().equals(m.entrySet())}.
+     * {@code this.entrySet().equals(m.entrySet())}. See the
+     * {@link entrySet() entrySet} method for the specification of equality
+     * of this map's entries.
      *
      * <p><b>Owing to the reference-equality-based semantics of this map it is
      * possible that the symmetry and transitivity requirements of the
@@ -667,8 +680,11 @@ public boolean equals(Object o) {
 
     /**
      * Returns the hash code value for this map.  The hash code of a map is
-     * defined to be the sum of the hash codes of each entry in the map's
-     * {@code entrySet()} view.  This ensures that {@code m1.equals(m2)}
+     * defined to be the sum of the hash codes of each entry of this map.
+     * See the {@link entrySet() entrySet} method for a specification of the
+     * hash code of this map's entries.
+     *
+     * <p>This specification ensures that {@code m1.equals(m2)}
      * implies that {@code m1.hashCode()==m2.hashCode()} for any two
      * {@code IdentityHashMap} instances {@code m1} and {@code m2}, as
      * required by the general contract of {@link Object#hashCode}.
@@ -1162,7 +1178,9 @@ public Spliterator<V> spliterator() {
      * e.getValue()==o.getValue()}.  To accommodate these equals
      * semantics, the {@code hashCode} method returns
      * {@code System.identityHashCode(e.getKey()) ^
-     * System.identityHashCode(e.getValue())}.
+     * System.identityHashCode(e.getValue())}. (While the keys and values
+     * are compared using reference equality, the {@code Map.Entry}
+     * objects themselves are not.)
      *
      * <p><b>Owing to the reference-equality-based semantics of the
      * {@code Map.Entry} instances in the set returned by this method,
@@ -1382,6 +1400,50 @@ public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
         }
     }
 
+    /**
+     * {@inheritDoc}
+     *
+     * <p>More formally, if this map contains a mapping from a key
+     * {@code k} to a value {@code v} such that {@code (key == k)}
+     * and {@code (value == v)}, then this method removes the mapping
+     * for this key and returns {@code true}; otherwise it returns
+     * {@code false}.
+     */
+    @Override
+    public boolean remove(Object key, Object value) {
+        return removeMapping(key, value);
+    }
+
+    /**
+     * {@inheritDoc}
+     *
+     * <p>More formally, if this map contains a mapping from a key
+     * {@code k} to a value {@code v} such that {@code (key == k)}
+     * and {@code (oldValue == v)}, then this method associates
+     * {@code k} with {@code newValue} and returns {@code true};
+     * otherwise it returns {@code false}.
+     */
+    @Override
+    public boolean replace(K key, V oldValue, V newValue) {
+        Object k = maskNull(key);
+        Object[] tab = table;
+        int len = tab.length;
+        int i = hash(k, len);
+
+        while (true) {
+            Object item = tab[i];
+            if (item == k) {
+                if (tab[i + 1] != oldValue)
+                    return false;
+                tab[i + 1] = newValue;
+                return true;
+            }
+            if (item == null)
+                return false;
+            i = nextKeyIndex(i, len);
+        }
+    }
+
     /**
      * Similar form as array-based Spliterators, but skips blank elements,
      * and guestimates size as decreasing by half per split.