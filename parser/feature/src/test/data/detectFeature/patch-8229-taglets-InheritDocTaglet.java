@@ -26,8 +26,11 @@
 package jdk.javadoc.internal.doclets.toolkit.taglets;
 
 import java.util.EnumSet;
+
 import javax.lang.model.element.Element;
 import javax.lang.model.element.ExecutableElement;
+import javax.lang.model.element.TypeElement;
+import javax.lang.model.type.TypeKind;
 
 import com.sun.source.doctree.DocTree;
 import jdk.javadoc.doclet.Taglet.Location;
@@ -36,71 +39,81 @@
 import jdk.javadoc.internal.doclets.toolkit.Messages;
 import jdk.javadoc.internal.doclets.toolkit.util.CommentHelper;
 import jdk.javadoc.internal.doclets.toolkit.util.DocFinder;
-import jdk.javadoc.internal.doclets.toolkit.util.DocFinder.Input;
 import jdk.javadoc.internal.doclets.toolkit.util.Utils;
 
 /**
- * An inline taglet representing the {@code {@inheritDoc}} tag. This tag should only
- * be used with a method.  It is used to inherit documentation from overridden
- * and implemented methods.
+ * An inline taglet representing the {@code {@inheritDoc}} tag.
+ * It is used to copy documentation from superclass (but not superinterface)
+ * declarations and from overridden and implemented methods.
  */
 public class InheritDocTaglet extends BaseTaglet {
 
     /**
      * Construct a new InheritDocTaglet.
      */
-    public InheritDocTaglet () {
+    public InheritDocTaglet() {
         super(DocTree.Kind.INHERIT_DOC, true, EnumSet.of(Location.TYPE, Location.METHOD));
     }
 
     /**
      * Given an element, a {@code DocTree} in the element's doc comment
-     * replace all occurrences of @inheritDoc with documentation from its
+     * replace all occurrences of {@code {@inheritDoc}} with documentation from its
      * superclass or superinterface.
      *
      * @param writer the writer that is writing the output.
      * @param e the {@link Element} that we are documenting.
-     * @param holderTag the tag that holds the inheritDoc tag or null for type
-     * (class) docs.
-     * @param isFirstSentence true if we only want to inherit the first sentence.
+     *
+     * @param holderTag
+     *
+     * either the tag that holds the {@code {@inheritDoc}} tag or {@code null},
+     * which can mean either of:
+     * <ul>
+     *     <li>the tag is used on a class {@link jdk.javadoc.doclet.Taglet.Location#TYPE} declaration, or
+     *     <li>the tag is used to copy the overall doc comment
+     * </ul>
+     *
+     * @param isFirstSentence true if we only want to inherit the first sentence
      */
     private Content retrieveInheritedDocumentation(TagletWriter writer,
-            Element e, DocTree holderTag, boolean isFirstSentence) {
+                                                   Element e,
+                                                   DocTree holderTag,
+                                                   boolean isFirstSentence) {
         Content replacement = writer.getOutputInstance();
         BaseConfiguration configuration = writer.configuration();
         Messages messages = configuration.getMessages();
         Utils utils = configuration.utils;
         CommentHelper ch = utils.getCommentHelper(e);
-        Taglet inheritableTaglet = holderTag == null
+        Taglet taglet = holderTag == null
                 ? null
                 : configuration.tagletManager.getTaglet(ch.getTagName(holderTag));
-        if (inheritableTaglet != null &&
-            !(inheritableTaglet instanceof InheritableTaglet)) {
-                String message = utils.getSimpleName(e) +
-                    ((utils.isExecutableElement(e))
-                        ? utils.flatSignature((ExecutableElement)e, writer.getCurrentPageElement())
-                        : "");
-                //This tag does not support inheritance.
-                var path = writer.configuration().utils.getCommentHelper(e).getDocTreePath(holderTag);
-                messages.warning(path, "doclet.inheritDocWithinInappropriateTag", message);
-                return replacement;
+        if (taglet != null && !(taglet instanceof InheritableTaglet)) {
+            // This tag does not support inheritance.
+            var path = writer.configuration().utils.getCommentHelper(e).getDocTreePath(holderTag);
+            messages.warning(path, "doclet.inheritDocWithinInappropriateTag");
+            return replacement;
         }
-        Input input = new DocFinder.Input(utils, e,
-                (InheritableTaglet) inheritableTaglet, new DocFinder.DocTreeInfo(holderTag, e),
-                isFirstSentence, true);
+        var input = new DocFinder.Input(utils, e, (InheritableTaglet) taglet,
+                new DocFinder.DocTreeInfo(holderTag, e), isFirstSentence, true);
         DocFinder.Output inheritedDoc = DocFinder.search(configuration, input);
         if (inheritedDoc.isValidInheritDocTag) {
             if (!inheritedDoc.inlineTags.isEmpty()) {
                 replacement = writer.commentTagsToOutput(inheritedDoc.holder, inheritedDoc.holderTag,
-                    inheritedDoc.inlineTags, isFirstSentence);
+                        inheritedDoc.inlineTags, isFirstSentence);
             }
-
         } else {
-            String message = utils.getSimpleName(e) +
+            // This is to assert that we don't reach here for a class declaration.
+            // Indeed, every class except for java.lang.Object has a superclass.
+            // If we ever reach here, we would need a different warning; because
+            // the below warning is about method declarations, not class declarations.
+            // Unless @inheritDoc is used inside java.lang.Object itself,
+            // which would clearly be an error, we shouldn't reach here.
+            assert !(e instanceof TypeElement typeElement)
+                    || typeElement.getSuperclass().getKind() == TypeKind.NONE;
+            String signature = utils.getSimpleName(e) +
                     ((utils.isExecutableElement(e))
-                        ? utils.flatSignature((ExecutableElement)e, writer.getCurrentPageElement())
-                        : "");
-            messages.warning(e, "doclet.noInheritedDoc", message);
+                            ? utils.flatSignature((ExecutableElement) e, writer.getCurrentPageElement())
+                            : e.toString());
+            messages.warning(e, "doclet.noInheritedDoc", signature);
         }
         return replacement;
     }