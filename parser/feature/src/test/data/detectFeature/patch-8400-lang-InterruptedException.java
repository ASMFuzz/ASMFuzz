@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1995, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1995, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -32,10 +32,10 @@
  * thread has been interrupted, and if so, to immediately throw
  * this exception.  The following code can be used to achieve
  * this effect:
- * <pre>
- *  if (Thread.interrupted())  // Clears interrupted status!
- *      throw new InterruptedException();
- * </pre>
+ * {@snippet lang=java :
+ * if (Thread.interrupted())  // Clears interrupted status!
+ *     throw new InterruptedException();
+ * }
  *
  * @author  Frank Yellin
  * @see     java.lang.Object#wait()