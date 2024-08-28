@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2004, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2004, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -92,8 +92,7 @@ public static String get(String key) {
         String def = props.getProperty(key);
         try {
             return System.getProperty(key, def);
-        } catch (IllegalArgumentException e) {
-        } catch (NullPointerException e) {
+        } catch (IllegalArgumentException | NullPointerException e) {
         }
         return null;
     }
@@ -115,8 +114,7 @@ public static Integer getInteger(String key, int defval) {
 
         try {
             val = System.getProperty(key, props.getProperty(key));
-        } catch (IllegalArgumentException e) {
-        } catch (NullPointerException e) {
+        } catch (IllegalArgumentException | NullPointerException e) {
         }
 
         if (val != null) {
@@ -144,8 +142,7 @@ public static Boolean getBoolean(String key) {
 
         try {
             val = System.getProperty(key, props.getProperty(key));
-        } catch (IllegalArgumentException e) {
-        } catch (NullPointerException e) {
+        } catch (IllegalArgumentException | NullPointerException e) {
         }
 
         if (val != null) {