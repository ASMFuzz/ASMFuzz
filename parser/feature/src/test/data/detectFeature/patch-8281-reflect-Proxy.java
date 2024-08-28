@@ -495,67 +495,54 @@ private static final class ProxyBuilder {
         private static final ClassLoaderValue<Boolean> reverseProxyCache =
             new ClassLoaderValue<>();
 
-        private static Class<?> defineProxyClass(Module m, List<Class<?>> interfaces) {
-            String proxyPkg = null;     // package to define proxy class in
-            int accessFlags = Modifier.PUBLIC | Modifier.FINAL;
-            boolean nonExported = false;
+        private record ProxyClassContext(Module module, String packageName, int accessFlags) {
+            private ProxyClassContext {
+                if (module.isNamed()) {
+                    if (packageName.isEmpty()) {
+                        // Per JLS 7.4.2, unnamed package can only exist in unnamed modules.
+                        // This means a package-private superinterface exist in the unnamed
+                        // package of a named module.
+                        throw new InternalError("Unnamed package cannot be added to " + module);
+                    }
 
-            /*
-             * Record the package of a non-public proxy interface so that the
-             * proxy class will be defined in the same package.  Verify that
-             * all non-public proxy interfaces are in the same package.
-             */
-            for (Class<?> intf : interfaces) {
-                int flags = intf.getModifiers();
-                if (!Modifier.isPublic(flags)) {
-                    accessFlags = Modifier.FINAL;  // non-public, final
-                    String pkg = intf.getPackageName();
-                    if (proxyPkg == null) {
-                        proxyPkg = pkg;
-                    } else if (!pkg.equals(proxyPkg)) {
-                        throw new IllegalArgumentException(
-                                "non-public interfaces from different packages");
+                    if (!module.getDescriptor().packages().contains(packageName)) {
+                        throw new InternalError(packageName + " not exist in " + module.getName());
+                    }
+
+                    if (!module.isOpen(packageName, Proxy.class.getModule())) {
+                        // Required for default method invocation
+                        throw new InternalError(packageName + " not open to " + Proxy.class.getModule());
                     }
                 } else {
-                    if (!intf.getModule().isExported(intf.getPackageName())) {
-                        // module-private types
-                        nonExported = true;
+                    if (Modifier.isPublic(accessFlags)) {
+                        // All proxy superinterfaces are public, must be in named dynamic module
+                        throw new InternalError("public proxy in unnamed module: " + module);
                     }
                 }
-            }
 
-            if (proxyPkg == null) {
-                // all proxy interfaces are public and exported
-                if (!m.isNamed())
-                    throw new InternalError("unnamed module: " + m);
-                proxyPkg = nonExported ? PROXY_PACKAGE_PREFIX + "." + m.getName()
-                                       : m.getName();
-            } else if (proxyPkg.isEmpty() && m.isNamed()) {
-                throw new IllegalArgumentException(
-                        "Unnamed package cannot be added to " + m);
-            }
-
-            if (m.isNamed()) {
-                if (!m.getDescriptor().packages().contains(proxyPkg)) {
-                    throw new InternalError(proxyPkg + " not exist in " + m.getName());
+                if ((accessFlags & ~Modifier.PUBLIC) != 0) {
+                    throw new InternalError("proxy access flags must be Modifier.PUBLIC or 0");
                 }
             }
+        }
 
+        private static Class<?> defineProxyClass(ProxyClassContext context, List<Class<?>> interfaces) {
             /*
              * Choose a name for the proxy class to generate.
              */
             long num = nextUniqueNumber.getAndIncrement();
-            String proxyName = proxyPkg.isEmpty()
+            String proxyName = context.packageName().isEmpty()
                                     ? proxyClassNamePrefix + num
-                                    : proxyPkg + "." + proxyClassNamePrefix + num;
+                                    : context.packageName() + "." + proxyClassNamePrefix + num;
 
-            ClassLoader loader = getLoader(m);
-            trace(proxyName, m, loader, interfaces);
+            ClassLoader loader = getLoader(context.module());
+            trace(proxyName, context.module(), loader, interfaces);
 
             /*
              * Generate the specified proxy class.
              */
-            byte[] proxyClassFile = ProxyGenerator.generateProxyClass(loader, proxyName, interfaces, accessFlags);
+            byte[] proxyClassFile = ProxyGenerator.generateProxyClass(loader, proxyName, interfaces,
+                                                                      context.accessFlags() | Modifier.FINAL);
             try {
                 Class<?> pc = JLA.defineClass(loader, proxyName, proxyClassFile,
                                               null, "__dynamic_proxy__");
@@ -575,7 +562,7 @@ private static Class<?> defineProxyClass(Module m, List<Class<?>> interfaces) {
 
         /**
          * Test if given class is a class defined by
-         * {@link #defineProxyClass(Module, List)}
+         * {@link #defineProxyClass(ProxyClassContext, List)}
          */
         static boolean isProxyClass(Class<?> c) {
             return Objects.equals(reverseProxyCache.sub(c).get(c.getClassLoader()),
@@ -631,7 +618,7 @@ private static boolean isDebug(String flag) {
         // ProxyBuilder instance members start here....
 
         private final List<Class<?>> interfaces;
-        private final Module module;
+        private final ProxyClassContext context;
         ProxyBuilder(ClassLoader loader, List<Class<?>> interfaces) {
             if (!VM.isModuleSystemInited()) {
                 throw new InternalError("Proxy is not supported until "
@@ -648,8 +635,8 @@ private static boolean isDebug(String flag) {
             validateProxyInterfaces(loader, interfaces, refTypes);
 
             this.interfaces = interfaces;
-            this.module = mapToModule(loader, interfaces, refTypes);
-            assert getLoader(module) == loader;
+            this.context = proxyClassContext(loader, interfaces, refTypes);
+            assert getLoader(context.module()) == loader;
         }
 
         ProxyBuilder(ClassLoader loader, Class<?> intf) {
@@ -667,8 +654,7 @@ private static boolean isDebug(String flag) {
          */
         @SuppressWarnings("removal")
         Constructor<?> build() {
-            Class<?> proxyClass = defineProxyClass(module, interfaces);
-            assert !module.isNamed() || module.isOpen(proxyClass.getPackageName(), Proxy.class.getModule());
+            Class<?> proxyClass = defineProxyClass(context, interfaces);
 
             final Constructor<?> cons;
             try {
@@ -768,10 +754,11 @@ private static void addElementType(HashSet<Class<?>> types,
         }
 
         /**
-         * Returns the module that the generated proxy class belongs to.
+         * Returns the context for the generated proxy class, including the
+         * module and the package it belongs to and whether it is package-private.
          *
          * If any of proxy interface is package-private, then the proxy class
-         * is in the same module of the package-private interface.
+         * is in the same package and module as the package-private interface.
          *
          * If all proxy interfaces are public and in exported packages,
          * then the proxy class is in a dynamic module in an unconditionally
@@ -785,14 +772,21 @@ private static void addElementType(HashSet<Class<?>> types,
          *
          * Reads edge and qualified exports are added for dynamic module to access.
          */
-        private static Module mapToModule(ClassLoader loader,
-                                          List<Class<?>> interfaces,
-                                          Set<Class<?>> refTypes) {
+        private static ProxyClassContext proxyClassContext(ClassLoader loader,
+                                                           List<Class<?>> interfaces,
+                                                           Set<Class<?>> refTypes) {
             Map<Class<?>, Module> packagePrivateTypes = new HashMap<>();
+            boolean nonExported = false;
+
             for (Class<?> intf : interfaces) {
                 Module m = intf.getModule();
                 if (!Modifier.isPublic(intf.getModifiers())) {
                     packagePrivateTypes.put(intf, m);
+                } else {
+                    if (!intf.getModule().isExported(intf.getPackageName())) {
+                        // module-private types
+                        nonExported = true;
+                    }
                 }
             }
 
@@ -838,7 +832,7 @@ private static Module mapToModule(ClassLoader loader,
                     Modules.addOpens(targetModule, targetPackageName, Proxy.class.getModule());
                 }
                 // return the module of the package-private interface
-                return targetModule;
+                return new ProxyClassContext(targetModule, targetPackageName, 0);
             }
 
             // All proxy interfaces are public.  So maps to a dynamic proxy module
@@ -852,7 +846,10 @@ private static Module mapToModule(ClassLoader loader,
             for (Class<?> c : types) {
                 ensureAccess(targetModule, c);
             }
-            return targetModule;
+
+            var pkgName = nonExported ? PROXY_PACKAGE_PREFIX + '.' + targetModule.getName()
+                                      : targetModule.getName();
+            return new ProxyClassContext(targetModule, pkgName, Modifier.PUBLIC);
         }
 
         /*