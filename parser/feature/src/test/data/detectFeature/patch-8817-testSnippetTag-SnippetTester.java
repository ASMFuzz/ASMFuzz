@@ -119,7 +119,7 @@ protected String getSnippetHtmlRepresentation(String pathToHtmlFile,
         var idString = id.isEmpty() ? "" : " id=\"%s\"".formatted(id.get());
         var langString = lang.isEmpty() ? "" : " class=\"language-%s\"".formatted(lang.get());
         return """
-                <div class="snippet-container"><button class="snippet-copy" onclick="copySnippet(this)">\
+                <div class="snippet-container"><button class="copy snippet-copy" onclick="copySnippet(this)">\
                 <span data-copied="Copied!">Copy</span><img src="%s" alt="Copy"></button>
                 <pre class="snippet"%s><code%s>%s</code></pre>
                 </div>""".formatted(svgString, idString, langString, content);