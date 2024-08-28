@@ -154,6 +154,16 @@ private static void run(boolean crashInJava) throws Exception {
             return;
         }
 
+        String preCodeBlobSectionHeader = "Stack slot to memory mapping:";
+        if (!hsErr.contains(preCodeBlobSectionHeader) &&
+            System.getProperty("os.arch").equals("aarch64") &&
+            System.getProperty("os.name").toLowerCase().startsWith("mac")) {
+            // JDK-8282607: hs_err can be truncated. If the section preceding
+            // code blob dumping is missing, exit successfully.
+            System.out.println("Could not find \"" + preCodeBlobSectionHeader + "\" in " + hsErrPath);
+            System.out.println("Looks like hs-err is truncated - exiting with success");
+        }
+
         Matcher matcher = Pattern.compile("\\[MachCode\\]\\s*\\[Verified Entry Point\\]\\s*  # \\{method\\} \\{[^}]*\\} '([^']+)' '([^']+)' in '([^']+)'", Pattern.DOTALL).matcher(hsErr);
         List<String> machCodeHeaders = matcher.results().map(mr -> String.format("'%s' '%s' in '%s'", mr.group(1), mr.group(2), mr.group(3))).collect(Collectors.toList());
         int minExpectedMachCodeSections = Math.max(1, compiledJavaFrames);