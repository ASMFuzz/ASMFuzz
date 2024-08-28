@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, 2021, Red Hat Inc.
+ * Copyright (c) 2020, 2022, Red Hat Inc.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -332,9 +332,7 @@ private long sumTokensIOStat(Function<String, Long> mapFunc) {
             return CgroupUtil.readFilePrivileged(Paths.get(unified.path(), "io.stat"))
                                 .map(mapFunc)
                                 .collect(Collectors.summingLong(e -> e));
-        } catch (UncheckedIOException e) {
-            return CgroupSubsystem.LONG_RETVAL_UNLIMITED;
-        } catch (IOException e) {
+        } catch (UncheckedIOException | IOException e) {
             return CgroupSubsystem.LONG_RETVAL_UNLIMITED;
         }
     }