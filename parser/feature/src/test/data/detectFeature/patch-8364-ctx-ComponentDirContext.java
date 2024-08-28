@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2011, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -30,7 +30,7 @@
 
 /* Direct subclasses of ComponentDirContext must provide implementations for
  * the abstract c_ DirContext methods, and override the c_ Context methods
- * (which are no longer abstract because they have been overriden by
+ * (which are no longer abstract because they have been overridden by
  * AtomicContext, the direct superclass of PartialDSCompositeContext).
  *
  * If the subclass is supports implicit nns, it must override all the