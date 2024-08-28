@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2011, 2021, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -288,7 +288,9 @@ public String call() throws Exception {
                 final AccessibleEditableText aet = ac.getAccessibleEditableText();
                 if (aet == null) return null;
 
-                return aet.getTextRange(location, location + length);
+                int currentLength = aet.getCharCount();
+                return aet.getTextRange(Math.min(currentLength, location),
+                        Math.min(currentLength, location + length));
             }
         }, c);
     }