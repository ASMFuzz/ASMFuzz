@@ -524,10 +524,10 @@ private static byte[] pack(byte[] in,
 
             // and move them!
             out[opos/ow] |=                     // paste!
-                (((in[ioffset+ipos/iw]+256)     // locate the byte (+256 so that it's never negative)
+                (byte)((((in[ioffset+ipos/iw]+256)     // locate the byte (+256 so that it's never negative)
                     >> (iw-ipos%iw-count)) &    // move to the end of a byte
                   ((1 << (count))-1))           // zero out all other bits
-                        << (ow-opos%ow-count);  // move to the output position
+                        << (ow-opos%ow-count));  // move to the output position
             ipos += count;  // advance
             opos += count;  // advance
         }
@@ -551,7 +551,7 @@ private static int pack7Oid(byte[] in,
             if (pack[i] != 0) {
                 firstNonZero = i;
             }
-            pack[i] |= 0x80;
+            pack[i] |= (byte)0x80;
         }
         System.arraycopy(pack, firstNonZero,
                 out, ooffset, pack.length-firstNonZero);