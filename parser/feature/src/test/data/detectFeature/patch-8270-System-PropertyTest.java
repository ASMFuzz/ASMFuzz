@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -40,7 +40,7 @@
 
 /*
  * @test
- * @bug 4463345 4244670 8030781 8265989
+ * @bug 4463345 4244670 8030781 8265989 8283620
  * @summary Simple test of System getProperty, setProperty, clearProperty,
  *      getProperties, and setProperties
  * @run testng/othervm PropertyTest
@@ -81,6 +81,8 @@ static Object[][] requiredProperties() {
                 {"java.runtime.version"},
                 {"java.runtime.name"},
                 {"native.encoding"},
+                {"stdout.encoding"},
+                {"stderr.encoding"},
         };
     }
 