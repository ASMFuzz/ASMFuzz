@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -243,13 +243,7 @@ public Object instantiate(Class<?> theClass)
             throw new ReflectionException(new
                 NoSuchMethodException("No constructor"),
                                           "No such constructor");
-        } catch (InstantiationException e) {
-            throw new ReflectionException(e,
-            "Exception thrown trying to invoke the MBean's empty constructor");
-        } catch (IllegalAccessException e) {
-            throw new ReflectionException(e,
-            "Exception thrown trying to invoke the MBean's empty constructor");
-        } catch (IllegalArgumentException e) {
+        } catch (InstantiationException | IllegalArgumentException | IllegalAccessException e) {
             throw new ReflectionException(e,
             "Exception thrown trying to invoke the MBean's empty constructor");
         }
@@ -308,11 +302,7 @@ public Object instantiate(Class<?> theClass, Object params[],
                 NoSuchMethodException("No such constructor found"),
                                           "No such constructor" );
         }
-        catch (InstantiationException e) {
-            throw new ReflectionException(e,
-                "Exception thrown trying to invoke the MBean's constructor");
-        }
-        catch (IllegalAccessException e) {
+        catch (InstantiationException | IllegalAccessException e) {
             throw new ReflectionException(e,
                 "Exception thrown trying to invoke the MBean's constructor");
         }