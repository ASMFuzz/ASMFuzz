@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2017, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2017, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -26,6 +26,8 @@
 /*
  * @test
  * @bug 8165736 8252657
+ * @comment muslc dlclose is a no-op, see 8285921
+ * @requires !vm.musl
  * @library /test/lib
  * @run testng AttachReturnError
  */