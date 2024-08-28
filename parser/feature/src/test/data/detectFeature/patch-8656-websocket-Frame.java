@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2015, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -215,7 +215,11 @@ HeaderWriter fin(boolean value) {
             if (value) {
                 firstChar |=  0b10000000_00000000;
             } else {
-                firstChar &= ~0b10000000_00000000;
+                // Explicit cast required:
+                // The negation "~" sets the high order bits
+                // so the value becomes more than 16 bits and the
+                // compiler will emit a warning if not cast
+                firstChar &= (char) ~0b10000000_00000000;
             }
             return this;
         }
@@ -224,7 +228,8 @@ HeaderWriter rsv1(boolean value) {
             if (value) {
                 firstChar |=  0b01000000_00000000;
             } else {
-                firstChar &= ~0b01000000_00000000;
+                // Explicit cast required - see fin() above
+                firstChar &= (char) ~0b01000000_00000000;
             }
             return this;
         }
@@ -233,7 +238,8 @@ HeaderWriter rsv2(boolean value) {
             if (value) {
                 firstChar |=  0b00100000_00000000;
             } else {
-                firstChar &= ~0b00100000_00000000;
+                // Explicit cast required - see fin() above
+                firstChar &= (char) ~0b00100000_00000000;
             }
             return this;
         }
@@ -242,7 +248,8 @@ HeaderWriter rsv3(boolean value) {
             if (value) {
                 firstChar |=  0b00010000_00000000;
             } else {
-                firstChar &= ~0b00010000_00000000;
+                // Explicit cast required - see fin() above
+                firstChar &= (char) ~0b00010000_00000000;
             }
             return this;
         }
@@ -259,7 +266,7 @@ HeaderWriter payloadLen(long value) {
             payloadLen = value;
             firstChar &= 0b11111111_10000000; // Clear previous payload length leftovers
             if (payloadLen < 126) {
-                firstChar |= payloadLen;
+                firstChar |= (char) payloadLen;
             } else if (payloadLen < 65536) {
                 firstChar |= 126;
             } else {
@@ -276,7 +283,8 @@ HeaderWriter mask(int value) {
         }
 
         HeaderWriter noMask() {
-            firstChar &= ~0b00000000_10000000;
+            // Explicit cast required: see fin() above
+            firstChar &= (char) ~0b00000000_10000000;
             mask = false;
             return this;
         }