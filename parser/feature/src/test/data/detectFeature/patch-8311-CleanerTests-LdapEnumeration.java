@@ -0,0 +1,174 @@
+/*
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
+ * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
+ *
+ * This code is free software; you can redistribute it and/or modify it
+ * under the terms of the GNU General Public License version 2 only, as
+ * published by the Free Software Foundation.
+ *
+ * This code is distributed in the hope that it will be useful, but WITHOUT
+ * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
+ * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
+ * version 2 for more details (a copy is included in the LICENSE file that
+ * accompanied this code).
+ *
+ * You should have received a copy of the GNU General Public License version
+ * 2 along with this work; if not, write to the Free Software Foundation,
+ * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
+ *
+ * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
+ * or visit www.oracle.com if you need additional information or have any
+ * questions.
+ */
+
+/*
+ * @test
+ * @bug 8283660
+ * @summary Verify the AbstractLdapNamingEnumeration Cleaner performs cleanup correctly
+ * @modules java.naming/com.sun.jndi.ldap:+open
+ * @library /test/lib ../lib/ /javax/naming/module/src/test/test/
+ * @build LDAPServer LDAPTestUtils
+ * @run main/othervm LdapEnumeration
+ */
+
+import javax.naming.NamingEnumeration;
+import javax.naming.directory.Attribute;
+import javax.naming.directory.Attributes;
+import javax.naming.directory.BasicAttribute;
+import javax.naming.directory.BasicAttributes;
+import javax.naming.directory.DirContext;
+import javax.naming.directory.InitialDirContext;
+import javax.naming.directory.SearchControls;
+import javax.naming.directory.SearchResult;
+import java.lang.reflect.Field;
+import java.net.InetAddress;
+import java.net.InetSocketAddress;
+import java.net.ServerSocket;
+import java.net.SocketAddress;
+import java.util.Hashtable;
+import java.util.WeakHashMap;
+
+import jdk.test.lib.net.URIBuilder;
+import jdk.test.lib.util.ForceGC;
+
+/*
+ * This test is a copy of com/sun/jndi/ldap/blits/AddTests/AddNewEntry.java,
+ * altered to confirm correct operation of the NamingEnumeration<SearchResult>
+ * cleaning action.
+ */
+public class LdapEnumeration {
+    static WeakHashMap whm = new WeakHashMap();
+
+    public static void main(String[] args) throws Exception {
+        // Create unbound server socket
+        ServerSocket serverSocket = new ServerSocket();
+
+        // Bind it to the loopback address
+        SocketAddress sockAddr = new InetSocketAddress(
+                InetAddress.getLoopbackAddress(), 0);
+        serverSocket.bind(sockAddr);
+
+        // Construct the provider URL for LDAPTestUtils
+        String providerURL = URIBuilder.newBuilder()
+                .scheme("ldap")
+                .loopback()
+                .port(serverSocket.getLocalPort())
+                .buildUnchecked().toString();
+
+        Hashtable<Object, Object> env;
+
+        // initialize test
+        env = LDAPTestUtils.initEnv(serverSocket, providerURL,
+                         LdapEnumeration.class.getName(), args, true);
+
+        /* Build attribute set */
+        String[] ids = { "objectClass", "sn", "cn", "telephoneNumber", "mail",
+                "description", "uid" };
+        Attribute objectClass = new BasicAttribute(ids[0]);
+        objectClass.add("top");
+        objectClass.add("person");
+        objectClass.add("organizationalPerson");
+        objectClass.add("inetOrgPerson");
+
+        Attribute sn = new BasicAttribute(ids[1], "Powers");
+        Attribute cn = new BasicAttribute(ids[2],
+                "Austin \\\"Danger\\\" Powers");
+        Attribute telephoneNumber = new BasicAttribute(ids[3], "+44 582 10101");
+        Attribute mail = new BasicAttribute(ids[4], "secret_agent_man@imc.org");
+        Attribute description = new BasicAttribute(ids[5], "Yea Baby!!");
+        description.add("Behave!");
+        Attribute uid = new BasicAttribute(ids[6], "secret_agent_man");
+
+        Attributes attrs = new BasicAttributes();
+        attrs.put(objectClass);
+        attrs.put(sn);
+        attrs.put(cn);
+        attrs.put(telephoneNumber);
+        attrs.put(mail);
+        attrs.put(description);
+        attrs.put(uid);
+
+        DirContext ctx = null;
+        String[] bases = new String[] { (String) env.get("client"),
+                (String) env.get("vendor"), "Add" };
+        String baseDN = LDAPTestUtils.buildDN(bases, (String) env.get("root"));
+        String entryDN = "cn=Austin Powers," + baseDN;
+        String expect = ""; // relative name
+
+        try {
+            // connect to server
+            ctx = new InitialDirContext(env);
+
+            // add entry
+            ctx.createSubcontext(entryDN, attrs);
+
+            // specify base search
+            SearchControls constraints = new SearchControls();
+            constraints.setSearchScope(SearchControls.OBJECT_SCOPE);
+
+            NamingEnumeration<SearchResult> results = ctx
+                    .search(entryDN, "(objectclass=*)", constraints);
+
+            if (!"LdapSearchEnumeration".equals(results.getClass().getSimpleName())) {
+                throw new RuntimeException("Unexpected results class: " + results.getClass());
+            }
+
+            // fetch enumCount from homeCtx, from EnumCtx, from results
+            Object enumCtx = getField(results.getClass().getSuperclass(), "enumCtx", results);
+            Object homeCtx = getField(enumCtx.getClass(), "homeCtx", enumCtx);
+            int enumCountBefore = (Integer) getField(homeCtx.getClass(), "enumCount", homeCtx);
+
+            whm.put(results, null);
+            results = null;
+
+            // If the Cleaner holds a reference to 'results', it won't be cleared from the map
+            ForceGC gc = new ForceGC();
+            if (!gc.wait(() -> whm.size() == 0)) {
+                throw new RuntimeException("NamingEnumeration is still strongly reachable");
+            }
+
+            // The enum count should have been decremented
+            int enumCountAfter = (Integer) getField(homeCtx.getClass(), "enumCount", homeCtx);
+            int expected = enumCountBefore - 1;
+            if (enumCountAfter != expected) {
+                throw new RuntimeException("enumCount was not decremented. Expected: " +
+                        expected + ", Got:" + enumCountAfter);
+            }
+        } finally {
+            LDAPTestUtils.cleanupSubcontext(ctx, entryDN);
+            LDAPTestUtils.cleanup(ctx);
+        }
+    }
+    /**
+     * Get an object from a named field.
+     */
+    static Object getField(Class<?> clazz, String fieldName, Object instance) {
+        try {
+            Field field = clazz.getDeclaredField(fieldName);
+            field.setAccessible(true);
+            return field.get(instance);
+        } catch (NoSuchFieldException | IllegalAccessException ex) {
+            throw new RuntimeException("field unknown or not accessible", ex);
+        }
+    }
+}