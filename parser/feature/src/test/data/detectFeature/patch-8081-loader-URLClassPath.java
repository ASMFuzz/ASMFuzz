@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -866,12 +866,7 @@ Resource checkResource(final String name, boolean check,
                 if (check) {
                     URLClassPath.check(url);
                 }
-            } catch (MalformedURLException e) {
-                return null;
-                // throw new IllegalArgumentException("name");
-            } catch (IOException e) {
-                return null;
-            } catch (@SuppressWarnings("removal") AccessControlException e) {
+            } catch (@SuppressWarnings("removal") AccessControlException | IOException e) {
                 return null;
             }
 
@@ -1026,9 +1021,7 @@ public JarLoader run() throws IOException {
                             /* put it in the global hashtable */
                             lmap.put(urlNoFragString, newLoader);
                         }
-                    } catch (PrivilegedActionException pae) {
-                        continue;
-                    } catch (MalformedURLException e) {
+                    } catch (PrivilegedActionException | MalformedURLException e) {
                         continue;
                     }
 