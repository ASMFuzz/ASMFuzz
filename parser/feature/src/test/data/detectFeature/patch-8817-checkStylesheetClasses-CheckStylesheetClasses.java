@@ -135,7 +135,7 @@ void run() throws Exception {
         removeAll(styleSheetNames, "borderless", "plain", "striped");
 
         // used in search.js and search-page.js; may be worth documenting in HtmlStyle
-        removeAll(styleSheetNames, "result-highlight", "result-item",
+        removeAll(styleSheetNames, "result-highlight", "result-item", "copy-header",
                 "search-tag-desc-result", "search-tag-holder-result", "page-search-header",
                 "ui-autocomplete", "ui-autocomplete-category", "expanded",
                 "search-result-link", "two-column-search-results", "ui-static-link");