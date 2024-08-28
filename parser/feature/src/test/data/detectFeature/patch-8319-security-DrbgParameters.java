@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,6 +25,7 @@
 
 package java.security;
 
+import java.util.Arrays;
 import java.util.Locale;
 import java.util.Objects;
 
@@ -403,7 +404,7 @@ private Instantiation(int strength, Capability capability,
         @Override
         public String toString() {
             // I don't care what personalizationString looks like
-            return strength + "," + capability + "," + personalizationString;
+            return strength + "," + capability + "," + Arrays.toString(personalizationString);
         }
     }
 