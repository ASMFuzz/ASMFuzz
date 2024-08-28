@@ -4866,7 +4866,7 @@ private CertificateExtensions createV3Extensions(
                                 if (pos % 2 == 0) {
                                     data[pos/2] = (byte)(hex << 4);
                                 } else {
-                                    data[pos/2] += hex;
+                                    data[pos/2] += (byte)hex;
                                 }
                                 pos++;
                             }
@@ -5338,4 +5338,3 @@ public static <A,B> Pair<A,B> of(A a, B b) {
         return new Pair<>(a,b);
     }
 }
-