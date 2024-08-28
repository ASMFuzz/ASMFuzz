@@ -487,7 +487,7 @@ public static void testMultipleArgs() throws Throwable {
         Object[] parList = Helper.randomArgs(mTypeNew.parameterList());
         for (int i = 0; i < parList.length; i++) {
             if (parList[i] instanceof String) {
-                parList[i] = null; //getting rid of Stings produced by randomArgs
+                parList[i] = null; //getting rid of Strings produced by randomArgs
             }
         }
         target.invokeWithArguments(parList);