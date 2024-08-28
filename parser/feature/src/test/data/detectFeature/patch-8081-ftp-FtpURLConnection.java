@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1994, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1994, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -510,17 +510,7 @@ public InputStream getInputStream() throws IOException {
                 is = new FtpInputStream(ftp, ftp.list(null));
                 msgh.add("content-type", "text/plain");
                 msgh.add("access-type", "directory");
-            } catch (IOException ex) {
-                FileNotFoundException fnfe = new FileNotFoundException(fullpath);
-                if (ftp != null) {
-                    try {
-                        ftp.close();
-                    } catch (IOException ioe) {
-                        fnfe.addSuppressed(ioe);
-                    }
-                }
-                throw fnfe;
-            } catch (FtpProtocolException ex2) {
+            } catch (IOException | FtpProtocolException ex) {
                 FileNotFoundException fnfe = new FileNotFoundException(fullpath);
                 if (ftp != null) {
                     try {