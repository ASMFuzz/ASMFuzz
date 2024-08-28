@@ -486,15 +486,15 @@ public static void main(String args[]) throws Throwable {
                             equal(run(pb).exitValue(),
                                   False.exitValue());
                             // Traditional shell scripts without #!
-                            setFileContents(prog, "exec /bin/true\n");
-                            prog.setExecutable(true);
-                            equal(run(pb).exitValue(),
-                                  True.exitValue());
-                            prog.delete();
-                            setFileContents(prog, "exec /bin/false\n");
-                            prog.setExecutable(true);
-                            equal(run(pb).exitValue(),
-                                  False.exitValue());
+                            if (!(Platform.isLinux() && Platform.isMusl())) {
+                                setFileContents(prog, "exec /bin/true\n");
+                                prog.setExecutable(true);
+                                equal(run(pb).exitValue(), True.exitValue());
+                                prog.delete();
+                                setFileContents(prog, "exec /bin/false\n");
+                                prog.setExecutable(true);
+                                equal(run(pb).exitValue(), False.exitValue());
+                            }
                             prog.delete();
                         }
 
@@ -511,14 +511,16 @@ public static void main(String args[]) throws Throwable {
                         pb.command(cmd);
 
                         // Test traditional shell scripts without #!
-                        setFileContents(dir1Prog, "/bin/echo \"$@\"\n");
-                        pb.command(new String[] {"prog", "hello", "world"});
-                        checkPermissionDenied(pb);
-                        dir1Prog.setExecutable(true);
-                        equal(run(pb).out(), "hello world\n");
-                        equal(run(pb).exitValue(), True.exitValue());
-                        dir1Prog.delete();
-                        pb.command(cmd);
+                        if (!(Platform.isLinux() && Platform.isMusl())) {
+                            setFileContents(dir1Prog, "/bin/echo \"$@\"\n");
+                            pb.command(new String[] {"prog", "hello", "world"});
+                            checkPermissionDenied(pb);
+                            dir1Prog.setExecutable(true);
+                            equal(run(pb).out(), "hello world\n");
+                            equal(run(pb).exitValue(), True.exitValue());
+                            dir1Prog.delete();
+                            pb.command(cmd);
+                        }
 
                         // If prog found on both parent and child's PATH,
                         // parent's is used.