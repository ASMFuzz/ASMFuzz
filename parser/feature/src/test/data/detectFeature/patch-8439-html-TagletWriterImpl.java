@@ -25,6 +25,8 @@
 
 package jdk.javadoc.internal.doclets.formats.html;
 
+import java.net.URI;
+import java.net.URISyntaxException;
 import java.util.ArrayList;
 import java.util.EnumSet;
 import java.util.HashSet;
@@ -34,6 +36,7 @@
 import java.util.Set;
 import java.util.function.BiConsumer;
 import java.util.function.Predicate;
+import java.util.stream.Collectors;
 
 import javax.lang.model.element.Element;
 import javax.lang.model.element.ElementKind;
@@ -54,9 +57,11 @@
 import com.sun.source.doctree.ReturnTree;
 import com.sun.source.doctree.SeeTree;
 import com.sun.source.doctree.SnippetTree;
+import com.sun.source.doctree.SpecTree;
 import com.sun.source.doctree.SystemPropertyTree;
 import com.sun.source.doctree.TextTree;
 import com.sun.source.doctree.ThrowsTree;
+import com.sun.source.doctree.TextTree;
 import com.sun.source.util.DocTreePath;
 import jdk.javadoc.internal.doclets.formats.html.markup.ContentBuilder;
 import jdk.javadoc.internal.doclets.formats.html.markup.HtmlAttr;
@@ -80,6 +85,7 @@
 import jdk.javadoc.internal.doclets.toolkit.util.DocLink;
 import jdk.javadoc.internal.doclets.toolkit.util.DocPath;
 import jdk.javadoc.internal.doclets.toolkit.util.DocPaths;
+import jdk.javadoc.internal.doclets.toolkit.util.DocletConstants;
 import jdk.javadoc.internal.doclets.toolkit.util.IndexItem;
 import jdk.javadoc.internal.doclets.toolkit.util.Utils;
 import jdk.javadoc.internal.doclets.toolkit.util.Utils.PreviewFlagProvider;
@@ -400,6 +406,20 @@ private boolean isLongOrHasComma(Content c) {
         return s.length() > SEE_TAG_MAX_INLINE_LENGTH || s.contains(",");
     }
 
+    String textOf(List<? extends DocTree> trees) {
+        return trees.stream()
+                .filter(dt -> dt instanceof TextTree)
+                .map(dt -> ((TextTree) dt).getBody().trim())
+                .collect(Collectors.joining(" "));
+    }
+
+    private void appendSeparatorIfNotEmpty(ContentBuilder body) {
+        if (!body.isEmpty()) {
+            body.add(", ");
+            body.add(Text.NL);
+        }
+    }
+
     /**
      * {@return the output for a single {@code @see} tag}
      *
@@ -718,6 +738,54 @@ public Element getLinkedElement(Element referer, String signature) {
         return utils.docTrees.getElement(fabricatedPath);
     }
 
+    @Override
+    public Content specTagOutput(Element holder, List<? extends SpecTree> specTags) {
+        ContentBuilder body = new ContentBuilder();
+        for (SpecTree st : specTags) {
+            appendSeparatorIfNotEmpty(body);
+            body.add(specTagToContent(holder, st));
+        }
+        if (body.isEmpty())
+            return body;
+
+        return new ContentBuilder(
+                HtmlTree.DT(contents.externalSpecifications),
+                HtmlTree.DD(body));
+    }
+
+    private Content specTagToContent(Element holder, SpecTree specTree) {
+        String specTreeURL = specTree.getURL().getBody();
+        List<? extends DocTree> specTreeLabel = specTree.getTitle();
+        Content label = htmlWriter.commentTagsToContent(holder, specTreeLabel, isFirstSentence);
+        return getExternalSpecContent(holder, specTree, specTreeURL, textOf(specTreeLabel), label);
+    }
+
+    Content getExternalSpecContent(Element holder, DocTree docTree, String url, String searchText, Content title) {
+        URI specURI;
+        try {
+            // Use the canonical title of the spec if one is available
+            specURI = new URI(url);
+        } catch (URISyntaxException e) {
+            CommentHelper ch = utils.getCommentHelper(holder);
+            DocTreePath dtp = ch.getDocTreePath(docTree);
+            htmlWriter.messages.error(dtp, "doclet.Invalid_URL", e.getMessage());
+            specURI = null;
+        }
+
+        Content titleWithAnchor = createAnchorAndSearchIndex(holder,
+                searchText,
+                title,
+                resources.getText("doclet.External_Specification"),
+                docTree);
+
+        if (specURI == null) {
+            return titleWithAnchor;
+        } else {
+            return HtmlTree.A(htmlWriter.resolveExternalSpecURI(specURI), titleWithAnchor);
+        }
+
+    }
+
     @Override
     protected Content systemPropertyTagOutput(Element element, SystemPropertyTree tag) {
         String tagText = tag.getPropertyName().toString();
@@ -810,13 +878,22 @@ protected TypeElement getCurrentPageElement() {
         return htmlWriter.getCurrentPageElement();
     }
 
+    public HtmlDocletWriter getHtmlWriter() {
+        return htmlWriter;
+    }
+
     private Content createAnchorAndSearchIndex(Element element, String tagText, String desc, DocTree tree) {
+        return createAnchorAndSearchIndex(element, tagText, Text.of(tagText), desc, tree);
+    }
+
+    @SuppressWarnings("preview")
+    private Content createAnchorAndSearchIndex(Element element, String tagText, Content tagContent, String desc, DocTree tree) {
         Content result = null;
         if (context.isFirstSentence && context.inSummary || context.inTags.contains(DocTree.Kind.INDEX)) {
-            result = Text.of(tagText);
+            result = tagContent;
         } else {
             HtmlId id = HtmlIds.forText(tagText, htmlWriter.indexAnchorTable);
-            result = HtmlTree.SPAN(id, HtmlStyle.searchTagResult, Text.of(tagText));
+            result = HtmlTree.SPAN(id, HtmlStyle.searchTagResult, tagContent);
             if (options.createIndex() && !tagText.isEmpty()) {
                 String holder = new SimpleElementVisitor14<String, Void>() {
 