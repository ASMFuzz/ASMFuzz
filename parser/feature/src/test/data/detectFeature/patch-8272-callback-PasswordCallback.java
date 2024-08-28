@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,6 +25,11 @@
 
 package javax.security.auth.callback;
 
+import java.lang.ref.Cleaner;
+import java.util.Arrays;
+
+import jdk.internal.ref.CleanerFactory;
+
 /**
  * <p> Underlying security services instantiate and pass a
  * {@code PasswordCallback} to the {@code handle}
@@ -38,16 +43,20 @@ public class PasswordCallback implements Callback, java.io.Serializable {
     @java.io.Serial
     private static final long serialVersionUID = 2267422647454909926L;
 
+    private transient Cleaner.Cleanable cleanable;
+
     /**
      * @serial
      * @since 1.4
      */
-    private String prompt;
+    private final String prompt;
+
     /**
      * @serial
      * @since 1.4
      */
-    private boolean echoOn;
+    private final boolean echoOn;
+
     /**
      * @serial
      * @since 1.4
@@ -106,7 +115,19 @@ public boolean isEchoOn() {
      * @see #getPassword
      */
     public void setPassword(char[] password) {
+        // Cleanup the last buffered password copy.
+        if (cleanable != null) {
+            cleanable.clean();
+            cleanable = null;
+        }
+
+        // Set the retrieved password.
         this.inputPassword = (password == null ? null : password.clone());
+
+        if (this.inputPassword != null) {
+            cleanable = CleanerFactory.cleaner().register(
+                    this, cleanerFor(inputPassword));
+        }
     }
 
     /**
@@ -126,9 +147,16 @@ public char[] getPassword() {
      * Clear the retrieved password.
      */
     public void clearPassword() {
-        if (inputPassword != null) {
-            for (int i = 0; i < inputPassword.length; i++)
-                inputPassword[i] = ' ';
+        // Cleanup the last retrieved password copy.
+        if (cleanable != null) {
+            cleanable.clean();
+            cleanable = null;
         }
     }
+
+    private static Runnable cleanerFor(char[] password) {
+        return () -> {
+            Arrays.fill(password, ' ');
+        };
+    }
 }