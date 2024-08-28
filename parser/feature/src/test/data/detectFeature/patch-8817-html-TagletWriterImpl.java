@@ -459,6 +459,7 @@ protected Content snippetTagOutput(Element element, SnippetTree tag, StyledText
                         .add(new HtmlTree(TagName.IMG)
                                 .put(HtmlAttr.SRC, htmlWriter.pathToRoot.resolve(DocPaths.CLIPBOARD_SVG).getPath())
                                 .put(HtmlAttr.ALT, copyText))
+                        .addStyle(HtmlStyle.copy)
                         .addStyle(HtmlStyle.snippetCopy)
                         .put(HtmlAttr.ONCLICK, "copySnippet(this)"));
         return snippetContainer.add(pre.add(code));