@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -38,7 +38,7 @@
 
 
 /**
- * @systemProperty jdk.tls.server.enableSessionTicketExtension} determines if the
+ * {@systemProperty jdk.tls.server.enableSessionTicketExtension} determines if the
  * server will provide stateless session tickets, if the client supports it,
  * as described in RFC 5077 and RFC 8446.  a stateless session ticket
  * contains the encrypted server's state which saves server resources.
@@ -47,7 +47,7 @@
  * client will send an extension in the ClientHello in the pre-TLS 1.3.
  * This extension allows the client to accept the server's session state for
  * Server Side stateless resumption (RFC 5077).  Setting the property to
- * "true" turns this on, by default it is false.  For TLS 1.3, the system
+ * "false" turns this off, by default it is true.  For TLS 1.3, the system
  * property is not needed as this support is part of the spec.
  *
  * {@systemProperty jdk.tls.server.sessionTicketTimeout} determines how long