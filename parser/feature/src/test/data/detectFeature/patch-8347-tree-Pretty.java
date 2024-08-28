@@ -170,14 +170,6 @@ public static String toSimpleString(JCTree tree, int maxLength) {
      * Traversal methods
      *************************************************************************/
 
-    /** Exception to propagate IOException through visitXYZ methods */
-    private static class UncheckedIOException extends Error {
-        static final long serialVersionUID = -4032692679158424751L;
-        UncheckedIOException(IOException e) {
-            super(e.getMessage(), e);
-        }
-    }
-
     /** Visitor argument: the current precedence level.
      */
     int prec;