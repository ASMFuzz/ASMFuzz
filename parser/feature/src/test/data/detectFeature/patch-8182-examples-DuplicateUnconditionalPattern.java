@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -21,12 +21,12 @@
  * questions.
  */
 
-// key: compiler.err.duplicate.total.pattern
+// key: compiler.err.duplicate.unconditional.pattern
 // key: compiler.misc.feature.pattern.switch
 // key: compiler.warn.preview.feature.use.plural
 // options: --enable-preview -source ${jdk.version} -Xlint:preview
 
-class DuplicateTotalPattern {
+class DuplicateUnconditionalPattern {
     private void doSwitch(Object o) {
         switch (o) {
             case Object obj: break;