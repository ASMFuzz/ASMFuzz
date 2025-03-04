@@ -0,0 +1,69 @@
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
+ * @summary Verifies that canDecode does not throw EOFException
+ *          if the file has too few bytes.
+ * @run     main CanDecodeTest
+ */
+
+import java.io.ByteArrayInputStream;
+import java.io.IOException;
+import java.io.InputStream;
+import javax.imageio.ImageIO;
+import javax.imageio.ImageReader;
+import javax.imageio.spi.ImageReaderSpi;
+import javax.imageio.stream.ImageInputStream;
+
+public class CanDecodeTest {
+
+    private static final String[] FORMATS = {
+        "WBMP", "BMP", "GIF", "PNG", "TIFF", "JPEG"
+    };
+
+    public static void main(String[] args) {
+        for (String format : FORMATS) {
+            ImageReader reader =
+                    ImageIO.getImageReadersByFormatName(format).next();
+            ImageReaderSpi spi = reader.getOriginatingProvider();
+
+            for (int n=0; n<8; n++) {
+                InputStream dataStream =
+                        new ByteArrayInputStream(new byte[n]);
+                try {
+                    ImageInputStream iis =
+                            ImageIO.createImageInputStream(dataStream);
+
+                    if (spi.canDecodeInput(iis)) {
+                        throw new RuntimeException("Test failed for " +
+                                format + " format: shall not decode.");
+                    }
+                } catch (IOException e) {
+                    throw new RuntimeException("Test failed for " +
+                            format + " format: " + e, e);
+                }
+            }
+        }
+    }
+}