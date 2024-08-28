@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2017, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2017, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -156,15 +156,15 @@ public static void main(String[] args) throws Throwable {
         // (w/ different formats)
         checkWeakGenKeyPair("x", "-keyalg RSA -sigalg SHA1withRSA", "SHA1withRSA");
         checkWeakGenKeyPair("y", "-keyalg RSA -keysize 1024", "1024-bit RSA key");
-        checkWeakGenKeyPair("z", "-keyalg RSA", null);
+        checkWeakGenKeyPair("z", "-keyalg RSA", "nowarn");
 
         kt("-list")
                 .shouldContain("Warning:")
-                .shouldMatch("<x>.*SHA1withRSA.*will be disabled")
+                .shouldMatch("<x>.*SHA1withRSA.*considered a security risk")
                 .shouldMatch("<y>.*1024-bit RSA key.*will be disabled");
         kt("-list -v")
                 .shouldContain("Warning:")
-                .shouldMatch("<x>.*SHA1withRSA.*will be disabled")
+                .shouldMatch("<x>.*SHA1withRSA.*considered a security risk")
                 .shouldContain("SHA1withRSA (weak)")
                 .shouldMatch("<y>.*1024-bit RSA key.*will be disabled")
                 .shouldContain("1024-bit RSA key (weak)");
@@ -173,32 +173,32 @@ public static void main(String[] args) throws Throwable {
         // or -list or -exportcert
 
         // -certreq, -printcertreq, -gencert
-        checkWeakCertReq("x", "", null);
+        checkWeakCertReq("x", "", "nowarn");
         gencert("z-x", "")
                 .shouldNotContain("Warning"); // new sigalg is not weak
         gencert("z-x", "-sigalg SHA1withRSA")
                 .shouldContain("Warning:")
-                .shouldMatch("The generated certificate.*SHA1withRSA.*will be disabled");
+                .shouldMatch("The generated certificate.*SHA1withRSA.*considered a security risk");
 
         checkWeakCertReq("x", "-sigalg SHA1withRSA", "SHA1withRSA");
         gencert("z-x", "")
                 .shouldContain("Warning:")
-                .shouldMatch("The certificate request.*SHA1withRSA.*will be disabled");
+                .shouldMatch("The certificate request.*SHA1withRSA.*considered a security risk");
         gencert("z-x", "-sigalg SHA1withRSA")
                 .shouldContain("Warning:")
-                .shouldMatch("The certificate request.*SHA1withRSA.*will be disabled")
-                .shouldMatch("The generated certificate.*SHA1withRSA.*will be disabled");
+                .shouldMatch("The certificate request.*SHA1withRSA.*considered a security risk")
+                .shouldMatch("The generated certificate.*SHA1withRSA.*considered a security risk");
 
         checkWeakCertReq("y", "", "1024-bit RSA key");
         gencert("z-y", "")
                 .shouldContain("Warning:")
                 .shouldMatch("The certificate request.*1024-bit RSA key.*will be disabled")
                 .shouldMatch("The generated certificate.*1024-bit RSA key.*will be disabled");
 
-        checkWeakCertReq("z", "", null);
+        checkWeakCertReq("z", "", "nowarn");
         gencert("x-z", "")
                 .shouldContain("Warning:")
-                .shouldMatch("The issuer.*SHA1withRSA.*will be disabled");
+                .shouldMatch("The issuer.*SHA1withRSA.*considered a security risk");
 
         // but the new cert is not weak
         kt("-printcert -file x-z.cert")
@@ -210,10 +210,10 @@ public static void main(String[] args) throws Throwable {
                 .shouldMatch("The issuer.*1024-bit RSA key.*will be disabled");
 
         // -gencrl, -printcrl
-        checkWeakGenCRL("x", "", null);
+        checkWeakGenCRL("x", "", "nowarn");
         checkWeakGenCRL("x", "-sigalg SHA1withRSA", "SHA1withRSA");
         checkWeakGenCRL("y", "", "1024-bit RSA key");
-        checkWeakGenCRL("z", "", null);
+        checkWeakGenCRL("z", "", "nowarn");
 
         kt("-delete -alias y");
         kt("-printcrl -file y.crl")
@@ -730,63 +730,114 @@ static void checkWeakGenKeyPair(
             String alias, String options, String bad) {
 
         OutputAnalyzer oa = genkeypair(alias, options);
-        if (bad == null) {
-            oa.shouldNotContain("Warning");
-        } else {
-            oa.shouldContain("Warning")
-                    .shouldMatch("The generated certificate.*" + bad + ".*will be disabled");
+        switch (bad) {
+            case "nowarn":
+                oa.shouldNotContain("Warning");
+                break;
+            case "SHA1withRSA":
+                oa.shouldContain("Warning")
+                        .shouldMatch("The generated certificate.*" + bad + ".*considered a security risk");
+                break;
+            case "1024-bit RSA key":
+                oa.shouldContain("Warning")
+                        .shouldMatch("The generated certificate.*" + bad + ".*will be disabled");
+                break;
         }
 
         oa = kt("-exportcert -alias " + alias + " -file " + alias + ".cert");
-        if (bad == null) {
-            oa.shouldNotContain("Warning");
-        } else {
-            oa.shouldContain("Warning")
-                    .shouldMatch("The certificate.*" + bad + ".*will be disabled");
+        switch (bad) {
+            case "nowarn":
+                oa.shouldNotContain("Warning");
+                break;
+            case "SHA1withRSA":
+                oa.shouldContain("Warning")
+                        .shouldMatch("The certificate.*" + bad + ".*considered a security risk");
+                break;
+            case "1024-bit RSA key":
+                oa.shouldContain("Warning")
+                        .shouldMatch("The certificate.*" + bad + ".*will be disabled");
+                break;
         }
 
         oa = kt("-exportcert -rfc -alias " + alias + " -file " + alias + ".cert");
-        if (bad == null) {
-            oa.shouldNotContain("Warning");
-        } else {
-            oa.shouldContain("Warning")
-                    .shouldMatch("The certificate.*" + bad + ".*will be disabled");
+        switch (bad) {
+            case "nowarn":
+                oa.shouldNotContain("Warning");
+                break;
+            case "SHA1withRSA":
+                oa.shouldContain("Warning")
+                        .shouldMatch("The certificate.*" + bad + ".*considered a security risk");
+                break;
+            case "1024-bit RSA key":
+                oa.shouldContain("Warning")
+                        .shouldMatch("The certificate.*" + bad + ".*will be disabled");
+                break;
         }
 
         oa = kt("-printcert -rfc -file " + alias + ".cert");
-        if (bad == null) {
-            oa.shouldNotContain("Warning");
-        } else {
-            oa.shouldContain("Warning")
-                    .shouldMatch("The certificate.*" + bad + ".*will be disabled");
+        switch (bad) {
+            case "nowarn":
+                oa.shouldNotContain("Warning");
+                break;
+            case "SHA1withRSA":
+                oa.shouldContain("Warning")
+                        .shouldMatch("The certificate.*" + bad + ".*considered a security risk");
+                break;
+            case "1024-bit RSA key":
+                oa.shouldContain("Warning")
+                        .shouldMatch("The certificate.*" + bad + ".*will be disabled");
+                break;
         }
 
         oa = kt("-list -alias " + alias);
-        if (bad == null) {
-            oa.shouldNotContain("Warning");
-        } else {
-            oa.shouldContain("Warning")
-                    .shouldMatch("The certificate.*" + bad + ".*will be disabled");
+        switch (bad) {
+            case "nowarn":
+                oa.shouldNotContain("Warning");
+                break;
+            case "SHA1withRSA":
+                oa.shouldContain("Warning")
+                        .shouldMatch("The certificate.*" + bad + ".*considered a security risk");
+                break;
+            case "1024-bit RSA key":
+                oa.shouldContain("Warning")
+                        .shouldMatch("The certificate.*" + bad + ".*will be disabled");
+                break;
         }
 
         // With cert content
 
         oa = kt("-printcert -file " + alias + ".cert");
-        if (bad == null) {
-            oa.shouldNotContain("Warning");
-        } else {
-            oa.shouldContain("Warning")
-                    .shouldContain(bad + " (weak)")
-                    .shouldMatch("The certificate.*" + bad + ".*will be disabled");
+        switch (bad) {
+            case "nowarn":
+                oa.shouldNotContain("Warning");
+                break;
+            case "SHA1withRSA":
+                oa.shouldContain("Warning")
+                        .shouldContain(bad + " (weak)")
+                        .shouldMatch("The certificate.*" + bad + ".*considered a security risk");
+                break;
+            case "1024-bit RSA key":
+                oa.shouldContain("Warning")
+                        .shouldContain(bad + " (weak)")
+                        .shouldMatch("The certificate.*" + bad + ".*will be disabled");
+                break;
         }
 
         oa = kt("-list -v -alias " + alias);
-        if (bad == null) {
-            oa.shouldNotContain("Warning");
-        } else {
-            oa.shouldContain("Warning")
-                    .shouldContain(bad + " (weak)")
-                    .shouldMatch("The certificate.*" + bad + ".*will be disabled");
+        switch (bad) {
+            case "nowarn":
+                oa.shouldNotContain("Warning");
+                break;
+            case "SHA1withRSA":
+                oa.shouldContain("Warning")
+                        .shouldContain(bad + " (weak)")
+                        .shouldMatch("The certificate.*" + bad + ".*considered a security risk");
+                break;
+            case "1024-bit RSA key":
+                oa.shouldContain("Warning")
+                        .shouldContain(bad + " (weak)")
+                        .shouldMatch("The certificate.*" + bad + ".*will be disabled");
+                break;
         }
     }
 
@@ -795,45 +846,76 @@ static void checkWeakGenCRL(String alias, String options, String bad) {
 
         OutputAnalyzer oa = kt("-gencrl -alias " + alias
                 + " -id 1 -file " + alias + ".crl " + options);
-        if (bad == null) {
-            oa.shouldNotContain("Warning");
-        } else {
-            oa.shouldContain("Warning")
-                    .shouldMatch("The generated CRL.*" + bad + ".*will be disabled");
+        switch (bad) {
+            case "nowarn":
+                oa.shouldNotContain("Warning");
+                break;
+            case "SHA1withRSA":
+                oa.shouldContain("Warning")
+                        .shouldMatch("The generated CRL.*" + bad + ".*considered a security risk");
+                break;
+            case "1024-bit RSA key":
+                oa.shouldContain("Warning")
+                        .shouldMatch("The generated CRL.*" + bad + ".*will be disabled");
+                break;
         }
 
         oa = kt("-printcrl -file " + alias + ".crl");
-        if (bad == null) {
-            oa.shouldNotContain("Warning")
-                    .shouldContain("Verified by " + alias + " in keystore")
-                    .shouldNotContain("(weak");
-        } else {
-            oa.shouldContain("Warning:")
-                    .shouldMatch("The CRL.*" + bad + ".*will be disabled")
-                    .shouldContain("Verified by " + alias + " in keystore")
-                    .shouldContain(bad + " (weak)");
+        switch (bad) {
+            case "nowarn":
+                oa.shouldNotContain("Warning")
+                        .shouldContain("Verified by " + alias + " in keystore")
+                        .shouldNotContain("(weak");
+                break;
+            case "SHA1withRSA":
+                oa.shouldContain("Warning")
+                        .shouldMatch("The CRL.*" + bad + ".*considered a security risk")
+                        .shouldContain("Verified by " + alias + " in keystore")
+                        .shouldContain(bad + " (weak)");
+                break;
+            case "1024-bit RSA key":
+                oa.shouldContain("Warning")
+                        .shouldMatch("The CRL.*" + bad + ".*will be disabled")
+                        .shouldContain("Verified by " + alias + " in keystore")
+                        .shouldContain(bad + " (weak)");
+                break;
         }
     }
 
     static void checkWeakCertReq(
             String alias, String options, String bad) {
 
         OutputAnalyzer oa = certreq(alias, options);
-        if (bad == null) {
-            oa.shouldNotContain("Warning");
-        } else {
-            oa.shouldContain("Warning")
-                    .shouldMatch("The generated certificate request.*" + bad + ".*will be disabled");
+        switch (bad) {
+            case "nowarn":
+                oa.shouldNotContain("Warning");
+                break;
+            case "SHA1withRSA":
+                oa.shouldContain("Warning")
+                        .shouldMatch("The generated certificate request.*" + bad + ".*considered a security risk");
+                break;
+            case "1024-bit RSA key":
+                oa.shouldContain("Warning")
+                        .shouldMatch("The generated certificate request.*" + bad + ".*will be disabled");
+                break;
         }
 
         oa = kt("-printcertreq -file " + alias + ".req");
-        if (bad == null) {
-            oa.shouldNotContain("Warning")
-                    .shouldNotContain("(weak)");
-        } else {
-            oa.shouldContain("Warning")
-                    .shouldMatch("The certificate request.*" + bad + ".*will be disabled")
-                    .shouldContain(bad + " (weak)");
+        switch (bad) {
+            case "nowarn":
+                oa.shouldNotContain("Warning")
+                        .shouldNotContain("(weak)");
+                break;
+            case "SHA1withRSA":
+                oa.shouldContain("Warning")
+                        .shouldMatch("The certificate request.*" + bad + ".*considered a security risk")
+                        .shouldContain(bad + " (weak)");
+                break;
+            case "1024-bit RSA key":
+                oa.shouldContain("Warning")
+                        .shouldMatch("The certificate request.*" + bad + ".*will be disabled")
+                        .shouldContain(bad + " (weak)");
+                break;
         }
     }
 