@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -36,6 +36,7 @@
 class MemoryBuffer;
 
 class GraphBuilder {
+  friend class JfrResolution;
  private:
   // Per-scope data. These are pushed and popped as we descend into
   // inlined methods. Currently in order to generate good code in the