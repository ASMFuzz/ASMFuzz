@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1998, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1998, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -44,6 +44,7 @@
  * Thread#Thread(ThreadGroup,Runnable,String,long,boolean) thread}, it is
  * possible to <i>opt out</i> of receiving initial values for inheritable
  * thread-local variables.
+ * @param <T> the type of the inheritable thread local's value
  *
  * @author  Josh Bloch and Doug Lea
  * @see     ThreadLocal