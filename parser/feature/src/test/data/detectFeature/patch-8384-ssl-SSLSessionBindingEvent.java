@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -34,7 +34,7 @@
  * When a listener object is bound or unbound to an SSLSession by
  * {@link SSLSession#putValue(String, Object)}
  * or {@link SSLSession#removeValue(String)}, objects which
- * implement the SSLSessionBindingListener will be receive an
+ * implement the SSLSessionBindingListener will receive an
  * event of this type.  The event's <code>name</code> field is the
  * key in which the listener is being bound or unbound.
  *
@@ -55,7 +55,7 @@ class SSLSessionBindingEvent
     /**
      * @serial The name to which the object is being bound or unbound
      */
-    private String name;
+    private final String name;
 
     /**
      * Constructs a new SSLSessionBindingEvent.