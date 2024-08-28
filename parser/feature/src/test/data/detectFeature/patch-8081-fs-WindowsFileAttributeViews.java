@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2008, 2011, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2008, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -110,9 +110,7 @@ void setFileTimes(long createTime,
                             // retry succeeded
                             x = null;
                         }
-                    } catch (SecurityException ignore) {
-                    } catch (WindowsException ignore) {
-                    } catch (IOException ignore) {
+                    } catch (SecurityException | WindowsException | IOException ignore) {
                         // ignore exceptions to let original exception be thrown
                     }
                 }