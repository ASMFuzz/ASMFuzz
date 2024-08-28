@@ -276,10 +276,11 @@ private int test(S obj) {
                    }
                }
                """,
+               "Test.java:6:27: compiler.err.guard.has.constant.expression.false",
                "Test.java:5:16: compiler.err.not.exhaustive",
                "- compiler.note.preview.filename: Test.java, DEFAULT",
                "- compiler.note.preview.recompile",
-               "1 error");
+               "2 errors");
     }
 
     @Test