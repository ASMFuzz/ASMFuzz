@@ -59,6 +59,7 @@
 import com.sun.source.doctree.SerialTree;
 import com.sun.source.doctree.SinceTree;
 import com.sun.source.doctree.SnippetTree;
+import com.sun.source.doctree.SpecTree;
 import com.sun.source.doctree.StartElementTree;
 import com.sun.source.doctree.SummaryTree;
 import com.sun.source.doctree.SystemPropertyTree;
@@ -336,6 +337,15 @@ default ReturnTree newReturnTree(boolean isInline, List<? extends DocTree> descr
      */
     SnippetTree newSnippetTree(List<? extends DocTree> attributes, TextTree text);
 
+    /**
+     * Creates a new {@code SpecTree} object, to represent an {@code @spec} tag.
+     * @param url    the url
+     * @param title  the title
+     * @return a {@code SpecTree} object
+     * @since 20
+     */
+    SpecTree newSpecTree(TextTree url, List<? extends DocTree> title);
+
     /**
      * Creates a new {@code StartElementTree} object, to represent the start of an HTML element.
      * @param name the name of the HTML element