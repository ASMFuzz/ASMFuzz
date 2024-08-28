@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2011, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -29,9 +29,10 @@
 import javax.naming.directory.*;
 
 import com.sun.jndi.toolkit.ctx.Continuation;
+import java.lang.invoke.VarHandle;
 import java.util.Vector;
 import javax.naming.ldap.Control;
-
+import java.lang.ref.Reference;
 
 final class LdapNamingEnumeration
         extends AbstractLdapNamingEnumeration<NameClassPair> {
@@ -46,35 +47,49 @@ final class LdapNamingEnumeration
     @Override
     protected NameClassPair createItem(String dn, Attributes attrs,
             Vector<Control> respCtls) throws NamingException {
+        try {
+            LdapCtx homeCtx = getHomeCtx();
+            Attribute attr;
+            String className = null;
 
-        Attribute attr;
-        String className = null;
-
-        // use the Java classname if present
-        if ((attr = attrs.get(Obj.JAVA_ATTRIBUTES[Obj.CLASSNAME])) != null) {
-            className = (String)attr.get();
-        } else {
-            className = defaultClassName;
-        }
-        CompositeName cn = new CompositeName();
-        cn.add(getAtom(dn));
+            // use the Java classname if present
+            if ((attr = attrs.get(Obj.JAVA_ATTRIBUTES[Obj.CLASSNAME])) != null) {
+                className = (String) attr.get();
+            } else {
+                className = defaultClassName;
+            }
+            CompositeName cn = new CompositeName();
+            cn.add(getAtom(dn));
 
-        NameClassPair ncp;
-        if (respCtls != null) {
-            ncp = new NameClassPairWithControls(
+            NameClassPair ncp;
+            if (respCtls != null) {
+                ncp = new NameClassPairWithControls(
                         cn.toString(), className,
                         homeCtx.convertControls(respCtls));
-        } else {
-            ncp = new NameClassPair(cn.toString(), className);
+            } else {
+                ncp = new NameClassPair(cn.toString(), className);
+            }
+            ncp.setNameInNamespace(dn);
+            return ncp;
+        }  finally {
+            // Ensure writes are visible to the Cleaner thread
+            VarHandle.fullFence();
+            // Ensure Cleaner does not run until after this method completes
+            Reference.reachabilityFence(this);
         }
-        ncp.setNameInNamespace(dn);
-        return ncp;
     }
 
     @Override
     protected AbstractLdapNamingEnumeration<? extends NameClassPair> getReferredResults(
             LdapReferralContext refCtx) throws NamingException {
-        // repeat the original operation at the new context
-        return (AbstractLdapNamingEnumeration<? extends NameClassPair>)refCtx.list(listArg);
+        try {
+            // repeat the original operation at the new context
+            return (AbstractLdapNamingEnumeration<? extends NameClassPair>)refCtx.list(listArg);
+        } finally {
+            // Ensure writes are visible to the Cleaner thread
+            VarHandle.fullFence();
+            // Ensure Cleaner does not run until after this method completes
+            Reference.reachabilityFence(this);
+        }
     }
 }