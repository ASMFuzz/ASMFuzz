@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2001, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -47,7 +47,7 @@
 //@@@ Note: this class is not in public API and access to adjacency list is
 //@@@ intended for debugging/replay of Sun PKIX CertPathBuilder implementation.
 
-public class SunCertPathBuilderResult extends PKIXCertPathBuilderResult {
+public final class SunCertPathBuilderResult extends PKIXCertPathBuilderResult {
 
     private static final Debug debug = Debug.getInstance("certpath");
 