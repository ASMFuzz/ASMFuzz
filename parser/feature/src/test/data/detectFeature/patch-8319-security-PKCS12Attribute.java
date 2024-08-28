@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2013, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2013, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -54,7 +54,7 @@ public final class PKCS12Attribute implements KeyStore.Entry.Attribute {
      * A string value is represented as the string itself.
      * A binary value is represented as a string of colon-separated
      * pairs of hexadecimal digits.
-     * Multi-valued attributes are represented as a comma-separated
+     * Multivalued attributes are represented as a comma-separated
      * list of values, enclosed in square brackets. See
      * {@link Arrays#toString(java.lang.Object[])}.
      * <p>
@@ -162,7 +162,7 @@ public String getName() {
      *      returned as a binary string of colon-separated pairs of
      *      hexadecimal digits.
      * </ul>
-     * Multi-valued attributes are represented as a comma-separated
+     * Multivalued attributes are represented as a comma-separated
      * list of values, enclosed in square brackets. See
      * {@link Arrays#toString(java.lang.Object[])}.
      *