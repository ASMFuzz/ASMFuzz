@@ -117,11 +117,11 @@ protected SimpleTypeVisitor6(R defaultValue){
      * @implSpec The implementation in this class just returns {@link
      * #DEFAULT_VALUE}; subclasses will commonly override this method.
      *
-     * @param e the type to process
+     * @param t the type to process
      * @param p a visitor-specified parameter
      * @return {@code DEFAULT_VALUE} unless overridden
      */
-    protected R defaultAction(TypeMirror e, P p) {
+    protected R defaultAction(TypeMirror t, P p) {
         return DEFAULT_VALUE;
     }
 