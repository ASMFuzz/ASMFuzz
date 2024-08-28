@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2015, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2015, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -329,7 +329,8 @@ public void prepareApplicationFiles(Map<String, ? super Object> params)
         }
 
         copyRuntimeFiles(params);
-        sign(params);
+
+        doSigning(params);
     }
 
     private void copyRuntimeFiles(Map<String, ? super Object> params)
@@ -355,7 +356,9 @@ private void copyRuntimeFiles(Map<String, ? super Object> params)
         }
     }
 
-    private void sign(Map<String, ? super Object> params) throws IOException {
+    private void doSigning(Map<String, ? super Object> params)
+            throws IOException {
+
         if (Optional.ofNullable(
                 SIGN_BUNDLE.fetchFrom(params)).orElse(Boolean.TRUE)) {
             try {
@@ -371,6 +374,12 @@ private void sign(Map<String, ? super Object> params) throws IOException {
                         ENTITLEMENTS.fetchFrom(params));
             }
             restoreKeychainList(params);
+        } else if (Platform.isArmMac()) {
+            signAppBundle(params, root, "-", null, null);
+        } else {
+            // Calling signAppBundle() without signingIdentity will result in
+            // unsigning app bundle
+            signAppBundle(params, root, null, null, null);
         }
     }
 
@@ -648,7 +657,40 @@ public static void restoreKeychainList(Map<String, ? super Object> params)
         IOUtils.exec(pb);
     }
 
