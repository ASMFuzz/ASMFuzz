@@ -1551,6 +1551,24 @@ private List<DCTree> tagAttrs() {
                 }
             },
 
+            // @spec url label
+            new TagParser(TagParser.Kind.BLOCK, DCTree.Kind.SPEC) {
+                @Override
+                public DCTree parse(int pos) throws ParseException {
+                    skipWhitespace();
+                    DCText url = inlineWord();
+                    if (url == null || url.isBlank()) {
+                        throw new ParseException("dc.no.url");
+                    }
+                    skipWhitespace();
+                    List<DCTree> title = blockContent();
+                    if (title.isEmpty() || DCTree.isBlank(title)) {
+                        throw new ParseException("dc.no.title");
+                    }
+                    return m.at(pos).newSpecTree(url, title);
+                }
+            },
+
             // {@summary summary-text}
             new TagParser(TagParser.Kind.INLINE, DCTree.Kind.SUMMARY) {
                 @Override