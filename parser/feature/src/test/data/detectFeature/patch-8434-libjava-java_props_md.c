@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1998, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1998, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -63,19 +63,19 @@ static boolean SetupI18nProps(LCID lcid, char** language, char** script, char**
 static char *
 getEncodingInternal(LCID lcid)
 {
-    int codepage;
+    int codepage = 0;
     char * ret = malloc(16);
     if (ret == NULL) {
         return NULL;
     }
 
-    if (GetLocaleInfo(lcid,
+    if (lcid == 0) { // for sun.jnu.encoding
+        codepage = GetACP();
+        _itoa_s(codepage, ret + 2, 14, 10);
+    } else if (GetLocaleInfo(lcid,
                       LOCALE_IDEFAULTANSICODEPAGE,
-                      ret+2, 14) == 0) {
-        codepage = 1252;
-        strcpy(ret+2, "1252");
-    } else {
-        codepage = atoi(ret+2);
+                      ret + 2, 14) != 0) {
+        codepage = atoi(ret + 2);
     }
 
     switch (codepage) {
@@ -660,7 +660,6 @@ GetJavaProperties(JNIEnv* env)
          * (which is a Windows LCID value),
          */
         LCID userDefaultLCID = GetUserDefaultLCID();
-        LCID systemDefaultLCID = GetSystemDefaultLCID();
         LANGID userDefaultUILang = GetUserDefaultUILanguage();
         LCID userDefaultUILCID = MAKELCID(userDefaultUILang, SORTIDFROMLCID(userDefaultLCID));
 
@@ -693,7 +692,10 @@ GetJavaProperties(JNIEnv* env)
                            &sprops.display_variant,
                            &display_encoding);
 
-            sprops.sun_jnu_encoding = getEncodingInternal(systemDefaultLCID);
+            sprops.sun_jnu_encoding = getEncodingInternal(0);
+            if (sprops.sun_jnu_encoding == NULL) {
+                sprops.sun_jnu_encoding = "UTF-8";
+            }
             if (LANGIDFROMLCID(userDefaultLCID) == 0x0c04 && majorVersion == 6) {
                 // MS claims "Vista has built-in support for HKSCS-2004.
                 // All of the HKSCS-2004 characters have Unicode 4.1.