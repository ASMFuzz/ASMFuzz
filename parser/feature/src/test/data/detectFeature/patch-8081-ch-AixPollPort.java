@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2008, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2012 SAP SE. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -453,10 +453,9 @@ public void run() {
                     // process event
                     try {
                         ev.channel().onEvent(ev.events(), isPooledThread);
-                    } catch (Error x) {
-                        replaceMe = true; throw x;
-                    } catch (RuntimeException x) {
-                        replaceMe = true; throw x;
+                    } catch (Error | RuntimeException x) {
+                        replaceMe = true;
+                        throw x;
                     }
                 }
             } finally {