-    static void signAppBundle(
+    private static List<String> getCodesignArgs(
+            boolean force, Path path, String signingIdentity,
+            String identifierPrefix, Path entitlements, String keyChain) {
+        List<String> args = new ArrayList<>();
+        args.addAll(Arrays.asList("/usr/bin/codesign",
+                    "-s", signingIdentity,
+                    "-vvvv"));
+
+        if (!signingIdentity.equals("-")) {
+            args.addAll(Arrays.asList("--timestamp",
+                    "--options", "runtime",
+                    "--prefix", identifierPrefix));
+            if (keyChain != null && !keyChain.isEmpty()) {
+                args.add("--keychain");
+                args.add(keyChain);
+            }
+            if (Files.isExecutable(path)) {
+                if (entitlements != null) {
+                    args.add("--entitlements");
+                    args.add(entitlements.toString());
+                }
+            }
+        }
+
+        if (force) {
+            args.add("--force");
+        }
+
+        args.add(path.toString());
+
+        return args;
+    }
+
+    private static void signAppBundle(
             Map<String, ? super Object> params, Path appLocation,
             String signingIdentity, String identifierPrefix, Path entitlements)
             throws IOException {
@@ -660,8 +702,8 @@ static void signAppBundle(
         try (Stream<Path> stream = Files.walk(appLocation)) {
             stream.peek(path -> { // fix permissions
                 try {
-                    Set<PosixFilePermission> pfp =
-                            Files.getPosixFilePermissions(path);
+                    Set<PosixFilePermission> pfp
+                            = Files.getPosixFilePermissions(path);
                     if (!pfp.contains(PosixFilePermission.OWNER_WRITE)) {
                         pfp = EnumSet.copyOf(pfp);
                         pfp.add(PosixFilePermission.OWNER_WRITE);
@@ -670,13 +712,15 @@ static void signAppBundle(
                 } catch (IOException e) {
                     Log.verbose(e);
                 }
-            }).filter(p -> Files.isRegularFile(p) &&
-                      (Files.isExecutable(p) || p.toString().endsWith(".dylib"))
-                      && !(p.toString().contains("dylib.dSYM/Contents"))
-                      && !(p.toString().endsWith(appExecutable))
-                     ).forEach(p -> {
+            }).filter(p -> Files.isRegularFile(p)
+                    && (Files.isExecutable(p) || p.toString().endsWith(".dylib"))
+                    && !(p.toString().contains("dylib.dSYM/Contents"))
+                    && !(p.toString().endsWith(appExecutable))
+            ).forEach(p -> {
                 // noinspection ThrowableResultOfMethodCallIgnored
-                if (toThrow.get() != null) return;
+                if (toThrow.get() != null) {
+                    return;
+                }
 
                 // If p is a symlink then skip the signing process.
                 if (Files.isSymbolicLink(p)) {
@@ -695,42 +739,30 @@ static void signAppBundle(
                         // run quietly
                         IOUtils.exec(pb, false, null, false,
                                 Executor.INFINITE_TIMEOUT, true);
-                        Files.setPosixFilePermissions(p,oldPermissions);
+                        Files.setPosixFilePermissions(p, oldPermissions);
                     } catch (IOException ioe) {
                         Log.verbose(ioe);
                         toThrow.set(ioe);
                         return;
                     }
-                    args = new ArrayList<>();
-                    args.addAll(Arrays.asList("/usr/bin/codesign",
-                            "--timestamp",
-                            "--options", "runtime",
-                            "-s", signingIdentity,
-                            "--prefix", identifierPrefix,
-                            "-vvvv"));
-                    if (keyChain != null && !keyChain.isEmpty()) {
-                        args.add("--keychain");
-                        args.add(keyChain);
-                    }
-                    if (Files.isExecutable(p)) {
-                        if (entitlements != null) {
-                            args.add("--entitlements");
-                            args.add(entitlements.toString());
+
+                    // Sign only if we have identity
+                    if (signingIdentity != null) {
+                        args = getCodesignArgs(false, p, signingIdentity,
+                                identifierPrefix, entitlements, keyChain);
+                        try {
+                            Set<PosixFilePermission> oldPermissions
+                                    = Files.getPosixFilePermissions(p);
+                            p.toFile().setWritable(true, true);
+                            ProcessBuilder pb = new ProcessBuilder(args);
+                            // run quietly
+                            IOUtils.exec(pb, false, null, false,
+                                    Executor.INFINITE_TIMEOUT, true);
+                            Files.setPosixFilePermissions(p, oldPermissions);
+                        } catch (IOException ioe) {
+                            toThrow.set(ioe);
                         }
                     }
-                    args.add(p.toString());
-                    try {
-                        Set<PosixFilePermission> oldPermissions =
-                                Files.getPosixFilePermissions(p);
-                        p.toFile().setWritable(true, true);
-                        ProcessBuilder pb = new ProcessBuilder(args);
-                        // run quietly
-                        IOUtils.exec(pb, false, null, false,
-                                Executor.INFINITE_TIMEOUT, true);
-                        Files.setPosixFilePermissions(p, oldPermissions);
-                    } catch (IOException ioe) {
-                        toThrow.set(ioe);
-                    }
                 }
             });
         }
@@ -739,31 +771,19 @@ static void signAppBundle(
             throw ioe;
         }
 
+        // We cannot continue signing without identity
+        if (signingIdentity == null) {
+            return;
+        }
+
         // sign all runtime and frameworks
         Consumer<? super Path> signIdentifiedByPList = path -> {
             //noinspection ThrowableResultOfMethodCallIgnored
             if (toThrow.get() != null) return;
 
             try {
-                List<String> args = new ArrayList<>();
-                args.addAll(Arrays.asList("/usr/bin/codesign",
-                        "--timestamp",
-                        "--options", "runtime",
-                        "--force",
-                        "-s", signingIdentity, // sign with this key
-                        "--prefix", identifierPrefix,
-                        // use the identifier as a prefix
-                        "-vvvv"));
-
-                if (keyChain != null && !keyChain.isEmpty()) {
-                    args.add("--keychain");
-                    args.add(keyChain);
-                }
-                if (entitlements != null) {
-                    args.add("--entitlements");
-                    args.add(entitlements.toString());
-                }
-                args.add(path.toString());
+                List<String> args = getCodesignArgs(true, path, signingIdentity,
+                            identifierPrefix, entitlements, keyChain);
                 ProcessBuilder pb = new ProcessBuilder(args);
 
                 IOUtils.exec(pb);
@@ -794,29 +814,10 @@ static void signAppBundle(
         }
 
         // sign the app itself
-        List<String> args = new ArrayList<>();
-        args.addAll(Arrays.asList("/usr/bin/codesign",
-                "--timestamp",
-                "--options", "runtime",
-                "--force",
-                "-s", signingIdentity,
-                "--prefix", identifierPrefix,
-                "-vvvv"));
-
-        if (keyChain != null && !keyChain.isEmpty()) {
-            args.add("--keychain");
-            args.add(keyChain);
-        }
-
-        if (entitlements != null) {
-            args.add("--entitlements");
-            args.add(entitlements.toString());
-        }
-
-        args.add(appLocation.toString());
-
-        ProcessBuilder pb =
-                new ProcessBuilder(args.toArray(new String[args.size()]));
+        List<String> args = getCodesignArgs(true, appLocation, signingIdentity,
+                            identifierPrefix, entitlements, keyChain);
+        ProcessBuilder pb
+                = new ProcessBuilder(args.toArray(new String[args.size()]));
 
         IOUtils.exec(pb);
     }