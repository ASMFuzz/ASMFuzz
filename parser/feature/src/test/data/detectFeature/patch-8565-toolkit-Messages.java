@@ -123,6 +123,17 @@ public void error(FileObject fo, int start, int pos, int end, String key, Object
         report(ERROR, fo, start, pos, end, resources.getText(key, args));
     }
 
+    /**
+     * Reports an error message to the doclet's reporter.
+     *
+     * @param e    an element identifying the position to be included with the message
+     * @param key  the name of a resource containing the message to be printed
+     * @param args optional arguments to be replaced in the message
+     */
+    public void error(Element e, String key, Object... args) {
+        report(ERROR, e, resources.getText(key, args));
+    }
+
     // ***** Warnings *****
 
     /**