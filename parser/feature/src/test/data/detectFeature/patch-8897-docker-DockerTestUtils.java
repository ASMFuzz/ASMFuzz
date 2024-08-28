@@ -269,7 +269,6 @@ public static OutputAnalyzer execute(List<String> command) throws Exception {
      * @throws Exception
      */
     public static OutputAnalyzer execute(String... command) throws Exception {
-
         ProcessBuilder pb = new ProcessBuilder(command);
         System.out.println("[COMMAND]\n" + Utils.getCommandLine(pb));
 
@@ -278,14 +277,19 @@ public static OutputAnalyzer execute(String... command) throws Exception {
         long pid = p.pid();
         OutputAnalyzer output = new OutputAnalyzer(p);
 
-        String stdoutLogFile = String.format("docker-stdout-%d.log", pid);
+        int max = MAX_LINES_TO_COPY_FOR_CHILD_STDOUT;
+        String stdout = output.getStdout();
+        String stdoutLimited = limitLines(stdout, max);
         System.out.println("[ELAPSED: " + (System.currentTimeMillis() - started) + " ms]");
         System.out.println("[STDERR]\n" + output.getStderr());
-        System.out.println("[STDOUT]\n" +
-                           trimLines(output.getStdout(),MAX_LINES_TO_COPY_FOR_CHILD_STDOUT));
-        System.out.printf("Child process STDOUT is trimmed to %d lines \n",
-                           MAX_LINES_TO_COPY_FOR_CHILD_STDOUT);
-        writeOutputToFile(output.getStdout(), stdoutLogFile);
+        System.out.println("[STDOUT]\n" + stdoutLimited);
+        if (stdout != stdoutLimited) {
+            System.out.printf("Child process STDOUT is limited to %d lines\n",
+                              max);
+        }
+
+        String stdoutLogFile = String.format("docker-stdout-%d.log", pid);
+        writeOutputToFile(stdout, stdoutLogFile);
         System.out.println("Full child process STDOUT was saved to " + stdoutLogFile);
 
         return output;
@@ -299,7 +303,7 @@ private static void writeOutputToFile(String output, String fileName) throws Exc
     }
 
 
-    private static String trimLines(String buffer, int nrOfLines) {
+    private static String limitLines(String buffer, int nrOfLines) {
         List<String> l = Arrays.asList(buffer.split("\\R"));
         if (l.size() < nrOfLines) {
             return buffer;