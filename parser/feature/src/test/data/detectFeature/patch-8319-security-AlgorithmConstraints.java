@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2010, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -61,12 +61,12 @@ public interface AlgorithmConstraints {
      *     parameters
      *
      * @return true if the algorithm is permitted and can be used for all
-     *     of the specified cryptographic primitives
+     *     the specified cryptographic primitives
      *
      * @throws IllegalArgumentException if primitives or algorithm is null
      *     or empty
      */
-    public boolean permits(Set<CryptoPrimitive> primitives,
+    boolean permits(Set<CryptoPrimitive> primitives,
             String algorithm, AlgorithmParameters parameters);
 
     /**
@@ -78,13 +78,13 @@ public boolean permits(Set<CryptoPrimitive> primitives,
      * @param primitives a set of cryptographic primitives
      * @param key the key
      *
-     * @return true if the key can be used for all of the specified
+     * @return true if the key can be used for all the specified
      *     cryptographic primitives
      *
      * @throws IllegalArgumentException if primitives is null or empty,
      *     or the key is null
      */
-    public boolean permits(Set<CryptoPrimitive> primitives, Key key);
+    boolean permits(Set<CryptoPrimitive> primitives, Key key);
 
     /**
      * Determines whether an algorithm and the corresponding key are granted
@@ -96,13 +96,13 @@ public boolean permits(Set<CryptoPrimitive> primitives,
      * @param parameters the algorithm parameters, or null if no additional
      *     parameters
      *
-     * @return true if the key and the algorithm can be used for all of the
+     * @return true if the key and the algorithm can be used for all the
      *     specified cryptographic primitives
      *
      * @throws IllegalArgumentException if primitives or algorithm is null
      *     or empty, or the key is null
      */
-    public boolean permits(Set<CryptoPrimitive> primitives,
+    boolean permits(Set<CryptoPrimitive> primitives,
                 String algorithm, Key key, AlgorithmParameters parameters);
 
 }