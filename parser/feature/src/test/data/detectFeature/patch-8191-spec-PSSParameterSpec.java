@@ -112,12 +112,6 @@ public class PSSParameterSpec implements AlgorithmParameterSpec {
         ("SHA-1", "MGF1", MGF1ParameterSpec.SHA1, 20, TRAILER_FIELD_BC);
 
 
-    // disallowed
-    private PSSParameterSpec() {
-        throw new RuntimeException("default constructor not allowed");
-    }
-
-
     /**
      * Creates a new {@code PSSParameterSpec} as defined in
      * the PKCS #1 standard using the specified message digest,