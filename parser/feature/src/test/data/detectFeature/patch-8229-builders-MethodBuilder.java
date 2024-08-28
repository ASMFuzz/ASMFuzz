@@ -169,8 +169,8 @@ protected void buildMethodComments(Content methodContent) {
             if (utils.getFullBody(currentMethod).isEmpty()) {
                 DocFinder.Output docs = DocFinder.search(configuration,
                         new DocFinder.Input(utils, currentMethod));
-                if (docs.inlineTags != null && !docs.inlineTags.isEmpty())
-                        method = (ExecutableElement)docs.holder;
+                if (!docs.inlineTags.isEmpty())
+                    method = (ExecutableElement) docs.holder;
             }
             TypeMirror containingType = method.getEnclosingElement().asType();
             writer.addComments(containingType, method, methodContent);