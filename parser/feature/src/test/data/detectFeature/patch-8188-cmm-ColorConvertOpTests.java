@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2012, 2014, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
  *
  * Redistribution and use in source and binary forms, with or without
  * modification, are permitted provided that the following conditions
@@ -79,11 +79,19 @@ public static ImageContent[] values() {
     }
 
     private static class ImageType {
-        static ImageType INT_ARGB = new ImageType(BufferedImage.TYPE_INT_ARGB, "INT_ARGB", "TYPE_INT_ARGB");
         static ImageType INT_RGB = new ImageType(BufferedImage.TYPE_INT_RGB, "INT_RGB", "TYPE_INT_RGB");
+        static ImageType INT_ARGB = new ImageType(BufferedImage.TYPE_INT_ARGB, "INT_ARGB", "TYPE_INT_ARGB");
+        static ImageType INT_ARGB_PRE = new ImageType(BufferedImage.TYPE_INT_ARGB_PRE, "INT_ARGB_PRE", "TYPE_INT_ARGB_PRE");
         static ImageType INT_BGR = new ImageType(BufferedImage.TYPE_INT_BGR, "INT_BGR", "TYPE_INT_BGR");
         static ImageType BYTE_3BYTE_BGR = new ImageType(BufferedImage.TYPE_3BYTE_BGR, "3BYTE_BGR", "TYPE_3BYTE_BGR");
         static ImageType BYTE_4BYTE_ABGR = new ImageType(BufferedImage.TYPE_4BYTE_ABGR, "4BYTE_ABGR", "TYPE_4BYTE_ABGR");
+        static ImageType BYTE_4BYTE_ABGR_PRE = new ImageType(BufferedImage.TYPE_4BYTE_ABGR_PRE, "4BYTE_ABGR_PRE", "TYPE_4BYTE_ABGR_PRE");
+        static ImageType BYTE_GRAY = new ImageType(BufferedImage.TYPE_BYTE_GRAY, "BYTE_GRAY", "TYPE_BYTE_GRAY");
+        static ImageType BYTE_BINARY = new ImageType(BufferedImage.TYPE_BYTE_BINARY, "BYTE_BINARY", "TYPE_BYTE_BINARY");
+        static ImageType BYTE_INDEXED = new ImageType(BufferedImage.TYPE_BYTE_INDEXED, "BYTE_INDEXED", "TYPE_BYTE_INDEXED");
+        static ImageType USHORT_565_RGB = new ImageType(BufferedImage.TYPE_USHORT_565_RGB, "USHORT_565_RGB", "TYPE_USHORT_565_RGB");
+        static ImageType USHORT_555_RGB = new ImageType(BufferedImage.TYPE_USHORT_555_RGB, "USHORT_555_RGB", "TYPE_USHORT_555_RGB");
+        static ImageType USHORT_GRAY = new ImageType(BufferedImage.TYPE_USHORT_GRAY, "USHORT_GRAY", "TYPE_USHORT_GRAY");
         static ImageType COMPATIBLE_DST = new ImageType(0, "Compatible", "Compatible destination");
 
         private ImageType(int type, String abbr, String descr) {
@@ -97,8 +105,10 @@ private ImageType(int type, String abbr, String descr) {
         public final String descr;
 
         public static ImageType[] values() {
-            return new ImageType[]{INT_ARGB, INT_RGB, INT_BGR,
-                    BYTE_3BYTE_BGR, BYTE_4BYTE_ABGR, COMPATIBLE_DST};
+            return new ImageType[]{INT_RGB, INT_ARGB, INT_ARGB_PRE, INT_BGR,
+                    BYTE_3BYTE_BGR, BYTE_4BYTE_ABGR, BYTE_4BYTE_ABGR_PRE,
+                    BYTE_GRAY, BYTE_BINARY, BYTE_INDEXED, USHORT_565_RGB,
+                    USHORT_555_RGB, USHORT_GRAY, COMPATIBLE_DST};
         }
     }
 