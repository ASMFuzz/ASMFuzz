@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -304,17 +304,9 @@ private static MechanismFactory getMechFactoryImpl(Provider p,
                 throw createGSSException(p, className, "is not a " +
                                          SPI_MECH_FACTORY_TYPE, null);
             }
-        } catch (ClassNotFoundException e) {
-            throw createGSSException(p, className, "cannot be created", e);
-        } catch (NoSuchMethodException e) {
-            throw createGSSException(p, className, "cannot be created", e);
-        } catch (InvocationTargetException e) {
-            throw createGSSException(p, className, "cannot be created", e);
-        } catch (InstantiationException e) {
-            throw createGSSException(p, className, "cannot be created", e);
-        } catch (IllegalAccessException e) {
-            throw createGSSException(p, className, "cannot be created", e);
-        } catch (SecurityException e) {
+        } catch (ClassNotFoundException | NoSuchMethodException |
+                 InvocationTargetException | InstantiationException |
+                 IllegalAccessException | SecurityException e) {
             throw createGSSException(p, className, "cannot be created", e);
         }
     }