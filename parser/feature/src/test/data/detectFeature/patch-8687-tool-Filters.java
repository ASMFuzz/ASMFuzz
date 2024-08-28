@@ -39,7 +39,6 @@
  * Helper class for creating filters.
  */
 public class Filters {
-    private static final Predicate<RecordedThread> FALSE_THREAD_PREDICATE = e -> false;
 
     static Predicate<EventType> createCategoryFilter(String filterText) throws UserSyntaxException {
         List<String> filters = explodeFilter(filterText);