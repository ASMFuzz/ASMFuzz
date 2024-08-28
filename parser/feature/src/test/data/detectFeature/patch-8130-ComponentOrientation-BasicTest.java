@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1998, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1998, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -94,16 +94,16 @@ static void TestLocale() {
         ComponentOrientation orient = ComponentOrientation.getOrientation(Locale.US);
         Assert(orient == ComponentOrientation.LEFT_TO_RIGHT, "US == LEFT_TO_RIGHT");
 
-        orient = ComponentOrientation.getOrientation(new Locale("iw", ""));
+        orient = ComponentOrientation.getOrientation(Locale.of("iw"));
         Assert(orient == ComponentOrientation.RIGHT_TO_LEFT, "iw == RIGHT_TO_LEFT");
 
-        orient = ComponentOrientation.getOrientation(new Locale("ar", ""));
+        orient = ComponentOrientation.getOrientation(Locale.of("ar"));
         Assert(orient == ComponentOrientation.RIGHT_TO_LEFT, "ar == RIGHT_TO_LEFT");
 
-        orient = ComponentOrientation.getOrientation(new Locale("he", ""));
+        orient = ComponentOrientation.getOrientation(Locale.of("he"));
         Assert(orient == ComponentOrientation.RIGHT_TO_LEFT, "he == RIGHT_TO_LEFT");
 
-        orient = ComponentOrientation.getOrientation(new Locale("yi", ""));
+        orient = ComponentOrientation.getOrientation(Locale.of("yi"));
         Assert(orient == ComponentOrientation.RIGHT_TO_LEFT, "yi == RIGHT_TO_LEFT");
 
         System.out.println("  } Pass");
@@ -119,8 +119,8 @@ static void TestBundle() {
 
         // This will fall back to the default locale's bundle or root bundle
         ResourceBundle rb = ResourceBundle.getBundle("TestBundle",
-                                                        new Locale("et", ""));
-        if (rb.getLocale().getLanguage().equals(new Locale("iw").getLanguage())) {
+                                                        Locale.of("et"));
+        if (rb.getLocale().getLanguage().equals(Locale.of("iw").getLanguage())) {
             assertEquals(rb, ComponentOrientation.RIGHT_TO_LEFT, "et == RIGHT_TO_LEFT" );
         } else if (rb.getLocale().getLanguage() == "es") {
             assertEquals(rb, ComponentOrientation.LEFT_TO_RIGHT, "et == LEFT_TO_RIGHT" );
@@ -130,19 +130,19 @@ static void TestBundle() {
 
         // We have actual bundles for "es" and "iw", so it should just fetch
         // the orientation object out of them
-        rb = ResourceBundle.getBundle("TestBundle",new Locale("es", ""));
+        rb = ResourceBundle.getBundle("TestBundle",Locale.of("es"));
         assertEquals(rb, ComponentOrientation.LEFT_TO_RIGHT, "es == LEFT_TO_RIGHT" );
 
-        rb = ResourceBundle.getBundle("TestBundle", new Locale("iw", "IL"));
+        rb = ResourceBundle.getBundle("TestBundle", Locale.of("iw", "IL"));
         assertEquals(rb, ComponentOrientation.RIGHT_TO_LEFT, "iw == RIGHT_TO_LEFT" );
 
         // Test with "he" locale. This should load TestBundle_iw and fetch the orientation from there
-        rb = ResourceBundle.getBundle("TestBundle", new Locale("he", "IL"));
+        rb = ResourceBundle.getBundle("TestBundle", Locale.of("he", "IL"));
         assertEquals(rb, ComponentOrientation.RIGHT_TO_LEFT, "he == RIGHT_TO_LEFT" );
 
         // This bundle has no orientation setting at all, so we should get
         // the system's default orientation for Arabic
-        rb = ResourceBundle.getBundle("TestBundle1", new Locale("ar", ""));
+        rb = ResourceBundle.getBundle("TestBundle1", Locale.of("ar"));
         assertEquals(rb, ComponentOrientation.RIGHT_TO_LEFT, "ar == RIGHT_TO_LEFT" );
 
         System.out.println("  } Pass");