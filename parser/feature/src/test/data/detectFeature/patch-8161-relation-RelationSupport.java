@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2017, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -30,7 +30,6 @@
 import java.lang.System.Logger.Level;
 import java.util.ArrayList;
 import java.util.HashMap;
-import java.util.Iterator;
 import java.util.Map;
 import java.util.List;
 
@@ -1147,14 +1146,11 @@ Object setRoleInt(Role aRole,
                 throw new RuntimeException(wrappedExc.getMessage());
             }
 
-        } catch (ReflectionException exc3) {
+        } catch (ReflectionException | RelationTypeNotFoundException exc3) {
             throw new RuntimeException(exc3.getMessage());
 
-        } catch (RelationTypeNotFoundException exc4) {
-            throw new RuntimeException(exc4.getMessage());
-
-        } catch (InstanceNotFoundException exc5) {
-            throw new RelationServiceNotRegisteredException(exc5.getMessage());
+        } catch (InstanceNotFoundException exc4) {
+            throw new RelationServiceNotRegisteredException(exc4.getMessage());
         }
 
         Object result = null;