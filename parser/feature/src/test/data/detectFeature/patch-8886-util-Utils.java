@@ -2230,7 +2230,7 @@ public List<? extends DocTree> getBlockTags(Element element, Predicate<DocTree>
                 .toList();
     }
 
-    public <T extends DocTree> List<? extends T> getBlockTags(Element element, Predicate<DocTree> filter, Class<T> tClass) {
+    public <T extends DocTree> List<T> getBlockTags(Element element, Predicate<DocTree> filter, Class<T> tClass) {
         return getBlockTags(element).stream()
                 .filter(t -> t.getKind() != ERRONEOUS)
                 .filter(filter)
@@ -2477,21 +2477,21 @@ public List<? extends SerialFieldTree> getSerialFieldTrees(VariableElement field
         return getBlockTags(field, DocTree.Kind.SERIAL_FIELD, SerialFieldTree.class);
     }
 
-    public List<? extends ThrowsTree> getThrowsTrees(Element element) {
+    public List<ThrowsTree> getThrowsTrees(Element element) {
         return getBlockTags(element,
                 t -> switch (t.getKind()) { case EXCEPTION, THROWS -> true; default -> false; },
                 ThrowsTree.class);
     }
 
-    public List<? extends ParamTree> getTypeParamTrees(Element element) {
+    public List<ParamTree> getTypeParamTrees(Element element) {
         return getParamTrees(element, true);
     }
 
-    public List<? extends ParamTree> getParamTrees(Element element) {
+    public List<ParamTree> getParamTrees(Element element) {
         return getParamTrees(element, false);
     }
 
-    private  List<? extends ParamTree> getParamTrees(Element element, boolean isTypeParameters) {
+    private  List<ParamTree> getParamTrees(Element element, boolean isTypeParameters) {
         return getBlockTags(element,
                 t -> t.getKind() == PARAM && ((ParamTree) t).isTypeParameter() == isTypeParameters,
                 ParamTree.class);