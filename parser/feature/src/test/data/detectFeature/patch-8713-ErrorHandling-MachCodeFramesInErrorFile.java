@@ -162,6 +162,7 @@ private static void run(boolean crashInJava) throws Exception {
             // code blob dumping is missing, exit successfully.
             System.out.println("Could not find \"" + preCodeBlobSectionHeader + "\" in " + hsErrPath);
             System.out.println("Looks like hs-err is truncated - exiting with success");
+            return;
         }
 
         Matcher matcher = Pattern.compile("\\[MachCode\\]\\s*\\[Verified Entry Point\\]\\s*  # \\{method\\} \\{[^}]*\\} '([^']+)' '([^']+)' in '([^']+)'", Pattern.DOTALL).matcher(hsErr);