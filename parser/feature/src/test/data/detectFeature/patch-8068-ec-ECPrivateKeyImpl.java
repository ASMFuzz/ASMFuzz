@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2006, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2006, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -200,9 +200,7 @@ private void parseKeyBits() throws InvalidKeyException {
                     + "encoded in the algorithm identifier");
             }
             params = algParams.getParameterSpec(ECParameterSpec.class);
-        } catch (IOException e) {
-            throw new InvalidKeyException("Invalid EC private key", e);
-        } catch (InvalidParameterSpecException e) {
+        } catch (IOException | InvalidParameterSpecException e) {
             throw new InvalidKeyException("Invalid EC private key", e);
         }
     }