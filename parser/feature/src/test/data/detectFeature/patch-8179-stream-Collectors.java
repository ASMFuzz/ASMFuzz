@@ -194,56 +194,19 @@ private static <I, R> Function<I, R> castingIdentity() {
      * @param <T> the type of elements to be collected
      * @param <R> the type of the result
      */
-    static class CollectorImpl<T, A, R> implements Collector<T, A, R> {
-        private final Supplier<A> supplier;
-        private final BiConsumer<A, T> accumulator;
-        private final BinaryOperator<A> combiner;
-        private final Function<A, R> finisher;
-        private final Set<Characteristics> characteristics;
-
-        CollectorImpl(Supplier<A> supplier,
-                      BiConsumer<A, T> accumulator,
-                      BinaryOperator<A> combiner,
-                      Function<A,R> finisher,
-                      Set<Characteristics> characteristics) {
-            this.supplier = supplier;
-            this.accumulator = accumulator;
-            this.combiner = combiner;
-            this.finisher = finisher;
-            this.characteristics = characteristics;
-        }
+    record CollectorImpl<T, A, R>(Supplier<A> supplier,
+                                  BiConsumer<A, T> accumulator,
+                                  BinaryOperator<A> combiner,
+                                  Function<A, R> finisher,
+                                  Set<Characteristics> characteristics
+            ) implements Collector<T, A, R> {
 
         CollectorImpl(Supplier<A> supplier,
                       BiConsumer<A, T> accumulator,
                       BinaryOperator<A> combiner,
                       Set<Characteristics> characteristics) {
             this(supplier, accumulator, combiner, castingIdentity(), characteristics);
         }
-
-        @Override
-        public BiConsumer<A, T> accumulator() {
-            return accumulator;
-        }
-
-        @Override
-        public Supplier<A> supplier() {
-            return supplier;
-        }
-
-        @Override
-        public BinaryOperator<A> combiner() {
-            return combiner;
-        }
-
-        @Override
-        public Function<A, R> finisher() {
-            return finisher;
-        }
-
-        @Override
-        public Set<Characteristics> characteristics() {
-            return characteristics;
-        }
     }
 
     /**