@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -40,7 +40,7 @@ define_pd_global(uintx, CodeCacheSegmentSize,    64 COMPILER1_AND_COMPILER2_PRES
 // assign a different value for C2 without touching a number of files. Use
 // #ifdef to minimize the change as it's late in Mantis. -- FIXME.
 // c1 doesn't have this problem because the fix to 4858033 assures us
-// the the vep is aligned at CodeEntryAlignment whereas c2 only aligns
+// the vep is aligned at CodeEntryAlignment whereas c2 only aligns
 // the uep and the vep doesn't get real alignment but just slops on by
 // only assured that the entry instruction meets the 5 byte size requirement.
 #if COMPILER2_OR_JVMCI