@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,6 +25,7 @@
 
 package com.sun.jndi.ldap;
 
+import java.lang.invoke.VarHandle;
 import java.security.AccessControlContext;
 import java.security.AccessController;
 import java.security.PrivilegedActionException;
@@ -34,6 +35,7 @@
 import javax.naming.directory.*;
 import javax.naming.ldap.Control;
 import javax.naming.spi.*;
+import java.lang.ref.Reference;
 
 import com.sun.jndi.toolkit.ctx.Continuation;
 
@@ -54,57 +56,71 @@ final class LdapBindingEnumeration
     protected Binding
       createItem(String dn, Attributes attrs, Vector<Control> respCtls)
         throws NamingException {
+        try {
+            Object obj = null;
+            String atom = getAtom(dn);
+            LdapCtx homeCtx = getHomeCtx();
 
-        Object obj = null;
-        String atom = getAtom(dn);
-
-        if (attrs.get(Obj.JAVA_ATTRIBUTES[Obj.CLASSNAME]) != null) {
-            // serialized object or object reference
-            try {
-                PrivilegedExceptionAction<Object> pa = () -> Obj.decodeObject(attrs);
-                obj = AccessController.doPrivileged(pa, acc);
-            } catch (PrivilegedActionException e) {
-                throw (NamingException)e.getException();
+            if (attrs.get(Obj.JAVA_ATTRIBUTES[Obj.CLASSNAME]) != null) {
+                // serialized object or object reference
+                try {
+                    PrivilegedExceptionAction<Object> pa = () -> Obj.decodeObject(attrs);
+                    obj = AccessController.doPrivileged(pa, acc);
+                } catch (PrivilegedActionException e) {
+                    throw (NamingException) e.getException();
+                }
+            }
+            if (obj == null) {
+                // DirContext object
+                obj = new LdapCtx(homeCtx, dn);
             }
-        }
-        if (obj == null) {
-            // DirContext object
-            obj = new LdapCtx(homeCtx, dn);
-        }
 
-        CompositeName cn = new CompositeName();
-        cn.add(atom);
+            CompositeName cn = new CompositeName();
+            cn.add(atom);
 
-        try {
-            obj = DirectoryManager.getObjectInstance(obj, cn, homeCtx,
-                homeCtx.envprops, attrs);
+            try {
+                obj = DirectoryManager.getObjectInstance(obj, cn, homeCtx,
+                    homeCtx.envprops, attrs);
 
-        } catch (NamingException e) {
-            throw e;
+            } catch (NamingException e) {
+                throw e;
 
-        } catch (Exception e) {
-            NamingException ne =
-                new NamingException(
-                        "problem generating object using object factory");
-            ne.setRootCause(e);
-            throw ne;
-        }
+            } catch (Exception e) {
+                NamingException ne =
+                    new NamingException(
+                            "problem generating object using object factory");
+                ne.setRootCause(e);
+                throw ne;
+            }
 
-        Binding binding;
-        if (respCtls != null) {
-           binding = new BindingWithControls(cn.toString(), obj,
-                                homeCtx.convertControls(respCtls));
-        } else {
-            binding = new Binding(cn.toString(), obj);
+            Binding binding;
+            if (respCtls != null) {
+                binding = new BindingWithControls(cn.toString(), obj,
+                                     homeCtx.convertControls(respCtls));
+            } else {
+                binding = new Binding(cn.toString(), obj);
+            }
+            binding.setNameInNamespace(dn);
+            return binding;
+        } finally {
+            // Ensure writes are visible to the Cleaner thread
+            VarHandle.fullFence();
+            // Ensure Cleaner does not run until after this method completes
+            Reference.reachabilityFence(this);
         }
-        binding.setNameInNamespace(dn);
-        return binding;
     }
 
     @Override
     protected AbstractLdapNamingEnumeration<? extends NameClassPair> getReferredResults(
             LdapReferralContext refCtx) throws NamingException{
-        // repeat the original operation at the new context
-        return (AbstractLdapNamingEnumeration<? extends NameClassPair>)refCtx.listBindings(listArg);
+        try {
+            // repeat the original operation at the new context
+            return (AbstractLdapNamingEnumeration<? extends NameClassPair>) refCtx.listBindings(listArg);
+        } finally {
+            // Ensure writes are visible to the Cleaner thread
+            VarHandle.fullFence();
+            // Ensure Cleaner does not run until after this method completes
+            Reference.reachabilityFence(this);
+        }
     }
 }