@@ -230,7 +230,7 @@ public void afterTypes(Runnable a) {
      *
      * @param annotations the list of JCAnnotations to attribute and enter
      * @param localEnv    the enclosing env
-     * @param s           ths Symbol on which to enter the annotations
+     * @param s           the Symbol on which to enter the annotations
      * @param deferPos    report errors here
      */
     public void annotateLater(List<JCAnnotation> annotations, Env<AttrContext> localEnv,