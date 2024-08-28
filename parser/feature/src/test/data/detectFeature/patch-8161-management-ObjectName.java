@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -1175,9 +1175,7 @@ private void readObject(ObjectInputStream in)
 
         try {
             construct(cn);
-        } catch (NullPointerException e) {
-            throw new InvalidObjectException(e.toString());
-        } catch (MalformedObjectNameException e) {
+        } catch (NullPointerException | MalformedObjectNameException e) {
             throw new InvalidObjectException(e.toString());
         }
     }