@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2013, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -20,6 +20,7 @@
  * or visit www.oracle.com if you need additional information or have any
  * questions.
  */
+import java.lang.ref.Reference;
 import java.util.Arrays;
 import java.util.Locale;
 import java.util.Objects;
@@ -317,6 +318,11 @@ public static void main(String... args) throws Exception {
             // has an inherited resource bundle.
             Logger foobaz = Logger.getLogger("foo.bar.baz");
 
+            // keep "foo.bar" logger alive until its child has
+            // been created. A child logger has a strong
+            // reference to its first parent.
+            Reference.reachabilityFence(foobar);
+
             // check that foobaz has no bundle set locally.
             if (foobaz.getResourceBundle() != null) {
                 throw new RuntimeException("Unexpected bundle: "