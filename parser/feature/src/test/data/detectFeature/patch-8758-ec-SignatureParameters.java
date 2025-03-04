@@ -0,0 +1,48 @@
+/*
+ * Copyright (c) 2022, Oracle and/or its affiliates. All rights reserved.
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
+ * @bug 8286908
+ * @summary ECDSA signature should not return parameters
+ * @library /test/lib
+ * @modules jdk.crypto.ec
+ */
+
+import jdk.test.lib.Asserts;
+
+import java.security.*;
+import java.security.interfaces.ECPrivateKey;
+import java.security.spec.ECGenParameterSpec;
+
+public class SignatureParameters {
+    public static void main(String[] args) throws Exception {
+        KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
+        kpg.initialize(new ECGenParameterSpec("secp384r1"));
+        ECPrivateKey key = (ECPrivateKey) kpg.generateKeyPair().getPrivate();
+        Signature s = Signature.getInstance("SHA384withECDSA");
+        s.initSign(key);
+        s.setParameter(key.getParams());
+        Asserts.assertEQ(s.getParameters(), null);
+    }
+}