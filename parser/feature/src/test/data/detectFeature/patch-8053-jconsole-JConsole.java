@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2004, 2013, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2004, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -483,9 +483,7 @@ void addVmid(final LocalVirtualMachine lvm, final boolean tile) {
             public void run() {
                 try {
                     addProxyClient(ProxyClient.getProxyClient(lvm), tile);
-                } catch (final SecurityException ex) {
-                    failed(ex, null, null, null);
-                } catch (final IOException ex) {
+                } catch (final SecurityException | IOException ex) {
                     failed(ex, null, null, null);
                 }
             }
@@ -502,11 +500,7 @@ public void run() {
                 try {
                     addProxyClient(ProxyClient.getProxyClient(url, userName, password),
                                    tile);
-                } catch (final MalformedURLException ex) {
-                    failed(ex, url, userName, password);
-                } catch (final SecurityException ex) {
-                    failed(ex, url, userName, password);
-                } catch (final IOException ex) {
+                } catch (final IOException | SecurityException ex) {
                     failed(ex, url, userName, password);
                 }
             }