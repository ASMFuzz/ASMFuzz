@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -49,7 +49,7 @@
  * <p>If the method call of a filter or listener throws an {@link Exception},
  * then that exception does not prevent other listeners from being invoked.  However,
  * if the method call of a filter or of {@code Executor.execute} or of
- * {@code handleNotification} (when no {@code Excecutor} is specified) throws an
+ * {@code handleNotification} (when no {@code Executor} is specified) throws an
  * {@link Error}, then that {@code Error} is propagated to the caller of
  * {@link #sendNotification sendNotification}.</p>
  *