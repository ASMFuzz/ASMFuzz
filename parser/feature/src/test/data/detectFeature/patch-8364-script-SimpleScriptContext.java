@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -95,7 +95,7 @@ public SimpleScriptContext() {
 
     /**
      * Package-private constructor to avoid needless creation of reader and writers.
-     * It is the caller's responsability to initialize the engine scope.
+     * It is the caller's responsibility to initialize the engine scope.
      *
      * @param reader the reader
      * @param writer the writer