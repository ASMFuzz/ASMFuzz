@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -369,8 +369,6 @@ void nsk_jvmti_getFileName(int redefineCnt, const char * dir,  char * buf, size_
  */
 void nsk_jvmti_agentFailed();
 
-int isThreadExpected(jvmtiEnv *jvmti, jthread thread);
-
 /**
 * This method makes the thread to be suspended at the right place when the top frame
 * belongs to the test rather than to incidental Java code (classloading, JVMCI, etc).