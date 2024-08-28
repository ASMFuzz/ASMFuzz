@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -202,9 +202,7 @@ public void read(Reader policy)
                 DomainEntry de = parseDomainEntry();
                 if (de != null) {
                     String domainName = de.getName();
-                    if (!domainEntries.containsKey(domainName)) {
-                        domainEntries.put(domainName, de);
-                    } else {
+                    if (domainEntries.putIfAbsent(domainName, de) != null) {
                         LocalizedMessage localizedMsg = new LocalizedMessage(
                             "duplicate.keystore.domain.name");
                         Object[] source = {domainName};