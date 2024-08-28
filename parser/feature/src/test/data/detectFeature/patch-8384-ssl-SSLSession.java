@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -70,7 +70,7 @@ public interface SSLSession {
      *
      * @return the Session identifier
      */
-    public byte[] getId();
+    byte[] getId();
 
 
     /**
@@ -91,7 +91,7 @@ public interface SSLSession {
      * @return the session context used for this session, or null
      * if the context is unavailable.
      */
-    public SSLSessionContext getSessionContext();
+    SSLSessionContext getSessionContext();
 
 
     /**
@@ -100,7 +100,7 @@ public interface SSLSession {
      *
      * @return the time this Session was created
      */
-    public long getCreationTime();
+    long getCreationTime();
 
 
     /**
@@ -119,7 +119,7 @@ public interface SSLSession {
      *
      * @return the last time this Session was accessed
      */
-    public long getLastAccessedTime();
+    long getLastAccessedTime();
 
 
     /**
@@ -132,7 +132,7 @@ public interface SSLSession {
      *
      * @see #isValid()
      */
-    public void invalidate();
+    void invalidate();
 
 
     /**
@@ -144,7 +144,7 @@ public interface SSLSession {
      *
      * @since 1.5
      */
-    public boolean isValid();
+    boolean isValid();
 
 
     /**
@@ -166,7 +166,7 @@ public interface SSLSession {
      * @param value the data object to be bound. This may not be null.
      * @throws IllegalArgumentException if either argument is null.
      */
-    public void putValue(String name, Object value);
+    void putValue(String name, Object value);
 
 
     /**
@@ -181,7 +181,7 @@ public interface SSLSession {
      *          not exist.
      * @throws IllegalArgumentException if the argument is null.
      */
-    public Object getValue(String name);
+    Object getValue(String name);
 
 
     /**
@@ -198,7 +198,7 @@ public interface SSLSession {
      *          across different access control contexts
      * @throws IllegalArgumentException if the argument is null.
      */
-    public void removeValue(String name);
+    void removeValue(String name);
 
 
     /**
@@ -211,7 +211,7 @@ public interface SSLSession {
      * @return a non-null (possibly empty) array of names of the objects
      *  bound to this Session.
      */
-    public String [] getValueNames();
+    String [] getValueNames();
 
     /**
      * Returns the identity of the peer which was established as part
@@ -231,7 +231,7 @@ public interface SSLSession {
      *          been verified
      * @see #getPeerPrincipal()
      */
-    public java.security.cert.Certificate [] getPeerCertificates()
+    java.security.cert.Certificate [] getPeerCertificates()
             throws SSLPeerUnverifiedException;
 
     /**
@@ -254,7 +254,7 @@ public interface SSLSession {
      *
      * @see #getLocalPrincipal()
      */
-    public java.security.cert.Certificate [] getLocalCertificates();
+    java.security.cert.Certificate [] getLocalCertificates();
 
     /**
      * Returns the identity of the peer which was identified as part
@@ -291,7 +291,7 @@ public interface SSLSession {
      */
     @SuppressWarnings("removal")
     @Deprecated(since="9", forRemoval=true)
-    public default javax.security.cert.X509Certificate[]
+    default javax.security.cert.X509Certificate[]
             getPeerCertificateChain() throws SSLPeerUnverifiedException {
         throw new UnsupportedOperationException(
              "This method is deprecated and marked for removal. Use the " +
@@ -314,7 +314,7 @@ public interface SSLSession {
      *
      * @since 1.5
      */
-    public Principal getPeerPrincipal()
+    Principal getPeerPrincipal()
             throws SSLPeerUnverifiedException;
 
     /**
@@ -330,7 +330,7 @@ public Principal getPeerPrincipal()
      *
      * @since 1.5
      */
-    public Principal getLocalPrincipal();
+    Principal getLocalPrincipal();
 
     /**
      * Returns the name of the SSL cipher suite which is used for all
@@ -342,7 +342,7 @@ public Principal getPeerPrincipal()
      *
      * @return the name of the session's cipher suite
      */
-    public String getCipherSuite();
+    String getCipherSuite();
 
     /**
      * Returns the standard name of the protocol used for all
@@ -353,7 +353,7 @@ public Principal getPeerPrincipal()
      * @return the standard name of the protocol used for all
      * connections in the session.
      */
-    public String getProtocol();
+    String getProtocol();
 
     /**
      * Returns the host name of the peer in this session.
@@ -373,7 +373,7 @@ public Principal getPeerPrincipal()
      * @return  the host name of the peer host, or null if no information
      *          is available.
      */
-    public String getPeerHost();
+    String getPeerHost();
 
     /**
      * Returns the port number of the peer in this session.
@@ -390,7 +390,7 @@ public Principal getPeerPrincipal()
      *
      * @since 1.5
      */
-    public int getPeerPort();
+    int getPeerPort();
 
     /**
      * Gets the current size of the largest SSL/TLS/DTLS packet that is
@@ -409,7 +409,7 @@ public Principal getPeerPrincipal()
      *
      * @since 1.5
      */
-    public int getPacketBufferSize();
+    int getPacketBufferSize();
 
 
     /**
@@ -428,5 +428,5 @@ public Principal getPeerPrincipal()
      *
      * @since 1.5
      */
-    public int getApplicationBufferSize();
+    int getApplicationBufferSize();
 }