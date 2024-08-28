@@ -36,6 +36,7 @@
 import java.util.Set;
 
 import javax.lang.model.element.Element;
+import javax.lang.model.element.ElementKind;
 import javax.lang.model.element.ExecutableElement;
 import javax.lang.model.element.TypeElement;
 import javax.lang.model.type.ExecutableType;
@@ -49,11 +50,11 @@
 import jdk.javadoc.internal.doclets.toolkit.Content;
 import jdk.javadoc.internal.doclets.toolkit.util.CommentHelper;
 import jdk.javadoc.internal.doclets.toolkit.util.DocFinder;
-import jdk.javadoc.internal.doclets.toolkit.util.DocFinder.Input;
 import jdk.javadoc.internal.doclets.toolkit.util.Utils;
 
 /**
- * A taglet that represents the {@code @throws} tag.
+ * A taglet that processes {@link ThrowsTree}, which represents
+ * {@code @throws} and {@code @exception} tags.
  */
 public class ThrowsTaglet extends BaseTaglet implements InheritableTaglet {
 
@@ -64,190 +65,190 @@ public ThrowsTaglet() {
     @Override
     public void inherit(DocFinder.Input input, DocFinder.Output output) {
         Utils utils = input.utils;
-        Element exception;
+        Element target;
         CommentHelper ch = utils.getCommentHelper(input.element);
         if (input.tagId == null) {
-            exception = input.docTreeInfo.docTree() instanceof ThrowsTree tt
-                    ? ch.getException(tt) : null;
-            input.tagId = exception == null
-                    ? ch.getExceptionName(input.docTreeInfo.docTree()).getSignature()
-                    : utils.getFullyQualifiedName(exception);
+            var tag = (ThrowsTree) input.docTreeInfo.docTree();
+            target = ch.getException(tag);
+            input.tagId = target == null
+                    ? ch.getExceptionName(tag).getSignature()
+                    : utils.getFullyQualifiedName(target);
         } else {
-            exception = input.utils.findClass(input.element, input.tagId);
+            target = input.utils.findClass(input.element, input.tagId);
         }
 
-        for (ThrowsTree tt : input.utils.getThrowsTrees(input.element)) {
-            Element exc = ch.getException(tt);
-            if (exc != null && (input.tagId.equals(utils.getSimpleName(exc)) ||
-                    (input.tagId.equals(utils.getFullyQualifiedName(exc))))) {
+        // TODO warn if target == null as we cannot guarantee type-match, but at most FQN-match.
+
+        for (ThrowsTree tag : input.utils.getThrowsTrees(input.element)) {
+            Element candidate = ch.getException(tag);
+            if (candidate != null && (input.tagId.equals(utils.getSimpleName(candidate)) ||
+                    (input.tagId.equals(utils.getFullyQualifiedName(candidate))))) {
                 output.holder = input.element;
-                output.holderTag = tt;
+                output.holderTag = tag;
                 output.inlineTags = ch.getBody(output.holderTag);
-                output.tagList.add(tt);
-            } else if (exception != null && exc != null &&
-                    utils.isTypeElement(exc) && utils.isTypeElement(exception) &&
-                    utils.isSubclassOf((TypeElement) exc, (TypeElement) exception)) {
-                output.tagList.add(tt);
+                output.tagList.add(tag);
+            } else if (target != null && candidate != null &&
+                    utils.isTypeElement(candidate) && utils.isTypeElement(target) &&
+                    utils.isSubclassOf((TypeElement) candidate, (TypeElement) target)) {
+                output.tagList.add(tag);
             }
         }
     }
 
-    /**
-     * Add links for exceptions that are declared but not documented.
-     */
-    private Content linkToUndocumentedDeclaredExceptions(List<? extends TypeMirror> declaredExceptionTypes,
-                                                         Set<String> alreadyDocumented,
-                                                         TagletWriter writer) {
-        Utils utils = writer.configuration().utils;
-        Content result = writer.getOutputInstance();
-        //Add links to the exceptions declared but not documented.
-        for (TypeMirror declaredExceptionType : declaredExceptionTypes) {
-            TypeElement te = utils.asTypeElement(declaredExceptionType);
-            if (te != null &&
-                    !alreadyDocumented.contains(declaredExceptionType.toString()) &&
-                    !alreadyDocumented.contains(utils.getFullyQualifiedName(te, false))) {
-                if (alreadyDocumented.isEmpty()) {
-                    result.add(writer.getThrowsHeader());
-                }
-                result.add(writer.throwsTagOutput(declaredExceptionType));
-                alreadyDocumented.add(utils.getSimpleName(te));
-            }
-        }
-        return result;
-    }
-
-    /**
-     * Inherit throws documentation for exceptions that were declared but not
-     * documented.
-     */
-    private Content inheritThrowsDocumentation(Element holder,
-                                               List<? extends TypeMirror> declaredExceptionTypes,
-                                               Set<String> alreadyDocumented,
-                                               Map<String, TypeMirror> typeSubstitutions,
-                                               TagletWriter writer) {
-        Utils utils = writer.configuration().utils;
-        Content result = writer.getOutputInstance();
-        if (utils.isMethod(holder)) {
-            Map<List<? extends ThrowsTree>, ExecutableElement> declaredExceptionTags = new LinkedHashMap<>();
-            for (TypeMirror declaredExceptionType : declaredExceptionTypes) {
-                Input input = new DocFinder.Input(utils, holder, this,
-                        utils.getTypeName(declaredExceptionType, false));
-                DocFinder.Output inheritedDoc = DocFinder.search(writer.configuration(), input);
-                if (inheritedDoc.tagList.isEmpty()) {
-                    String typeName = utils.getTypeName(declaredExceptionType, true);
-                    input = new DocFinder.Input(utils, holder, this, typeName);
-                    inheritedDoc = DocFinder.search(writer.configuration(), input);
-                }
-                if (!inheritedDoc.tagList.isEmpty()) {
-                    if (inheritedDoc.holder == null) {
-                        inheritedDoc.holder = holder;
-                    }
-                    List<? extends ThrowsTree> inheritedTags = inheritedDoc.tagList.stream()
-                            .map(t -> (ThrowsTree) t)
-                            .toList();
-                    declaredExceptionTags.put(inheritedTags, (ExecutableElement) inheritedDoc.holder);
-                }
-            }
-            result.add(throwsTagsOutput(declaredExceptionTags, writer, alreadyDocumented,
-                    typeSubstitutions, false));
-        }
-        return result;
-    }
-
     @Override
     public Content getAllBlockTagOutput(Element holder, TagletWriter writer) {
         Utils utils = writer.configuration().utils;
-        ExecutableElement execHolder = (ExecutableElement) holder;
+        var executable = (ExecutableElement) holder;
         ExecutableType instantiatedType = utils.asInstantiatedMethodType(
-                writer.getCurrentPageElement(), (ExecutableElement) holder);
+                writer.getCurrentPageElement(), executable);
         List<? extends TypeMirror> thrownTypes = instantiatedType.getThrownTypes();
         Map<String, TypeMirror> typeSubstitutions = getSubstitutedThrownTypes(
                 writer.configuration().utils.typeUtils,
-                ((ExecutableElement) holder).getThrownTypes(),
+                executable.getThrownTypes(),
                 thrownTypes);
-        Map<List<? extends ThrowsTree>, ExecutableElement> tagsMap = new LinkedHashMap<>();
-        tagsMap.put(utils.getThrowsTrees(execHolder), execHolder);
+        Map<List<ThrowsTree>, ExecutableElement> tagsMap = new LinkedHashMap<>();
+        tagsMap.put(utils.getThrowsTrees(executable), executable);
         Content result = writer.getOutputInstance();
-        HashSet<String> alreadyDocumented = new HashSet<>();
-        if (!tagsMap.isEmpty()) {
-            result.add(throwsTagsOutput(tagsMap, writer, alreadyDocumented, typeSubstitutions, true));
-        }
-        result.add(inheritThrowsDocumentation(holder,
-                thrownTypes, alreadyDocumented, typeSubstitutions, writer));
+        Set<String> alreadyDocumented = new HashSet<>();
+        result.add(throwsTagsOutput(tagsMap, writer, alreadyDocumented, typeSubstitutions, true));
+        result.add(inheritThrowsDocumentation(executable, thrownTypes, alreadyDocumented, typeSubstitutions, writer));
         result.add(linkToUndocumentedDeclaredExceptions(thrownTypes, alreadyDocumented, writer));
         return result;
     }
 
+    /**
+     * Returns a map of substitutions for a list of thrown types with the original type-variable
+     * name as a key and the instantiated type as a value. If no types need to be substituted
+     * an empty map is returned.
+     * @param declaredThrownTypes the originally declared thrown types.
+     * @param instantiatedThrownTypes the thrown types in the context of the current type.
+     * @return map of declared to instantiated thrown types or an empty map.
+     */
+    private Map<String, TypeMirror> getSubstitutedThrownTypes(Types types,
+                                                              List<? extends TypeMirror> declaredThrownTypes,
+                                                              List<? extends TypeMirror> instantiatedThrownTypes) {
+        if (!declaredThrownTypes.equals(instantiatedThrownTypes)) {
+            Map<String, TypeMirror> map = new HashMap<>();
+            Iterator<? extends TypeMirror> i1 = declaredThrownTypes.iterator();
+            Iterator<? extends TypeMirror> i2 = instantiatedThrownTypes.iterator();
+            while (i1.hasNext() && i2.hasNext()) {
+                TypeMirror t1 = i1.next();
+                TypeMirror t2 = i2.next();
+                if (!types.isSameType(t1, t2))
+                    map.put(t1.toString(), t2);
+            }
+            return map;
+        }
+        return Map.of();
+    }
+
     /**
      * Returns the generated content for a collection of {@code @throws} tags.
      *
-     * @param throwTags         the collection of tags to be converted
+     * @param throwsTags        the collection of tags to be converted
      * @param writer            the taglet-writer used by the doclet
      * @param alreadyDocumented the set of exceptions that have already been documented
      * @param allowDuplicates   {@code true} if we allow duplicate tags to be documented
      * @return the generated content for the tags
      */
-    protected Content throwsTagsOutput(Map<List<? extends ThrowsTree>, ExecutableElement> throwTags,
+    protected Content throwsTagsOutput(Map<List<ThrowsTree>, ExecutableElement> throwsTags,
                                        TagletWriter writer,
                                        Set<String> alreadyDocumented,
                                        Map<String, TypeMirror> typeSubstitutions,
                                        boolean allowDuplicates) {
         Utils utils = writer.configuration().utils;
         Content result = writer.getOutputInstance();
-        if (!throwTags.isEmpty()) {
-            for (Entry<List<? extends ThrowsTree>, ExecutableElement> entry : throwTags.entrySet()) {
-                CommentHelper ch = utils.getCommentHelper(entry.getValue());
-                Element e = entry.getValue();
-                for (ThrowsTree dt : entry.getKey()) {
-                    Element te = ch.getException(dt);
-                    String excName = ch.getExceptionName(dt).toString();
-                    TypeMirror substituteType = typeSubstitutions.get(excName);
-                    if ((!allowDuplicates) &&
-                            (alreadyDocumented.contains(excName) ||
-                                    (te != null && alreadyDocumented.contains(utils.getFullyQualifiedName(te, false)))) ||
-                            (substituteType != null && alreadyDocumented.contains(substituteType.toString()))) {
-                        continue;
-                    }
-                    if (alreadyDocumented.isEmpty()) {
-                        result.add(writer.getThrowsHeader());
-                    }
-                    result.add(writer.throwsTagOutput(e, dt, substituteType));
-                    if (substituteType != null) {
-                        alreadyDocumented.add(substituteType.toString());
-                    } else {
-                        alreadyDocumented.add(te != null
-                                ? utils.getFullyQualifiedName(te, false)
-                                : excName);
-                    }
+        for (Entry<List<ThrowsTree>, ExecutableElement> entry : throwsTags.entrySet()) {
+            Element e = entry.getValue();
+            CommentHelper ch = utils.getCommentHelper(e);
+            for (ThrowsTree tag : entry.getKey()) {
+                Element te = ch.getException(tag);
+                String excName = ch.getExceptionName(tag).toString();
+                TypeMirror substituteType = typeSubstitutions.get(excName);
+                if ((!allowDuplicates) &&
+                        (alreadyDocumented.contains(excName) ||
+                                (te != null && alreadyDocumented.contains(utils.getFullyQualifiedName(te, false)))) ||
+                        (substituteType != null && alreadyDocumented.contains(substituteType.toString()))) {
+                    continue;
+                }
+                if (alreadyDocumented.isEmpty()) {
+                    result.add(writer.getThrowsHeader());
+                }
+                result.add(writer.throwsTagOutput(e, tag, substituteType));
+                if (substituteType != null) {
+                    alreadyDocumented.add(substituteType.toString());
+                } else {
+                    alreadyDocumented.add(te != null
+                            ? utils.getFullyQualifiedName(te, false)
+                            : excName);
                 }
             }
         }
         return result;
     }
 
     /**
-     * Returns a map of substitutions for a list of thrown types with the original type-variable
-     * name as key and the instantiated type as value. If no types need to be substituted
-     * an empty map is returned.
-     * @param declaredThrownTypes the originally declared thrown types.
-     * @param instantiatedThrownTypes the thrown types in the context of the current type.
-     * @return map of declared to instantiated thrown types or an empty map.
+     * Inherit throws documentation for exceptions that were declared but not
+     * documented.
      */
-    private Map<String, TypeMirror> getSubstitutedThrownTypes(Types types,
-                                                              List<? extends TypeMirror> declaredThrownTypes,
-                                                              List<? extends TypeMirror> instantiatedThrownTypes) {
-        if (!instantiatedThrownTypes.equals(declaredThrownTypes)) {
-            Map<String, TypeMirror> map = new HashMap<>();
-            Iterator<? extends TypeMirror> i1 = instantiatedThrownTypes.iterator();
-            Iterator<? extends TypeMirror> i2 = declaredThrownTypes.iterator();
-            while (i1.hasNext() && i2.hasNext()) {
-                TypeMirror t1 = i1.next();
-                TypeMirror t2 = i2.next();
-                if (!types.isSameType(t1, t2))
-                    map.put(t2.toString(), t1);
+    private Content inheritThrowsDocumentation(ExecutableElement holder,
+                                               List<? extends TypeMirror> declaredExceptionTypes,
+                                               Set<String> alreadyDocumented,
+                                               Map<String, TypeMirror> typeSubstitutions,
+                                               TagletWriter writer) {
+        Content result = writer.getOutputInstance();
+        if (holder.getKind() != ElementKind.METHOD) {
+            // (Optimization.)
+            // Of all executable elements, only methods and constructors are documented.
+            // Of these two, only methods inherit documentation.
+            // Don't waste time on constructors.
+            assert holder.getKind() == ElementKind.CONSTRUCTOR : holder.getKind();
+            return result;
+        }
+        Utils utils = writer.configuration().utils;
+        Map<List<ThrowsTree>, ExecutableElement> declaredExceptionTags = new LinkedHashMap<>();
+        for (TypeMirror declaredExceptionType : declaredExceptionTypes) {
+            var input = new DocFinder.Input(utils, holder, this,
+                    utils.getTypeName(declaredExceptionType, false));
+            DocFinder.Output inheritedDoc = DocFinder.search(writer.configuration(), input);
+            if (inheritedDoc.tagList.isEmpty()) {
+                input = new DocFinder.Input(utils, holder, this,
+                        utils.getTypeName(declaredExceptionType, true));
+                inheritedDoc = DocFinder.search(writer.configuration(), input);
+            }
+            if (!inheritedDoc.tagList.isEmpty()) {
+                if (inheritedDoc.holder == null) {
+                    inheritedDoc.holder = holder;
+                }
+                List<ThrowsTree> inheritedTags = inheritedDoc.tagList.stream()
+                        .map(t -> (ThrowsTree) t)
+                        .toList();
+                declaredExceptionTags.put(inheritedTags, (ExecutableElement) inheritedDoc.holder);
             }
-            return map;
         }
-        return Map.of();
+        result.add(throwsTagsOutput(declaredExceptionTags, writer, alreadyDocumented,
+                typeSubstitutions, false));
+        return result;
+    }
+
+    private Content linkToUndocumentedDeclaredExceptions(List<? extends TypeMirror> declaredExceptionTypes,
+                                                         Set<String> alreadyDocumented,
+                                                         TagletWriter writer) {
+        // TODO: assert declaredExceptionTypes are instantiated
+        Utils utils = writer.configuration().utils;
+        Content result = writer.getOutputInstance();
+        for (TypeMirror declaredExceptionType : declaredExceptionTypes) {
+            TypeElement te = utils.asTypeElement(declaredExceptionType);
+            if (te != null &&
+                    !alreadyDocumented.contains(declaredExceptionType.toString()) &&
+                    !alreadyDocumented.contains(utils.getFullyQualifiedName(te, false))) {
+                if (alreadyDocumented.isEmpty()) {
+                    result.add(writer.getThrowsHeader());
+                }
+                result.add(writer.throwsTagOutput(declaredExceptionType));
+                alreadyDocumented.add(utils.getSimpleName(te));
+            }
+        }
+        return result;
     }
 }