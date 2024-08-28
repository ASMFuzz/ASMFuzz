@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1998, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1998, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -197,11 +197,14 @@ public static String decode(String s) {
             bb.clear();
             int ui = i;
             for (;;) {
-                assert (n - i >= 2);
+                if (n - i < 2) {
+                    throw new IllegalArgumentException("Malformed escape pair: " + s);
+                }
+
                 try {
                     bb.put(unescape(s, i));
-                } catch (NumberFormatException e) {
-                    throw new IllegalArgumentException();
+                } catch (NumberFormatException | IndexOutOfBoundsException e) {
+                    throw new IllegalArgumentException("Malformed escape pair: " + s);
                 }
                 i += 3;
                 if (i >= n)