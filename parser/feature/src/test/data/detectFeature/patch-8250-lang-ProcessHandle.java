@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2014, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2014, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -241,7 +241,7 @@ public interface Info {
          *          <p>
          *          The executable pathname may contain only the
          *          name of the executable without the full path information.
-         *          It is undecideable whether white space separates different
+         *          It is undecidable whether white space separates different
          *          arguments or is part of a single argument.
          *
          * @return an {@code Optional<String>} of the command line