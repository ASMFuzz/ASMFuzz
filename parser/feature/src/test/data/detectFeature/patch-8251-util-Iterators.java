@@ -39,20 +39,20 @@
  */
 public class Iterators {
 
-    public static <I, O> Iterator<O> createCompoundIterator(Iterable<I> inputs, Function<I, Iterator<O>> convertor) {
-        return new CompoundIterator<>(inputs, convertor);
+    public static <I, O> Iterator<O> createCompoundIterator(Iterable<I> inputs, Function<I, Iterator<O>> converter) {
+        return new CompoundIterator<>(inputs, converter);
     }
 
     private static class CompoundIterator<I, O> implements Iterator<O> {
 
         private final Iterator<I> inputs;
-        private final Function<I, Iterator<O>> convertor;
+        private final Function<I, Iterator<O>> converter;
         @SuppressWarnings("unchecked")
         private Iterator<O> currentIterator = EMPTY;
 
-        public CompoundIterator(Iterable<I> inputs, Function<I, Iterator<O>> convertor) {
+        public CompoundIterator(Iterable<I> inputs, Function<I, Iterator<O>> converter) {
             this.inputs = inputs.iterator();
-            this.convertor = convertor;
+            this.converter = converter;
         }
 
         public boolean hasNext() {
@@ -75,7 +75,7 @@ public void remove() {
 
         private void update() {
             while (inputs.hasNext()) {
-                currentIterator = convertor.apply(inputs.next());
+                currentIterator = converter.apply(inputs.next());
                 if (currentIterator.hasNext()) return;
             }
             currentIterator = null;