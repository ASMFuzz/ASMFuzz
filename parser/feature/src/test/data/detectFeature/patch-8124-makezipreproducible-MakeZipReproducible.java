@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2021, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -204,6 +204,10 @@ void addEntry(ZipOutputStream zos, ZipEntry entry, InputStream entryInputStream)
             entry.setTimeLocal(timestamp);
         }
 
+        // Ensure "extra" field is not set from original ZipEntry info that may be not deterministic
+        // eg.may contain specific UID/GID
+        entry.setExtra(null);
+
         zos.putNextEntry(entry);
         if (entry.getSize() > 0 && entryInputStream != null) {
             entryInputStream.transferTo(zos);