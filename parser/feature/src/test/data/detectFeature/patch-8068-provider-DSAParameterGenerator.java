@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -145,10 +145,7 @@ protected AlgorithmParameters engineGenerateParameters() {
         } catch (InvalidParameterSpecException e) {
             // this should never happen
             throw new RuntimeException(e.getMessage());
-        } catch (NoSuchAlgorithmException e) {
-            // this should never happen, because we provide it
-            throw new RuntimeException(e.getMessage());
-        } catch (NoSuchProviderException e) {
+        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
             // this should never happen, because we provide it
             throw new RuntimeException(e.getMessage());
         }