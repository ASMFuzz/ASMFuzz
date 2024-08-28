@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2008, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2008, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -238,7 +238,7 @@ static boolean verifyConstants() {
                 throw new InternalError(err);
             } catch (NoSuchFieldException | IllegalAccessException ex) {
                 String err = (name+": JVM has "+vmval+" which Java does not define");
-                // ignore exotic ops the JVM cares about; we just wont issue them
+                // ignore exotic ops the JVM cares about; we just won't issue them
                 //System.err.println("warning: "+err);
                 continue;
             }