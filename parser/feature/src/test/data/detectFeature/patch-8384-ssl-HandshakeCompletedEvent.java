@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -32,7 +32,7 @@
 
 /**
  * This event indicates that an SSL handshake completed on a given
- * SSL connection.  All of the core information about that handshake's
+ * SSL connection.  All the core information about that handshake's
  * result is captured through an "SSLSession" object.  As a convenience,
  * this event class provides direct access to some important session
  * attributes.
@@ -52,7 +52,7 @@ public class HandshakeCompletedEvent extends EventObject
     @java.io.Serial
     private static final long serialVersionUID = 7914963744257769778L;
 
-    private transient SSLSession session;
+    private final transient SSLSession session;
 
     /**
      * Constructs a new HandshakeCompletedEvent.