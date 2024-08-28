@@ -2500,7 +2500,7 @@ private  List<? extends ParamTree> getParamTrees(Element element, boolean isType
     }
 
     public  List<? extends ReturnTree> getReturnTrees(Element element) {
-        return new ArrayList<>(getBlockTags(element, RETURN, ReturnTree.class));
+        return getBlockTags(element, RETURN, ReturnTree.class);
     }
 
     public List<? extends UsesTree> getUsesTrees(Element element) {