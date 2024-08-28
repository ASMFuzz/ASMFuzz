@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1994, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1994, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -831,9 +831,7 @@ public synchronized boolean equals(Object o) {
                         return false;
                 }
             }
-        } catch (ClassCastException unused)   {
-            return false;
-        } catch (NullPointerException unused) {
+        } catch (ClassCastException | NullPointerException unused) {
             return false;
         }
 