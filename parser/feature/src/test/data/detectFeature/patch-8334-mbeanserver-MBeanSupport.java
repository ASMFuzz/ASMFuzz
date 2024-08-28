@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -94,7 +94,7 @@
  * MBean Server will always have the same interface here.)
  *
  * The MBeanInfo in this second cache will be the MBeanInfo from the
- * PerInterface cache for the given itnerface, but with the
+ * PerInterface cache for the given interface, but with the
  * getClassName() having the concrete class's name, and the public
  * constructors based on the concrete class's constructors.  This
  * MBeanInfo can be shared between all instances of the concrete class