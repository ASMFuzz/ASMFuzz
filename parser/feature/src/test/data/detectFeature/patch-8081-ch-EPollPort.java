@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2008, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2008, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -34,7 +34,6 @@
 import static sun.nio.ch.EPoll.EPOLLIN;
 import static sun.nio.ch.EPoll.EPOLLONESHOT;
 import static sun.nio.ch.EPoll.EPOLL_CTL_ADD;
-import static sun.nio.ch.EPoll.EPOLL_CTL_DEL;
 import static sun.nio.ch.EPoll.EPOLL_CTL_MOD;
 
 
@@ -304,10 +303,9 @@ public void run() {
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