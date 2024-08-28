@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2012, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -255,7 +255,7 @@ public int hashCode() {
      *     "type=host_name (0), value={@literal <hostname>}"
      * </pre>
      * The "{@literal <hostname>}" is an ASCII representation of the hostname,
-     * which may contains A-labels.  For example, a returned value of an pseudo
+     * which may contain A-labels.  For example, a returned value of a pseudo
      * hostname may look like:
      * <pre>
      *     "type=host_name (0), value=www.example.com"