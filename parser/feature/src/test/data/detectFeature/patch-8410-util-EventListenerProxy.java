@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2004, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -48,6 +48,8 @@
  * If the calling method is interested in retrieving the named property
  * then it would have to test the element to see if it is a proxy class.
  *
+ * @param <T> the type of {@code EventListener} being wrapped
+ *
  * @since 1.4
  */
 public abstract class EventListenerProxy<T extends EventListener>