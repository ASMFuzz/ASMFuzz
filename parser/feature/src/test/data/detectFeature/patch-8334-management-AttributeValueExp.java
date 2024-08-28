@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2015, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -132,7 +132,7 @@ public String toString()  {
      * obtain an attribute value is {@link QueryEval#getMBeanServer()}.
      */
     /* There is no need for this method, because if a query is being
-       evaluted an AttributeValueExp can only appear inside a QueryExp,
+       evaluated an AttributeValueExp can only appear inside a QueryExp,
        and that QueryExp will itself have done setMBeanServer.  */
     @Deprecated
     @Override