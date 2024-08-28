@@ -2640,14 +2640,7 @@ public static Set<String> getAvailableCalendarTypes() {
     }
 
     private static class AvailableCalendarTypes {
-        private static final Set<String> SET;
-        static {
-            Set<String> set = new HashSet<>(3);
-            set.add("gregory");
-            set.add("buddhist");
-            set.add("japanese");
-            SET = Collections.unmodifiableSet(set);
-        }
+        private static final Set<String> SET = Set.of("gregory", "buddhist", "japanese");
         private AvailableCalendarTypes() {
         }
     }