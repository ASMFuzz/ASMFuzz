@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -450,6 +450,12 @@ jthread nsk_jvmti_threadByName(const char name[]) {
 
         if (info.name != NULL && strcmp(name, info.name) == 0) {
             foundThread = threads[i];
+        }
+        if (!NSK_JVMTI_VERIFY(jvmti_env->Deallocate((unsigned char*)info.name))) {
+            nsk_jvmti_setFailStatus();
+            return NULL;
+        }
+        if (foundThread != NULL) {
             break;
         }
     }