@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2014, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2014, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -1654,11 +1654,11 @@ public InputStream getResourceAsStream(String name) throws IOException {
             if (caller != this && caller != Object.class.getModule()) {
                 String pn = Resources.toPackageName(name);
                 if (getPackages().contains(pn)) {
-                    if (caller == null && !isOpen(pn)) {
-                        // no caller, package not open
-                        return null;
-                    }
-                    if (!isOpen(pn, caller)) {
+                    if (caller == null) {
+                        if (!isOpen(pn)) {
+                            return null;
+                        }
+                    } else if (!isOpen(pn, caller)) {
                         // package not open to caller
                         return null;
                     }