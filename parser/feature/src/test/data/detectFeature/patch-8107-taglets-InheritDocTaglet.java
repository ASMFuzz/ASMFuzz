@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2001, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2001, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -87,7 +87,9 @@ private Content retrieveInheritedDocumentation(TagletWriter writer,
                         ? utils.flatSignature((ExecutableElement)e, writer.getCurrentPageElement())
                         : "");
                 //This tag does not support inheritance.
-                messages.warning(e, "doclet.noInheritedDoc", message);
+                var path = writer.configuration().utils.getCommentHelper(e).getDocTreePath(holderTag);
+                messages.warning(path, "doclet.inheritDocWithinInappropriateTag", message);
+                return replacement;
         }
         Input input = new DocFinder.Input(utils, e,
                 (InheritableTaglet) inheritableTaglet, new DocFinder.DocTreeInfo(holderTag, e),