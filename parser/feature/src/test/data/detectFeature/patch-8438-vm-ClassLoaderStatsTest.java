@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2014, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2014, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -171,12 +171,13 @@ class HiddenClass { }
 class TestClass {
     private static final String HCName = "HiddenClass.class";
     private static final String DIR = System.getProperty("test.classes");
+    public static final Class<?> hc;
 
     static {
         try {
-            // Create a hidden non-strong class
+            // Create a hidden non-strong class, keep reference in the case if GC happens
             byte[] klassBuf = readClassFile(DIR + File.separator + HCName);
-            Class<?> hc = defineHiddenClass(klassBuf);
+            hc = defineHiddenClass(klassBuf);
         } catch (Throwable e) {
             throw new RuntimeException("Unexpected exception in TestClass: " + e.getMessage());
         }