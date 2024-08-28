@@ -598,6 +598,9 @@ private static boolean eq(Object o1, Object o2) {
      * arrays of {@code SimpleEntry} instances in method
      * {@code Map.entrySet().toArray}.
      *
+     * @param <K> the type of key
+     * @param <V> the type of the value
+     *
      * @since 1.6
      */
     public static class SimpleEntry<K,V>
@@ -741,6 +744,8 @@ public String toString() {
      * {@link Map#entry Map::entry} and {@link Map.Entry#copyOf Map.Entry::copyOf}
      * methods.
      *
+     * @param <K> the type of the keys
+     * @param <V> the type of the value
      * @since 1.6
      */
     public static class SimpleImmutableEntry<K,V>