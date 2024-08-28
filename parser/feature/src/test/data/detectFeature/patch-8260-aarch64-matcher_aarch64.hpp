@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2021, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -154,7 +154,7 @@
     return UseSVE > 0;
   }
 
-  // true means we have fast l2f convers
+  // true means we have fast l2f conversion
   // false means that conversion is done by runtime call
   static constexpr bool convL2FSupported(void) {
       return true;