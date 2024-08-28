@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2002, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2002, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -41,6 +41,13 @@
  * Methods are defined final to ensure that they are not accidentally
  * overridden in SSLSocketImpl.
  *
+ * There used to be a finalize() implementation that sent close_notify's, but
+ * decided that was not needed.  Not closing properly is more properly an
+ * error condition that should be avoided.  Applications should close sockets
+ * and not rely on garbage collection.
+ *
+ * The underlying native resources are handled by the Socket Cleaner.
+ *
  * @see javax.net.ssl.SSLSocket
  * @see SSLSocketImpl
  */
@@ -262,37 +269,6 @@ public boolean isOutputShutdown() {
         }
     }
 
-    /**
-     * Ensures that the SSL connection is closed down as cleanly
-     * as possible, in case the application forgets to do so.
-     * This allows SSL connections to be implicitly reclaimed,
-     * rather than forcing them to be explicitly reclaimed at
-     * the penalty of prematurly killing SSL sessions.
-     */
-    @Override
-    @SuppressWarnings("removal")
-    protected final void finalize() throws Throwable {
-        try {
-            close();
-        } catch (IOException e1) {
-            try {
-                if (self == this) {
-                    super.close();
-                }
-            } catch (IOException e2) {
-                // ignore
-            }
-        } finally {
-            // We called close on the underlying socket above to
-            // make doubly sure all resources got released.  We
-            // don't finalize self in the case of overlain sockets,
-            // that's a different object which the GC will finalize
-            // separately.
-
-            super.finalize();
-        }
-    }
-
     //
     // GET ADDRESS METHODS
     //