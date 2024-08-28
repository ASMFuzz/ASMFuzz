@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -24,7 +24,6 @@
  */
 
 package java.util;
-import java.util.Map.Entry;
 
 /**
  * This class provides a skeletal implementation of the {@code Map}
@@ -493,9 +492,7 @@ public boolean equals(Object o) {
                         return false;
                 }
             }
-        } catch (ClassCastException unused) {
-            return false;
-        } catch (NullPointerException unused) {
+        } catch (ClassCastException | NullPointerException unused) {
             return false;
         }
 