@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -44,9 +44,6 @@
 import jdk.internal.access.SharedSecrets;
 import sun.nio.cs.UTF_8;
 
-import java.lang.Character;             // for javadoc
-import java.lang.NullPointerException;  // for javadoc
-
 /**
  * Represents a Uniform Resource Identifier (URI) reference.
  *
@@ -3451,9 +3448,7 @@ private int parseIPv4Address(int start, int n) {
 
             try {
                 p = scanIPv4Address(start, n, false);
-            } catch (URISyntaxException x) {
-                return -1;
-            } catch (NumberFormatException nfe) {
+            } catch (URISyntaxException | NumberFormatException x) {
                 return -1;
             }
 