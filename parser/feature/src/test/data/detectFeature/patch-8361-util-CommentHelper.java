@@ -711,7 +711,7 @@ private DocTreePath getInheritedDocTreePath(DocTree dtree, ExecutableElement ee)
         DocFinder.Output inheritedDoc =
                 DocFinder.search(configuration,
                         new DocFinder.Input(utils, ee));
-        return inheritedDoc == null || inheritedDoc.holder == ee
+        return inheritedDoc.holder == ee
                 ? null
                 : utils.getCommentHelper(inheritedDoc.holder).getDocTreePath(dtree);
     }