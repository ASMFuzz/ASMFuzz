@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2010, 2011, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2010, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -184,7 +184,7 @@ public InternalLocaleBuilder setExtension(char singleton, String value) throws L
                     ukeywords.clear();
                 }
             } else {
-                if (extensions != null && extensions.containsKey(key)) {
+                if (extensions != null) {
                     extensions.remove(key);
                 }
             }