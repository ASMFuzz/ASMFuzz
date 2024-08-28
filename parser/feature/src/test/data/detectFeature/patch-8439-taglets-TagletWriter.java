@@ -35,6 +35,7 @@
 import javax.lang.model.type.TypeMirror;
 
 import com.sun.source.doctree.DocTree;
+import com.sun.source.doctree.SpecTree;
 import com.sun.source.doctree.IndexTree;
 import com.sun.source.doctree.LinkTree;
 import com.sun.source.doctree.LiteralTree;
@@ -195,10 +196,20 @@ protected TagletWriter(boolean isFirstSentence) {
     protected abstract Content snippetTagOutput(Element element, SnippetTree snippetTag, StyledText text,
                                                 String id, String lang);
 
+    /**
+     * Returns the output for one or more {@code @spec} tags.
+     *
+     * @param element  the element that owns the doc comment
+     * @param specTags the array of @spec tags.
+     *
+     * @return the output
+     */
+    protected abstract Content specTagOutput(Element element, List<? extends SpecTree> specTags);
+
     /**
      * Returns the output for a {@code {@systemProperty...}} tag.
      *
-     * @param element           The element that owns the doc comment
+     * @param element           the element that owns the doc comment
      * @param systemPropertyTag the system property tag
      *
      * @return the output