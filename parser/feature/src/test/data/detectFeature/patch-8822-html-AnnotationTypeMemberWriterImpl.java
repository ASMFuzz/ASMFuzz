@@ -270,7 +270,7 @@ public void addDefaultValueInfo(Element member, Content annotationContent) {
             if (value != null) {
                 var dl = HtmlTree.DL(HtmlStyle.notes);
                 dl.add(HtmlTree.DT(contents.default_));
-                dl.add(HtmlTree.DD(Text.of(value.toString())));
+                dl.add(HtmlTree.DD(HtmlTree.CODE(Text.of(value.toString()))));
                 annotationContent.add(dl);
             }
         }