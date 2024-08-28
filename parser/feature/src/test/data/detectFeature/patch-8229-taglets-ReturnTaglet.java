@@ -94,7 +94,7 @@ public Content getAllBlockTagOutput(Element holder, TagletWriter writer) {
         List<? extends ReturnTree> tags = utils.getReturnTrees(holder);
 
         // Make sure we are not using @return tag on method with void return type.
-        TypeMirror returnType = utils.getReturnType(writer.getCurrentPageElement(), (ExecutableElement)holder);
+        TypeMirror returnType = utils.getReturnType(writer.getCurrentPageElement(), (ExecutableElement) holder);
         if (returnType != null && utils.isVoid(returnType)) {
             if (!tags.isEmpty()) {
                 messages.warning(holder, "doclet.Return_tag_on_void_method");