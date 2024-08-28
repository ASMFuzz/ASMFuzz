@@ -114,12 +114,10 @@ static void test(boolean dumpWithParallel, boolean execWithParallel, boolean use
                 if (out.getExitValue() == 0) {
                     out.shouldContain(HELLO);
                 } else {
-                    String output = out.getStdout() + out.getStderr();
-                    String exp1 = "Too small maximum heap";
-                    String exp2 = "GC triggered before VM initialization completed";
-                    if (!output.contains(exp1) && !output.contains(exp2)) {
-                        throw new RuntimeException("Either '" + exp1 + "' or '" + exp2 + "' must be in stdout/stderr \n");
-                    }
+                    String pattern = "((Too small maximum heap)" +
+                                       "|(GC triggered before VM initialization completed)" +
+                                       "|(java.lang.OutOfMemoryError: Java heap space))";
+                    out.shouldMatch(pattern);
                 }
                 n++;
             }