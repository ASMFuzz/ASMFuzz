@@ -120,7 +120,7 @@ protected void addSearchFileContents(Content contentTree) {
                                         .put(HtmlAttr.ALT, copyText))
                                 .add(HtmlTree.SPAN(Text.of(copyText))
                                         .put(HtmlAttr.DATA_COPIED, copiedText))
-                                .addStyle(HtmlStyle.copyUrl)
+                                .addStyle(HtmlStyle.copy)
                                 .setId(HtmlId.of("page-search-copy")))
                         .add(HtmlTree.P(HtmlTree.INPUT("checkbox", HtmlId.of("search-redirect")))
                                 .add(HtmlTree.LABEL("search-redirect",