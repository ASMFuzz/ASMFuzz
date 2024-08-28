@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2007, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2007, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -100,13 +100,8 @@ private static AsynchronousChannelProvider loadProviderFromProperty() {
                 Object tmp = Class.forName(cn, true,
                                            ClassLoader.getSystemClassLoader()).newInstance();
                 return (AsynchronousChannelProvider)tmp;
-            } catch (ClassNotFoundException x) {
-                throw new ServiceConfigurationError(null, x);
-            } catch (IllegalAccessException x) {
-                throw new ServiceConfigurationError(null, x);
-            } catch (InstantiationException x) {
-                throw new ServiceConfigurationError(null, x);
-            } catch (SecurityException x) {
+            } catch (ClassNotFoundException | SecurityException |
+                     InstantiationException | IllegalAccessException x) {
                 throw new ServiceConfigurationError(null, x);
             }
         }