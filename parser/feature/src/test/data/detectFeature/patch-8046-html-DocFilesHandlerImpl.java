@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2017, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2017, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -52,7 +52,6 @@
 import java.net.URI;
 import java.net.URISyntaxException;
 import java.util.ArrayList;
-import java.util.Collections;
 import java.util.List;
 
 import jdk.javadoc.internal.doclets.formats.html.Navigation.PageMode;
@@ -213,7 +212,7 @@ private void handleHtmlFile(DocFile srcfile, DocPath dstPath) throws DocFileIOEx
                 .setHeader(docletWriter.getHeader(PageMode.DOC_FILE, element))
                 .addMainContent(pageContent)
                 .setFooter(docletWriter.getFooter()));
-        docletWriter.printHtmlDocument(Collections.emptyList(), null, localTagsContent, Collections.emptyList(), htmlContent);
+        docletWriter.printHtmlDocument(List.of(), null, localTagsContent, List.of(), htmlContent);
     }
 
 