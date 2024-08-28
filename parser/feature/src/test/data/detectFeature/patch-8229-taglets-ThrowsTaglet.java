@@ -55,8 +55,7 @@
 /**
  * A taglet that represents the {@code @throws} tag.
  */
-public class ThrowsTaglet extends BaseTaglet
-    implements InheritableTaglet {
+public class ThrowsTaglet extends BaseTaglet implements InheritableTaglet {
 
     public ThrowsTaglet() {
         super(DocTree.Kind.THROWS, false, EnumSet.of(Location.CONSTRUCTOR, Location.METHOD));
@@ -68,10 +67,10 @@ public void inherit(DocFinder.Input input, DocFinder.Output output) {
         Element exception;
         CommentHelper ch = utils.getCommentHelper(input.element);
         if (input.tagId == null) {
-            exception = input.docTreeInfo.docTree instanceof ThrowsTree tt
+            exception = input.docTreeInfo.docTree() instanceof ThrowsTree tt
                     ? ch.getException(tt) : null;
             input.tagId = exception == null
-                    ? ch.getExceptionName(input.docTreeInfo.docTree).getSignature()
+                    ? ch.getExceptionName(input.docTreeInfo.docTree()).getSignature()
                     : utils.getFullyQualifiedName(exception);
         } else {
             exception = input.utils.findClass(input.element, input.tagId);
@@ -80,14 +79,14 @@ public void inherit(DocFinder.Input input, DocFinder.Output output) {
         for (ThrowsTree tt : input.utils.getThrowsTrees(input.element)) {
             Element exc = ch.getException(tt);
             if (exc != null && (input.tagId.equals(utils.getSimpleName(exc)) ||
-                 (input.tagId.equals(utils.getFullyQualifiedName(exc))))) {
+                    (input.tagId.equals(utils.getFullyQualifiedName(exc))))) {
                 output.holder = input.element;
                 output.holderTag = tt;
                 output.inlineTags = ch.getBody(output.holderTag);
                 output.tagList.add(tt);
             } else if (exception != null && exc != null &&
                     utils.isTypeElement(exc) && utils.isTypeElement(exception) &&
-                    utils.isSubclassOf((TypeElement)exc, (TypeElement)exception)) {
+                    utils.isSubclassOf((TypeElement) exc, (TypeElement) exception)) {
                 output.tagList.add(tt);
             }
         }
@@ -97,15 +96,16 @@ public void inherit(DocFinder.Input input, DocFinder.Output output) {
      * Add links for exceptions that are declared but not documented.
      */
     private Content linkToUndocumentedDeclaredExceptions(List<? extends TypeMirror> declaredExceptionTypes,
-            Set<String> alreadyDocumented, TagletWriter writer) {
+                                                         Set<String> alreadyDocumented,
+                                                         TagletWriter writer) {
         Utils utils = writer.configuration().utils;
         Content result = writer.getOutputInstance();
         //Add links to the exceptions declared but not documented.
         for (TypeMirror declaredExceptionType : declaredExceptionTypes) {
             TypeElement te = utils.asTypeElement(declaredExceptionType);
             if (te != null &&
-                !alreadyDocumented.contains(declaredExceptionType.toString()) &&
-                !alreadyDocumented.contains(utils.getFullyQualifiedName(te, false))) {
+                    !alreadyDocumented.contains(declaredExceptionType.toString()) &&
+                    !alreadyDocumented.contains(utils.getFullyQualifiedName(te, false))) {
                 if (alreadyDocumented.isEmpty()) {
                     result.add(writer.getThrowsHeader());
                 }
@@ -121,8 +121,10 @@ private Content linkToUndocumentedDeclaredExceptions(List<? extends TypeMirror>
      * documented.
      */
     private Content inheritThrowsDocumentation(Element holder,
-            List<? extends TypeMirror> declaredExceptionTypes, Set<String> alreadyDocumented,
-            Map<String, TypeMirror> typeSubstitutions, TagletWriter writer) {
+                                               List<? extends TypeMirror> declaredExceptionTypes,
+                                               Set<String> alreadyDocumented,
+                                               Map<String, TypeMirror> typeSubstitutions,
+                                               TagletWriter writer) {
         Utils utils = writer.configuration().utils;
         Content result = writer.getOutputInstance();
         if (utils.isMethod(holder)) {
@@ -157,7 +159,7 @@ public Content getAllBlockTagOutput(Element holder, TagletWriter writer) {
         Utils utils = writer.configuration().utils;
         ExecutableElement execHolder = (ExecutableElement) holder;
         ExecutableType instantiatedType = utils.asInstantiatedMethodType(
-                writer.getCurrentPageElement(), (ExecutableElement)holder);
+                writer.getCurrentPageElement(), (ExecutableElement) holder);
         List<? extends TypeMirror> thrownTypes = instantiatedType.getThrownTypes();
         Map<String, TypeMirror> typeSubstitutions = getSubstitutedThrownTypes(
                 writer.configuration().utils.typeUtils,
@@ -186,8 +188,10 @@ public Content getAllBlockTagOutput(Element holder, TagletWriter writer) {
      * @return the generated content for the tags
      */
     protected Content throwsTagsOutput(Map<List<? extends ThrowsTree>, ExecutableElement> throwTags,
-                                       TagletWriter writer, Set<String> alreadyDocumented,
-                                       Map<String,TypeMirror> typeSubstitutions, boolean allowDuplicates) {
+                                       TagletWriter writer,
+                                       Set<String> alreadyDocumented,
+                                       Map<String, TypeMirror> typeSubstitutions,
+                                       boolean allowDuplicates) {
         Utils utils = writer.configuration().utils;
         Content result = writer.getOutputInstance();
         if (!throwTags.isEmpty()) {
@@ -199,9 +203,9 @@ protected Content throwsTagsOutput(Map<List<? extends ThrowsTree>, ExecutableEle
                     String excName = ch.getExceptionName(dt).toString();
                     TypeMirror substituteType = typeSubstitutions.get(excName);
                     if ((!allowDuplicates) &&
-                        (alreadyDocumented.contains(excName) ||
-                        (te != null && alreadyDocumented.contains(utils.getFullyQualifiedName(te, false)))) ||
-                        (substituteType != null && alreadyDocumented.contains(substituteType.toString()))) {
+                            (alreadyDocumented.contains(excName) ||
+                                    (te != null && alreadyDocumented.contains(utils.getFullyQualifiedName(te, false)))) ||
+                            (substituteType != null && alreadyDocumented.contains(substituteType.toString()))) {
                         continue;
                     }
                     if (alreadyDocumented.isEmpty()) {