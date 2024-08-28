@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2002, 2012, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2002, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -101,31 +101,22 @@ public void verbose(String msg) {
         }
 
         boolean ok = true;
-        /* Original usage */
-        if (args.length == 2 && args[0].charAt(0) != '-' ) {
-            ok = createFile(args[0], args[1], "java.util.ListResourceBundle");
-        } else if (args.length == 3) {
-            ok = createFile(args[0], args[1], args[2]);
-        } else if (args.length == 0) {
-            usage(log);
+
+        ok = parseOptions(args);
+        if ( ok && compileCount == 0 ) {
+            log.error("options parsed but no files to compile", null);
             ok = false;
+        }
+        /* Need at least one file. */
+        if ( !ok ) {
+            usage(log);
         } else {
-            /* New batch usage */
-            ok = parseOptions(args);
-            if ( ok && compileCount == 0 ) {
-                log.error("options parsed but no files to compile", null);
-                ok = false;
-            }
-            /* Need at least one file. */
-            if ( !ok ) {
-                usage(log);
-            } else {
-                /* Process files */
-                for ( int i = 0; i < compileCount && ok ; i++ ) {
-                    ok = createFile(propfiles[i], outfiles[i], supers[i]);
-                }
+            /* Process files */
+            for ( int i = 0; i < compileCount && ok ; i++ ) {
+                ok = createFile(propfiles[i], outfiles[i], supers[i]);
             }
         }
+
         return ok;
     }
 
@@ -153,21 +144,21 @@ private boolean parseOptions(String args[]) {
                 outfiles[compileCount]  = args[++i];
                 supers[compileCount]    = args[++i];
                 compileCount++;
-            } else if ( "-optionsfile".equals(args[i]) && i+1 < args.length ) {
-                String filename = args[++i];
+            } else if ( args[i].startsWith("@") && args[i].length() > 1 ) {
+                String filename = args[i].substring(1);
                 FileInputStream finput = null;
                 byte contents[] = null;
                 try {
                     finput = new FileInputStream(filename);
                     int byteCount = finput.available();
                     if ( byteCount <= 0 ) {
-                        log.error("The -optionsfile file is empty", null);
+                        log.error("The @-file file is empty", null);
                         ok = false;
                     } else {
                         contents = new byte[byteCount];
                         int bytesRead = finput.read(contents);
                         if ( byteCount != bytesRead ) {
-                            log.error("Cannot read all of -optionsfile file", null);
+                            log.error("Cannot read all of @-file file", null);
                             ok = false;
                         }
                     }
@@ -283,14 +274,12 @@ private boolean createFile(String propertiesPath, String outputPath,
 
     private static void usage(Log log) {
         log.info("usage:");
-        log.info("    java CompileProperties path_to_properties_file path_to_java_output_file [super_class]");
-        log.info("      -OR-");
-        log.info("    java CompileProperties {-compile path_to_properties_file path_to_java_output_file super_class} -or- -optionsfile filename");
+        log.info("    java CompileProperties {-compile path_to_properties_file path_to_java_output_file super_class} -or- @optionsfile");
         log.info("");
         log.info("Example:");
         log.info("    java CompileProperties -compile test.properties test.java java.util.ListResourceBundle");
-        log.info("    java CompileProperties -optionsfile option_file");
-        log.info("option_file contains: -compile test.properties test.java java.util.ListResourceBundle");
+        log.info("    java CompileProperties @optionsfile");
+        log.info("optionsfile contains: -compile test.properties test.java java.util.ListResourceBundle");
     }
 
     private static String escape(String theString) {