@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2012, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -277,9 +277,7 @@ public Method run() throws Exception {
 
             return deserialize.invoke(null, this);
         } catch (ReflectiveOperationException roe) {
-            ObjectStreamException ose = new InvalidObjectException("ReflectiveOperationException during deserialization");
-            ose.initCause(roe);
-            throw ose;
+            throw new InvalidObjectException("ReflectiveOperationException during deserialization", roe);
         } catch (PrivilegedActionException e) {
             Exception cause = e.getException();
             if (cause instanceof RuntimeException)