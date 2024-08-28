@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -62,7 +62,7 @@ public class SSLEngineResult {
      * @author Brad R. Wetmore
      * @since 1.5
      */
-    public static enum Status {
+    public enum Status {
 
         /**
          * The {@code SSLEngine} was not able to unwrap the
@@ -97,7 +97,7 @@ public static enum Status {
          * {@code SSLEngine}, or the operation
          * could not be completed because it was already closed.
          */
-        CLOSED;
+        CLOSED
     }
 
     /**
@@ -107,7 +107,7 @@ public static enum Status {
      * @author Brad R. Wetmore
      * @since 1.5
      */
-    public static enum HandshakeStatus {
+    public enum HandshakeStatus {
 
         /**
          * The {@code SSLEngine} is not currently handshaking.
@@ -163,7 +163,7 @@ public static enum HandshakeStatus {
          *
          * @since   9
          */
-        NEED_UNWRAP_AGAIN;
+        NEED_UNWRAP_AGAIN
     }
 
 