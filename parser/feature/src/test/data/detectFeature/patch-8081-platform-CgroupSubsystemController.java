@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, Red Hat Inc.
+ * Copyright (c) 2020, 2022, Red Hat Inc.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -170,9 +170,7 @@ public static long getLongEntry(CgroupSubsystemController controller, String par
                                            .findFirst();
 
             return result.isPresent() ? Long.parseLong(result.get()) : defaultRetval;
-        } catch (UncheckedIOException e) {
-            return defaultRetval;
-        } catch (IOException e) {
+        } catch (UncheckedIOException | IOException e) {
             return defaultRetval;
         }
     }