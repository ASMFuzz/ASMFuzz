@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -24,9 +24,9 @@
 /*
  * @test
  * @bug 8040211 8191404 8203872 8222980 8225435 8241082 8242010 8247432
- *      8258795
+ *      8258795 8267038
  * @summary Checks the IANA language subtag registry data update
- *          (LSR Revision: 2021-05-11) with Locale and Locale.LanguageRange
+ *          (LSR Revision: 2022-03-02) with Locale and Locale.LanguageRange
  *          class methods.
  * @run main LanguageSubtagRegistryTest
  */
@@ -44,15 +44,20 @@ public class LanguageSubtagRegistryTest {
     static boolean err = false;
 
     private static final String ACCEPT_LANGUAGE =
-        "Accept-Language: aam, adp, aog, aue, bcg, bic, blg, bpp, cey, cnp, cqu, csp, csx, dif, dmw, ehs, ema,"
-        + " en-gb-oed, gti, jks, kdz, koj, kru, kwq, kxe, kzk, lii, lmm, lsb, lsn, lsv, lvi, mtm,"
-        + " ngv, nns, ola, oyb, pat, phr, pnd, pub, scv, snz, sqx, suj, szy, taj, tjj, tjp, tvx,"
+        "Accept-Language: aam, adp, aeb, ajs, aog, aue, bcg, bic, bpp, cey, cnp, cqu, csp, csx, dif, dmw, dsz, ehs, ema,"
+        + " en-gb-oed, gti, iba, jks, kdz, kmb, koj, kru, ksp, kwq, kxe, kzk, lii, lmm, lsb, lsc, lsn, lsv, lsw, lvi, mtm,"
+        + " ngv, nns, ola, oyb, pat, phr, pnd, pub, rib, rnb, rsn, scv, snz, sqx, suj, szy, taj, tjj, tjp, tvx,"
         + " uss, uth, ysm, wkr;q=0.9, ar-hyw;q=0.8, yug;q=0.5, gfx;q=0.4";
     private static final List<LanguageRange> EXPECTED_RANGE_LIST = List.of(
             new LanguageRange("aam", 1.0),
             new LanguageRange("aas", 1.0),
             new LanguageRange("adp", 1.0),
             new LanguageRange("dz", 1.0),
+            new LanguageRange("aeb", 1.0),
+            new LanguageRange("ar-aeb", 1.0),
+            new LanguageRange("ajt", 1.0),
+            new LanguageRange("ajs", 1.0),
+            new LanguageRange("sgn-ajs", 1.0),
             new LanguageRange("aog", 1.0),
             new LanguageRange("myd", 1.0),
             new LanguageRange("aue", 1.0),
@@ -61,8 +66,6 @@ public class LanguageSubtagRegistryTest {
             new LanguageRange("bgm", 1.0),
             new LanguageRange("bic", 1.0),
             new LanguageRange("bir", 1.0),
-            new LanguageRange("blg", 1.0),
-            new LanguageRange("iba", 1.0),
             new LanguageRange("bpp", 1.0),
             new LanguageRange("nxu", 1.0),
             new LanguageRange("cey", 1.0),
@@ -78,6 +81,8 @@ public class LanguageSubtagRegistryTest {
             new LanguageRange("dit", 1.0),
             new LanguageRange("dmw", 1.0),
             new LanguageRange("xrq", 1.0),
+            new LanguageRange("dsz", 1.0),
+            new LanguageRange("sgn-dsz", 1.0),
             new LanguageRange("ehs", 1.0),
             new LanguageRange("sgn-ehs", 1.0),
             new LanguageRange("ema", 1.0),
@@ -86,14 +91,21 @@ public class LanguageSubtagRegistryTest {
             new LanguageRange("en-gb-oxendict", 1.0),
             new LanguageRange("gti", 1.0),
             new LanguageRange("nyc", 1.0),
+            new LanguageRange("iba", 1.0),
+            new LanguageRange("snb", 1.0),
+            new LanguageRange("blg", 1.0),
             new LanguageRange("jks", 1.0),
             new LanguageRange("sgn-jks", 1.0),
             new LanguageRange("kdz", 1.0),
             new LanguageRange("ncp", 1.0),
+            new LanguageRange("kmb", 1.0),
+            new LanguageRange("smd", 1.0),
             new LanguageRange("koj", 1.0),
             new LanguageRange("kwv", 1.0),
             new LanguageRange("kru", 1.0),
             new LanguageRange("kxl", 1.0),
+            new LanguageRange("ksp", 1.0),
+            new LanguageRange("lak", 1.0),
             new LanguageRange("kwq", 1.0),
             new LanguageRange("yam", 1.0),
             new LanguageRange("kxe", 1.0),
@@ -107,10 +119,14 @@ public class LanguageSubtagRegistryTest {
             new LanguageRange("rmx", 1.0),
             new LanguageRange("lsb", 1.0),
             new LanguageRange("sgn-lsb", 1.0),
+            new LanguageRange("lsc", 1.0),
+            new LanguageRange("sgn-lsc", 1.0),
             new LanguageRange("lsn", 1.0),
             new LanguageRange("sgn-lsn", 1.0),
             new LanguageRange("lsv", 1.0),
             new LanguageRange("sgn-lsv", 1.0),
+            new LanguageRange("lsw", 1.0),
+            new LanguageRange("sgn-lsw", 1.0),
             new LanguageRange("lvi", 1.0),
             new LanguageRange("mtm", 1.0),
             new LanguageRange("ymt", 1.0),
@@ -131,6 +147,12 @@ public class LanguageSubtagRegistryTest {
             new LanguageRange("pnd", 1.0),
             new LanguageRange("pub", 1.0),
             new LanguageRange("puz", 1.0),
+            new LanguageRange("rib", 1.0),
+            new LanguageRange("sgn-rib", 1.0),
+            new LanguageRange("rnb", 1.0),
+            new LanguageRange("sgn-rnb", 1.0),
+            new LanguageRange("rsn", 1.0),
+            new LanguageRange("sgn-rsn", 1.0),
             new LanguageRange("scv", 1.0),
             new LanguageRange("zir", 1.0),
             new LanguageRange("snz", 1.0),