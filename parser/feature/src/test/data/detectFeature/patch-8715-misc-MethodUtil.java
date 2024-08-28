@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,24 +25,16 @@
 
 package sun.reflect.misc;
 
-import java.io.EOFException;
-import java.security.AllPermission;
+import java.io.IOException;
+import java.io.InputStream;
+import java.lang.reflect.InvocationTargetException;
+import java.lang.reflect.Method;
 import java.security.AccessController;
+import java.security.AllPermission;
+import java.security.CodeSource;
 import java.security.PermissionCollection;
-import java.security.SecureClassLoader;
 import java.security.PrivilegedExceptionAction;
-import java.security.CodeSource;
-import java.io.InputStream;
-import java.io.BufferedInputStream;
-import java.io.IOException;
-import java.net.URL;
-import java.net.URLConnection;
-import java.lang.reflect.Method;
-import java.lang.reflect.InvocationTargetException;
-import java.lang.reflect.Modifier;
-import java.util.Arrays;
-import java.util.HashMap;
-import java.util.Map;
+import java.security.SecureClassLoader;
 
 
 class Trampoline {
@@ -96,163 +88,6 @@ public static Method[] getMethods(Class<?> cls) {
         return cls.getMethods();
     }
 
-    /*
-     * Discover the public methods on public classes
-     * and interfaces accessible to any caller by calling
-     * Class.getMethods() and walking towards Object until
-     * we're done.
-     */
-     @SuppressWarnings("removal")
-     public static Method[] getPublicMethods(Class<?> cls) {
-        // compatibility for update release
-        if (System.getSecurityManager() == null) {
-            return cls.getMethods();
-        }
-        Map<Signature, Method> sigs = new HashMap<Signature, Method>();
-        while (cls != null) {
-            boolean done = getInternalPublicMethods(cls, sigs);
-            if (done) {
-                break;
-            }
-            getInterfaceMethods(cls, sigs);
-            cls = cls.getSuperclass();
-        }
-        return sigs.values().toArray(new Method[sigs.size()]);
-    }
-
-    /*
-     * Process the immediate interfaces of this class or interface.
-     */
-    private static void getInterfaceMethods(Class<?> cls,
-                                            Map<Signature, Method> sigs) {
-        Class<?>[] intfs = cls.getInterfaces();
-        for (int i=0; i < intfs.length; i++) {
-            Class<?> intf = intfs[i];
-            boolean done = getInternalPublicMethods(intf, sigs);
-            if (!done) {
-                getInterfaceMethods(intf, sigs);
-            }
-        }
-    }
-
-    /*
-     *
-     * Process the methods in this class or interface
-     */
-    private static boolean getInternalPublicMethods(Class<?> cls,
-                                                    Map<Signature, Method> sigs) {
-        Method[] methods = null;
-        try {
-            /*
-             * This class or interface is non-public so we
-             * can't use any of it's methods. Go back and
-             * try again with a superclass or superinterface.
-             */
-            if (!Modifier.isPublic(cls.getModifiers())) {
-                return false;
-            }
-            if (!ReflectUtil.isPackageAccessible(cls)) {
-                return false;
-            }
-
-            methods = cls.getMethods();
-        } catch (SecurityException se) {
-            return false;
-        }
-
-        /*
-         * Check for inherited methods with non-public
-         * declaring classes. They might override and hide
-         * methods from their superclasses or
-         * superinterfaces.
-         */
-        boolean done = true;
-        for (int i=0; i < methods.length; i++) {
-            Class<?> dc = methods[i].getDeclaringClass();
-            if (!Modifier.isPublic(dc.getModifiers())) {
-                done = false;
-                break;
-            }
-        }
-
-        if (done) {
-            /*
-             * We're done. Spray all the methods into
-             * the list and then we're out of here.
-             */
-            for (int i=0; i < methods.length; i++) {
-                addMethod(sigs, methods[i]);
-            }
-        } else {
-            /*
-             * Simulate cls.getDeclaredMethods() by
-             * stripping away inherited methods.
-             */
-            for (int i=0; i < methods.length; i++) {
-                Class<?> dc = methods[i].getDeclaringClass();
-                if (cls.equals(dc)) {
-                    addMethod(sigs, methods[i]);
-                }
-            }
-        }
-        return done;
-    }
-
-    private static void addMethod(Map<Signature, Method> sigs, Method method) {
-        Signature signature = new Signature(method);
-        if (!sigs.containsKey(signature)) {
-            sigs.put(signature, method);
-        } else if (!method.getDeclaringClass().isInterface()){
-            /*
-             * Superclasses beat interfaces.
-             */
-            Method old = sigs.get(signature);
-            if (old.getDeclaringClass().isInterface()) {
-                sigs.put(signature, method);
-            }
-        }
-    }
-
-    /**
-     * A class that represents the unique elements of a method that will be a
-     * key in the method cache.
-     */
-    private static class Signature {
-        private final String methodName;
-        private final Class<?>[] argClasses;
-        private final int hashCode;
-
-        Signature(Method m) {
-            this.methodName = m.getName();
-            this.argClasses = m.getParameterTypes();
-            this.hashCode = methodName.hashCode() + Arrays.hashCode(argClasses);
-        }
-
-        @Override public int hashCode() {
-            return hashCode;
-        }
-
-        @Override public boolean equals(Object o2) {
-            if (this == o2) {
-                return true;
-            }
-            Signature that = (Signature)o2;
-            if (!(methodName.equals(that.methodName))) {
-                return false;
-            }
-            if (argClasses.length != that.argClasses.length) {
-                return false;
-            }
-            for (int i = 0; i < argClasses.length; i++) {
-                if (!(argClasses[i] == that.argClasses[i])) {
-                  return false;
-                }
-            }
-            return true;
-        }
-    }
-
-
     /*
      * Bounce through the trampoline.
      */
@@ -358,8 +193,7 @@ private Class<?> defineClass(String name, byte[] b) throws IOException {
         return defineClass(name, b, 0, b.length, cs);
     }
 
-    protected PermissionCollection getPermissions(CodeSource codesource)
-    {
+    protected PermissionCollection getPermissions(CodeSource codesource) {
         PermissionCollection perms = super.getPermissions(codesource);
         perms.add(new AllPermission());
         return perms;