@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -776,7 +776,7 @@ protected String[] keysSpi() throws BackingStoreException{
 
     /**
      * Implements {@code AbstractPreferences} {@code childrenNamesSpi()} method.
-     * Calls Windows registry to retrive children of this node.
+     * Calls Windows registry to retrieve children of this node.
      * Throws a BackingStoreException and logs a warning message,
      * if Windows registry is not available.
      */