@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -1224,13 +1224,7 @@ private Object loadSerializedObject(URL codebase, String filename)
                 Object serObject = ois.readObject();
                 ois.close();
                 return serObject;
-            } catch (IOException e) {
-                if (MLET_LOGGER.isLoggable(Level.DEBUG)) {
-                    MLET_LOGGER.log(Level.DEBUG,
-                            "Exception while deserializing " + filename, e);
-                }
-                throw e;
-            } catch (ClassNotFoundException e) {
+            } catch (IOException | ClassNotFoundException e) {
                 if (MLET_LOGGER.isLoggable(Level.DEBUG)) {
                     MLET_LOGGER.log(Level.DEBUG,
                             "Exception while deserializing " + filename, e);