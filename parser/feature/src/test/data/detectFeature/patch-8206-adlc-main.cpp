@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -226,6 +226,7 @@ int main(int argc, char *argv[])
   AD.addInclude(AD._CPP_file, "opto/intrinsicnode.hpp");
   AD.addInclude(AD._CPP_file, "opto/locknode.hpp");
   AD.addInclude(AD._CPP_file, "opto/opcodes.hpp");
+  AD.addInclude(AD._CPP_file, "opto/parse.hpp");
   AD.addInclude(AD._CPP_file, "opto/regalloc.hpp");
   AD.addInclude(AD._CPP_file, "opto/regmask.hpp");
   AD.addInclude(AD._CPP_file, "opto/runtime.hpp");