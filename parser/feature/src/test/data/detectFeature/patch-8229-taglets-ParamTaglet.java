@@ -68,7 +68,7 @@ public ParamTaglet() {
      *               check.
      * @return a name-rank number map.
      */
-    private static Map<String, String> getRankMap(Utils utils, List<? extends Element> params){
+    private static Map<String, String> getRankMap(Utils utils, List<? extends Element> params) {
         if (params == null) {
             return null;
         }
@@ -88,14 +88,14 @@ private static Map<String, String> getRankMap(Utils utils, List<? extends Elemen
     public void inherit(DocFinder.Input input, DocFinder.Output output) {
         Utils utils = input.utils;
         if (input.tagId == null) {
-            input.isTypeVariableParamTag = ((ParamTree)input.docTreeInfo.docTree).isTypeParameter();
-            ExecutableElement ee = (ExecutableElement)input.docTreeInfo.element;
+            input.isTypeVariableParamTag = ((ParamTree) input.docTreeInfo.docTree()).isTypeParameter();
+            ExecutableElement ee = (ExecutableElement) input.docTreeInfo.element();
             CommentHelper ch = utils.getCommentHelper(ee);
             List<? extends Element> parameters = input.isTypeVariableParamTag
                     ? ee.getTypeParameters()
                     : ee.getParameters();
-            String target = ch.getParameterName(input.docTreeInfo.docTree);
-            for (int i = 0 ; i < parameters.size(); i++) {
+            String target = ch.getParameterName(input.docTreeInfo.docTree());
+            for (int i = 0; i < parameters.size(); i++) {
                 Element e = parameters.get(i);
                 String pname = input.isTypeVariableParamTag
                         ? utils.getTypeName(e.asType(), false)
@@ -106,7 +106,7 @@ public void inherit(DocFinder.Input input, DocFinder.Output output) {
                 }
             }
         }
-        ExecutableElement md = (ExecutableElement)input.element;
+        ExecutableElement md = (ExecutableElement) input.element;
         CommentHelper ch = utils.getCommentHelper(md);
         List<? extends DocTree> tags = input.isTypeVariableParamTag
                 ? utils.getTypeParamTrees(md)
@@ -132,14 +132,14 @@ public Content getAllBlockTagOutput(Element holder, TagletWriter writer) {
         if (utils.isExecutableElement(holder)) {
             ExecutableElement member = (ExecutableElement) holder;
             Content output = getTagletOutput(ParamKind.TYPE_PARAMETER, member, writer,
-                member.getTypeParameters(), utils.getTypeParamTrees(member));
+                    member.getTypeParameters(), utils.getTypeParamTrees(member));
             output.add(getTagletOutput(ParamKind.PARAMETER, member, writer,
-                member.getParameters(), utils.getParamTrees(member)));
+                    member.getParameters(), utils.getParamTrees(member)));
             return output;
         } else {
             TypeElement typeElement = (TypeElement) holder;
             Content output = getTagletOutput(ParamKind.TYPE_PARAMETER, typeElement, writer,
-                typeElement.getTypeParameters(), utils.getTypeParamTrees(typeElement));
+                    typeElement.getTypeParameters(), utils.getTypeParamTrees(typeElement));
             output.add(getTagletOutput(ParamKind.RECORD_COMPONENT, typeElement, writer,
                     typeElement.getRecordComponents(), utils.getParamTrees(typeElement)));
             return output;
@@ -157,8 +157,11 @@ public Content getAllBlockTagOutput(Element holder, TagletWriter writer) {
      *
      * @return the content representation of these {@code @param DocTree}s.
      */
-    private Content getTagletOutput(ParamKind kind, Element holder,
-            TagletWriter writer, List<? extends Element> formalParameters, List<? extends ParamTree> paramTags) {
+    private Content getTagletOutput(ParamKind kind,
+                                    Element holder,
+                                    TagletWriter writer,
+                                    List<? extends Element> formalParameters,
+                                    List<? extends ParamTree> paramTags) {
         Content result = writer.getOutputInstance();
         result.add(processParamTags(holder, kind, paramTags, formalParameters, writer));
         return result;
@@ -167,15 +170,18 @@ private Content getTagletOutput(ParamKind kind, Element holder,
     /**
      * Try to get the inherited taglet documentation for a specific parameter.
      */
-    private Content getInheritedTagletOutput(ParamKind kind, Element holder,
-                                             TagletWriter writer, Element param, int rank,
+    private Content getInheritedTagletOutput(ParamKind kind,
+                                             Element holder,
+                                             TagletWriter writer,
+                                             Element param,
+                                             int rank,
                                              boolean isFirst) {
         Utils utils = writer.configuration().utils;
         Content result = writer.getOutputInstance();
         Input input = new DocFinder.Input(writer.configuration().utils, holder, this,
                 Integer.toString(rank), kind == ParamKind.TYPE_PARAMETER);
         DocFinder.Output inheritedDoc = DocFinder.search(writer.configuration(), input);
-        if (inheritedDoc.inlineTags != null && !inheritedDoc.inlineTags.isEmpty()) {
+        if (!inheritedDoc.inlineTags.isEmpty()) {
             String lname = kind != ParamKind.TYPE_PARAMETER
                     ? utils.getSimpleName(param)
                     : utils.getTypeName(param.asType(), false);
@@ -197,20 +203,23 @@ private Content getInheritedTagletOutput(ParamKind kind, Element holder,
      * @param writer the TagletWriter that will write this tag.
      * @return the Content representation of this {@code @param DocTree}.
      */
-    private Content processParamTags(Element e, ParamKind kind, List<? extends ParamTree> paramTags,
-                                     List<? extends Element> formalParameters, TagletWriter writer) {
+    private Content processParamTags(Element e,
+                                     ParamKind kind,
+                                     List<? extends ParamTree> paramTags,
+                                     List<? extends Element> formalParameters,
+                                     TagletWriter writer) {
         Map<String, ParamTree> documented = new HashMap<>();
         Messages messages = writer.configuration().getMessages();
         CommentHelper ch = writer.configuration().utils.getCommentHelper(e);
         if (!paramTags.isEmpty()) {
-            Map<String,String> rankMap = getRankMap(writer.configuration().utils, formalParameters);
+            Map<String, String> rankMap = getRankMap(writer.configuration().utils, formalParameters);
             for (ParamTree dt : paramTags) {
                 String name = ch.getParameterName(dt);
                 String paramName = kind == ParamKind.TYPE_PARAMETER ? "<" + name + ">" : name;
                 if (!rankMap.containsKey(name)) {
                     String key = switch (kind) {
-                        case PARAMETER        -> "doclet.Parameters_warn";
-                        case TYPE_PARAMETER   -> "doclet.TypeParameters_warn";
+                        case PARAMETER -> "doclet.Parameters_warn";
+                        case TYPE_PARAMETER -> "doclet.TypeParameters_warn";
                         case RECORD_COMPONENT -> "doclet.RecordComponents_warn";
                     };
                     messages.warning(ch.getDocTreePath(dt), key, paramName);
@@ -269,9 +278,12 @@ private Content processParamTags(Element e, ParamKind kind, List<? extends Param
      * @param isFirstParam    true if this is the first param tag being printed.
      *
      */
-    private Content processParamTag(Element e, ParamKind kind,
-            TagletWriter writer, ParamTree paramTag, String name,
-            boolean isFirstParam) {
+    private Content processParamTag(Element e,
+                                    ParamKind kind,
+                                    TagletWriter writer,
+                                    ParamTree paramTag,
+                                    String name,
+                                    boolean isFirstParam) {
         Content result = writer.getOutputInstance();
         if (isFirstParam) {
             result.add(writer.getParamHeader(kind));