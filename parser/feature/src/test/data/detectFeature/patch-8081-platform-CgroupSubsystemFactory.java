@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, Red Hat Inc.
+ * Copyright (c) 2020, 2022, Red Hat Inc.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -82,9 +82,7 @@ static CgroupMetrics create() {
         Optional<CgroupTypeResult> optResult = null;
         try {
             optResult = determineType("/proc/self/mountinfo", "/proc/cgroups", "/proc/self/cgroup");
-        } catch (IOException e) {
-            return null;
-        } catch (UncheckedIOException e) {
+        } catch (IOException | UncheckedIOException e) {
             return null;
         }
 