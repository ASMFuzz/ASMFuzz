@@ -217,7 +217,7 @@ private static final int[] expandToSubKey(int[][] kr, boolean decrypting) {
             for (t = 0; t < 8; t++) {
                 cox[i][t] = B[t];
                 for (j = 0; j < 8; j++) {
-                    cox[i][t] ^= A[t][j] * box[i][j];
+                    cox[i][t] ^= (byte)(A[t][j] * box[i][j]);
                 }
             }
         }
@@ -227,7 +227,7 @@ private static final int[] expandToSubKey(int[][] kr, boolean decrypting) {
         for (i = 0; i < 256; i++) {
             S[i] = (byte)(cox[i][0] << 7);
             for (t = 1; t < 8; t++) {
-                    S[i] ^= cox[i][t] << (7-t);
+                    S[i] ^= (byte)(cox[i][t] << (7-t));
             }
             Si[S[i] & 0xFF] = (byte) i;
         }
@@ -276,7 +276,7 @@ private static final int[] expandToSubKey(int[][] kr, boolean decrypting) {
             for (t = 0; t < 4; t++) {
                 if (i != t) {
                     for (j = i+1; j < 8; j++) {
-                        AA[t][j] ^= mul(AA[i][j], AA[t][i]);
+                        AA[t][j] ^= (byte)(mul(AA[i][j], AA[t][i]));
                     }
                     AA[t][i] = 0;
                 }