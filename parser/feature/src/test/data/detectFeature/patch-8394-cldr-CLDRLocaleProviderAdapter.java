@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2012, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -238,6 +238,8 @@ public List<Locale> getCandidateLocales(String baseName, Locale locale) {
         return applyParentLocales(baseName, candidates);
     }
 
+    private static final Locale NB = Locale.forLanguageTag("nb");
+    private static final Locale NO = Locale.forLanguageTag("no");
     private List<Locale> applyParentLocales(String baseName, List<Locale> candidates) {
         // check irregular parents
         for (int i = 0; i < candidates.size(); i++) {
@@ -247,11 +249,15 @@ private List<Locale> applyParentLocales(String baseName, List<Locale> candidates
                 if (p != null &&
                     !candidates.get(i+1).equals(p)) {
                     List<Locale> applied = candidates.subList(0, i+1);
-                    if (applied.contains(p)) {
-                        // avoid circular recursion (could happen with nb/no case)
-                        continue;
+                    // Tweak for Norwegian locales, CLDR switched the canonical form of
+                    // Norwegian Bokmal language code from "nb" to "no" in CLDR 39
+                    // (https://unicode-org.atlassian.net/browse/CLDR-2698)
+                    if (p.equals(NB) || p.equals(NO)) {
+                        applied.add(NO);
+                        applied.add(Locale.ROOT);
+                    } else {
+                        applied.addAll(applyParentLocales(baseName, super.getCandidateLocales(baseName, p)));
                     }
-                    applied.addAll(applyParentLocales(baseName, super.getCandidateLocales(baseName, p)));
                     return applied;
                 }
             }