@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2011, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -31,7 +31,7 @@
 /**
  * Direct subclasses of AtomicDirContext must provide implementations for
  * the abstract a_ DirContext methods, and override the a_ Context methods
- * (which are no longer abstract because they have been overriden by
+ * (which are no longer abstract because they have been overridden by
  * PartialCompositeDirContext with dummy implementations).
  *
  * If the subclass implements the notion of implicit nns,