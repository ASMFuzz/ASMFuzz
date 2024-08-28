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
- * @bug 7021614 8241780 8273244
+ * @bug 7021614 8241780 8273244 8284908
  * @summary extend com.sun.source API to support parsing javadoc comments
  * @modules jdk.compiler/com.sun.tools.javac.api
  *          jdk.compiler/com.sun.tools.javac.file
@@ -140,7 +140,7 @@ void unterminated_1() { }
 /*
 DocComment[DOC_COMMENT, pos:0
   firstSentence: 1
-    Erroneous[ERRONEOUS, pos:0
+    Erroneous[ERRONEOUS, pos:0, prefPos:20
       code: compiler.err.dc.unterminated.inline.tag
       body: {@code_if_(a_<_b)_{_}
     ]
@@ -156,7 +156,7 @@ void unterminated_2() { }
 /*
 DocComment[DOC_COMMENT, pos:1
   firstSentence: 1
-    Erroneous[ERRONEOUS, pos:1
+    Erroneous[ERRONEOUS, pos:1, prefPos:34
       code: compiler.err.dc.unterminated.inline.tag
       body: {@code_if_(a_<_b...)_{_}|_@author_jjg
     ]