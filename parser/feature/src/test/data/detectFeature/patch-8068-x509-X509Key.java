@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -264,8 +264,7 @@ static PublicKey buildX509Key(AlgorithmId algid, BitArray key)
                 result.parseKeyBits();
                 return result;
             }
-        } catch (ClassNotFoundException e) {
-        } catch (InstantiationException e) {
+        } catch (ClassNotFoundException | InstantiationException e) {
         } catch (IllegalAccessException e) {
             // this should not happen.
             throw new IOException (classname + " [internal error]");