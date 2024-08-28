@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2012, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -23,7 +23,7 @@
 
 /*
  * @test
- * @bug 7021614 8273244
+ * @bug 7021614 8273244 8284908
  * @summary extend com.sun.source API to support parsing javadoc comments
  * @modules jdk.compiler/com.sun.tools.javac.api
  *          jdk.compiler/com.sun.tools.javac.file
@@ -138,7 +138,7 @@ public void bad_entity_decimal_value() { }
 DocComment[DOC_COMMENT, pos:2
   firstSentence: 3
     Text[TEXT, pos:2, abc_]
-    Erroneous[ERRONEOUS, pos:6
+    Erroneous[ERRONEOUS, pos:6, prefPos:10
       code: compiler.err.dc.missing.semicolon
       body: &#012
     ]
@@ -156,7 +156,7 @@ public void bad_entity_hex_value() { }
 DocComment[DOC_COMMENT, pos:2
   firstSentence: 3
     Text[TEXT, pos:2, abc_]
-    Erroneous[ERRONEOUS, pos:6
+    Erroneous[ERRONEOUS, pos:6, prefPos:12
       code: compiler.err.dc.missing.semicolon
       body: &#x012a
     ]