@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -351,7 +351,7 @@ public static TemporalAdjuster dayOfWeekInMonth(int ordinal, DayOfWeek dayOfWeek
                 Temporal temp = temporal.with(DAY_OF_MONTH, 1);
                 int curDow = temp.get(DAY_OF_WEEK);
                 int dowDiff = (dowValue - curDow + 7) % 7;
-                dowDiff += (ordinal - 1L) * 7L;  // safe from overflow
+                dowDiff += (int) ((ordinal - 1L) * 7L);  // safe from overflow
                 return temp.plus(dowDiff, DAYS);
             };
         } else {
@@ -360,7 +360,7 @@ public static TemporalAdjuster dayOfWeekInMonth(int ordinal, DayOfWeek dayOfWeek
                 int curDow = temp.get(DAY_OF_WEEK);
                 int daysDiff = dowValue - curDow;
                 daysDiff = (daysDiff == 0 ? 0 : (daysDiff > 0 ? daysDiff - 7 : daysDiff));
-                daysDiff -= (-ordinal - 1L) * 7L;  // safe from overflow
+                daysDiff -= (int) ((-ordinal - 1L) * 7L);  // safe from overflow
                 return temp.plus(daysDiff, DAYS);
             };
         }