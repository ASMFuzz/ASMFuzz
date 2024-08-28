@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2006, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2006, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -110,9 +110,7 @@ protected void parseKeyBits() throws InvalidKeyException {
         try {
             params = algParams.getParameterSpec(ECParameterSpec.class);
             w = ECUtil.decodePoint(key, params.getCurve());
-        } catch (IOException e) {
-            throw new InvalidKeyException("Invalid EC key", e);
-        } catch (InvalidParameterSpecException e) {
+        } catch (IOException | InvalidParameterSpecException e) {
             throw new InvalidKeyException("Invalid EC key", e);
         }
     }