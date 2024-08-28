@@ -61,63 +61,44 @@ public ParamTaglet() {
         super(DocTree.Kind.PARAM, false, EnumSet.of(Location.TYPE, Location.CONSTRUCTOR, Location.METHOD));
     }
 
-    /**
-     * Given a list of parameters, return a name/rank number map.
-     * If the list is null, then null is returned.
-     * @param params The list of parameters (from type or executable member) to
-     *               check.
-     * @return a name-rank number map.
-     */
-    private static Map<String, String> getRankMap(Utils utils, List<? extends Element> params) {
-        if (params == null) {
-            return null;
-        }
-        HashMap<String, String> result = new HashMap<>();
-        int rank = 0;
-        for (Element e : params) {
-            String name = utils.isTypeParameterElement(e)
-                    ? utils.getTypeName(e.asType(), false)
-                    : utils.getSimpleName(e);
-            result.put(name, String.valueOf(rank));
-            rank++;
-        }
-        return result;
-    }
-
     @Override
     public void inherit(DocFinder.Input input, DocFinder.Output output) {
         Utils utils = input.utils;
         if (input.tagId == null) {
-            input.isTypeVariableParamTag = ((ParamTree) input.docTreeInfo.docTree()).isTypeParameter();
+            var tag = (ParamTree) input.docTreeInfo.docTree();
+            input.isTypeVariableParamTag = tag.isTypeParameter();
             ExecutableElement ee = (ExecutableElement) input.docTreeInfo.element();
             CommentHelper ch = utils.getCommentHelper(ee);
             List<? extends Element> parameters = input.isTypeVariableParamTag
                     ? ee.getTypeParameters()
                     : ee.getParameters();
-            String target = ch.getParameterName(input.docTreeInfo.docTree());
+            String target = ch.getParameterName(tag);
             for (int i = 0; i < parameters.size(); i++) {
                 Element e = parameters.get(i);
-                String pname = input.isTypeVariableParamTag
+                String candidate = input.isTypeVariableParamTag
                         ? utils.getTypeName(e.asType(), false)
                         : utils.getSimpleName(e);
-                if (pname.contentEquals(target)) {
-                    input.tagId = String.valueOf(i);
+                if (candidate.equals(target)) {
+                    input.tagId = Integer.toString(i);
                     break;
                 }
             }
         }
-        ExecutableElement md = (ExecutableElement) input.element;
-        CommentHelper ch = utils.getCommentHelper(md);
-        List<? extends DocTree> tags = input.isTypeVariableParamTag
-                ? utils.getTypeParamTrees(md)
-                : utils.getParamTrees(md);
+        if (input.tagId == null)
+            return;
+        int position = Integer.parseInt(input.tagId);
+        ExecutableElement ee = (ExecutableElement) input.element;
+        CommentHelper ch = utils.getCommentHelper(ee);
+        List<ParamTree> tags = input.isTypeVariableParamTag
+                ? utils.getTypeParamTrees(ee)
+                : utils.getParamTrees(ee);
         List<? extends Element> parameters = input.isTypeVariableParamTag
-                ? md.getTypeParameters()
-                : md.getParameters();
-        Map<String, String> rankMap = getRankMap(utils, parameters);
-        for (DocTree tag : tags) {
+                ? ee.getTypeParameters()
+                : ee.getParameters();
+        Map<String, Integer> positionOfName = mapNameToPosition(utils, parameters);
+        for (ParamTree tag : tags) {
             String paramName = ch.getParameterName(tag);
-            if (rankMap.containsKey(paramName) && rankMap.get(paramName).equals((input.tagId))) {
+            if (positionOfName.containsKey(paramName) && positionOfName.get(paramName).equals(position)) {
                 output.holder = input.element;
                 output.holderTag = tag;
                 output.inlineTags = ch.getBody(tag);
@@ -126,168 +107,163 @@ public void inherit(DocFinder.Input input, DocFinder.Output output) {
         }
     }
 
+    /**
+     * Given a list of parameter elements, returns a name-position map.
+     * @param params the list of parameters from a type or an executable member
+     * @return a name-position map
+     */
+    private static Map<String, Integer> mapNameToPosition(Utils utils, List<? extends Element> params) {
+        Map<String, Integer> result = new HashMap<>();
+        int position = 0;
+        for (Element e : params) {
+            String name = utils.isTypeParameterElement(e)
+                    ? utils.getTypeName(e.asType(), false)
+                    : utils.getSimpleName(e);
+            result.put(name, position);
+            position++;
+        }
+        return result;
+    }
+
     @Override
     public Content getAllBlockTagOutput(Element holder, TagletWriter writer) {
         Utils utils = writer.configuration().utils;
         if (utils.isExecutableElement(holder)) {
             ExecutableElement member = (ExecutableElement) holder;
-            Content output = getTagletOutput(ParamKind.TYPE_PARAMETER, member, writer,
-                    member.getTypeParameters(), utils.getTypeParamTrees(member));
-            output.add(getTagletOutput(ParamKind.PARAMETER, member, writer,
-                    member.getParameters(), utils.getParamTrees(member)));
+            Content output = convertParams(member, ParamKind.TYPE_PARAMETER,
+                    utils.getTypeParamTrees(member), member.getTypeParameters(), writer);
+            output.add(convertParams(member, ParamKind.PARAMETER,
+                    utils.getParamTrees(member), member.getParameters(), writer));
             return output;
         } else {
             TypeElement typeElement = (TypeElement) holder;
-            Content output = getTagletOutput(ParamKind.TYPE_PARAMETER, typeElement, writer,
-                    typeElement.getTypeParameters(), utils.getTypeParamTrees(typeElement));
-            output.add(getTagletOutput(ParamKind.RECORD_COMPONENT, typeElement, writer,
-                    typeElement.getRecordComponents(), utils.getParamTrees(typeElement)));
+            Content output = convertParams(typeElement, ParamKind.TYPE_PARAMETER,
+                    utils.getTypeParamTrees(typeElement), typeElement.getTypeParameters(), writer);
+            output.add(convertParams(typeElement, ParamKind.RECORD_COMPONENT,
+                    utils.getParamTrees(typeElement), typeElement.getRecordComponents(), writer));
             return output;
         }
     }
 
     /**
-     * Given an array of {@code @param DocTree}s, return its string representation.
-     * Try to inherit the param tags that are missing.
+     * Returns a {@code Content} representation of a list of {@code ParamTree}
+     * of the specified kind.
      *
-     * @param holder            the element that holds the param tags.
-     * @param writer            the TagletWriter that will write this tag.
-     * @param formalParameters  The array of parameters (from type or executable
-     *                          member) to check.
+     * <p> This method correlates a {@code ParamTree} with a parameter
+     * {@code Element} by name. Once it's done, a particular {@code ParamTree}
+     * is addressed by the position (index) of the correlated {@code Element}
+     * in the list of parameter elements. This is needed for documentation
+     * inheritance because the corresponding parameters in the inheritance
+     * hierarchy may be named differently.
      *
-     * @return the content representation of these {@code @param DocTree}s.
-     */
-    private Content getTagletOutput(ParamKind kind,
-                                    Element holder,
-                                    TagletWriter writer,
-                                    List<? extends Element> formalParameters,
-                                    List<? extends ParamTree> paramTags) {
-        Content result = writer.getOutputInstance();
-        result.add(processParamTags(holder, kind, paramTags, formalParameters, writer));
-        return result;
-    }
-
-    /**
-     * Try to get the inherited taglet documentation for a specific parameter.
-     */
-    private Content getInheritedTagletOutput(ParamKind kind,
-                                             Element holder,
-                                             TagletWriter writer,
-                                             Element param,
-                                             int rank,
-                                             boolean isFirst) {
-        Utils utils = writer.configuration().utils;
-        Content result = writer.getOutputInstance();
-        Input input = new DocFinder.Input(writer.configuration().utils, holder, this,
-                Integer.toString(rank), kind == ParamKind.TYPE_PARAMETER);
-        DocFinder.Output inheritedDoc = DocFinder.search(writer.configuration(), input);
-        if (!inheritedDoc.inlineTags.isEmpty()) {
-            String lname = kind != ParamKind.TYPE_PARAMETER
-                    ? utils.getSimpleName(param)
-                    : utils.getTypeName(param.asType(), false);
-            Content content = processParamTag(inheritedDoc.holder, kind, writer,
-                    (ParamTree) inheritedDoc.holderTag,
-                    lname, isFirst);
-            result.add(content);
-        }
-        return result;
-    }
-
-    /**
-     * Given an array of {@code @param DocTree}s representing this
-     * tag, return its string representation.  Print a warning for param
-     * tags that do not map to parameters.  Print a warning for param
-     * tags that are duplicated.
+     * <p> This method warns about {@code @param} tags that do not map to
+     * parameter elements and param tags that are duplicated. </p>
      *
-     * @param paramTags the array of {@code @param DocTree} to convert.
-     * @param writer the TagletWriter that will write this tag.
-     * @return the Content representation of this {@code @param DocTree}.
+     * @param kind the kind of <em>all</em> parameters in the lists
      */
-    private Content processParamTags(Element e,
-                                     ParamKind kind,
-                                     List<? extends ParamTree> paramTags,
-                                     List<? extends Element> formalParameters,
-                                     TagletWriter writer) {
-        Map<String, ParamTree> documented = new HashMap<>();
+    private Content convertParams(Element e,
+                                  ParamKind kind,
+                                  List<ParamTree> tags,
+                                  List<? extends Element> parameters,
+                                  TagletWriter writer) {
+        Map<Integer, ParamTree> tagOfPosition = new HashMap<>();
         Messages messages = writer.configuration().getMessages();
         CommentHelper ch = writer.configuration().utils.getCommentHelper(e);
-        if (!paramTags.isEmpty()) {
-            Map<String, String> rankMap = getRankMap(writer.configuration().utils, formalParameters);
-            for (ParamTree dt : paramTags) {
-                String name = ch.getParameterName(dt);
+        if (!tags.isEmpty()) {
+            Map<String, Integer> positionOfName = mapNameToPosition(writer.configuration().utils, parameters);
+            for (ParamTree tag : tags) {
+                String name = ch.getParameterName(tag);
                 String paramName = kind == ParamKind.TYPE_PARAMETER ? "<" + name + ">" : name;
-                if (!rankMap.containsKey(name)) {
+                if (!positionOfName.containsKey(name)) {
                     String key = switch (kind) {
                         case PARAMETER -> "doclet.Parameters_warn";
                         case TYPE_PARAMETER -> "doclet.TypeParameters_warn";
                         case RECORD_COMPONENT -> "doclet.RecordComponents_warn";
                     };
                     if (!writer.configuration().isDocLintReferenceGroupEnabled()) {
-                        messages.warning(ch.getDocTreePath(dt), key, paramName);
+                        messages.warning(ch.getDocTreePath(tag), key, paramName);
                     }
                 }
-                String rank = rankMap.get(name);
-                if (rank != null) {
-                    if (documented.containsKey(rank)) {
+                Integer position = positionOfName.get(name);
+                if (position != null) {
+                    if (tagOfPosition.containsKey(position)) {
                         String key = switch (kind) {
                             case PARAMETER -> "doclet.Parameters_dup_warn";
                             case TYPE_PARAMETER -> "doclet.TypeParameters_dup_warn";
                             case RECORD_COMPONENT -> "doclet.RecordComponents_dup_warn";
                         };
                         if (!writer.configuration().isDocLintReferenceGroupEnabled()) {
-                            messages.warning(ch.getDocTreePath(dt), key, paramName);
+                            messages.warning(ch.getDocTreePath(tag), key, paramName);
                         }
                     } else {
-                        documented.put(rank, dt);
+                        tagOfPosition.put(position, tag);
                     }
                 }
             }
         }
-        // Document declared parameters for which taglet documentation is available
+        // Document declared parameters for which tag documentation is available
         // (either directly or inherited) in order of their declaration.
         Content result = writer.getOutputInstance();
-        for (int i = 0; i < formalParameters.size(); i++) {
-            ParamTree dt = documented.get(String.valueOf(i));
-            if (dt != null) {
-                result.add(processParamTag(e, kind, writer, dt,
-                        ch.getParameterName(dt), result.isEmpty()));
+        for (int i = 0; i < parameters.size(); i++) {
+            ParamTree tag = tagOfPosition.get(i);
+            if (tag != null) {
+                result.add(convertParam(e, kind, writer, tag,
+                        ch.getParameterName(tag), result.isEmpty()));
             } else if (writer.configuration().utils.isMethod(e)) {
                 result.add(getInheritedTagletOutput(kind, e, writer,
-                        formalParameters.get(i), i, result.isEmpty()));
+                        parameters.get(i), i, result.isEmpty()));
             }
         }
-        if (paramTags.size() > documented.size()) {
-            // Generate documentation for remaining taglets that do not match a declared parameter.
+        if (tags.size() > tagOfPosition.size()) {
+            // Generate documentation for remaining tags that do not match a declared parameter.
             // These are erroneous but we generate them anyway.
-            for (ParamTree dt : paramTags) {
-                if (!documented.containsValue(dt)) {
-                    result.add(processParamTag(e, kind, writer, dt,
-                            ch.getParameterName(dt), result.isEmpty()));
+            for (ParamTree tag : tags) {
+                if (!tagOfPosition.containsValue(tag)) {
+                    result.add(convertParam(e, kind, writer, tag,
+                            ch.getParameterName(tag), result.isEmpty()));
                 }
             }
         }
         return result;
     }
 
     /**
-     * Convert the individual ParamTag into Content.
-     *
-     * @param e               the owner element
-     * @param kind            the kind of param tag
-     * @param writer          the taglet writer for output writing.
-     * @param paramTag        the tag whose inline tags will be printed.
-     * @param name            the name of the parameter.  We can't rely on
-     *                        the name in the param tag because we might be
-     *                        inheriting documentation.
-     * @param isFirstParam    true if this is the first param tag being printed.
-     *
+     * Tries to inherit documentation for a specific parameter (element).
+     * If unsuccessful, the returned content is empty.
+     */
+    private Content getInheritedTagletOutput(ParamKind kind,
+                                             Element holder,
+                                             TagletWriter writer,
+                                             Element param,
+                                             int position,
+                                             boolean isFirst) {
+        Utils utils = writer.configuration().utils;
+        Content result = writer.getOutputInstance();
+        Input input = new DocFinder.Input(writer.configuration().utils, holder, this,
+                Integer.toString(position), kind == ParamKind.TYPE_PARAMETER);
+        DocFinder.Output inheritedDoc = DocFinder.search(writer.configuration(), input);
+        if (!inheritedDoc.inlineTags.isEmpty()) {
+            String name = kind != ParamKind.TYPE_PARAMETER
+                    ? utils.getSimpleName(param)
+                    : utils.getTypeName(param.asType(), false);
+            Content content = convertParam(inheritedDoc.holder, kind, writer,
+                    (ParamTree) inheritedDoc.holderTag,
+                    name, isFirst);
+            result.add(content);
+        }
+        return result;
+    }
+
+    /**
+     * Converts an individual {@code ParamTree} to {@code Content}, which is
+     * prepended with the header if the parameter is first in the list.
      */
-    private Content processParamTag(Element e,
-                                    ParamKind kind,
-                                    TagletWriter writer,
-                                    ParamTree paramTag,
-                                    String name,
-                                    boolean isFirstParam) {
+    private Content convertParam(Element e,
+                                 ParamKind kind,
+                                 TagletWriter writer,
+                                 ParamTree paramTag,
+                                 String name,
+                                 boolean isFirstParam) {
         Content result = writer.getOutputInstance();
         if (isFirstParam) {
             result.add(writer.getParamHeader(kind));