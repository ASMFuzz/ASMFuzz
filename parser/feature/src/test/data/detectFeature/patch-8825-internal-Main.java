@@ -65,7 +65,7 @@ public String name() {
         @Override
         public Optional<String> description() {
             TaskHelper taskHelper = new TaskHelper(TaskHelper.JLINK_BUNDLE);
-            return Optional.of(taskHelper.getMessage("jlink.desciption"));
+            return Optional.of(taskHelper.getMessage("jlink.description"));
         }
 
         @Override