@@ -847,19 +847,24 @@ private static Map<String, Object> extractCalendarData(Map<String, Object> map,
         "DateTimePatternChars",
         "PluralRules",
         "DayPeriodRules",
-        "DateFormatItem",
+        "DateFormatItemInputRegions.allowed",
+        "DateFormatItemInputRegions.preferred",
     };
 
+    static final Set<String> availableSkeletons = new HashSet<>();
+
     private static Map<String, Object> extractFormatData(Map<String, Object> map, String id) {
         Map<String, Object> formatData = new LinkedHashMap<>();
         for (CalendarType calendarType : CalendarType.values()) {
             String prefix = calendarType.keyElementName();
             Arrays.stream(FORMAT_DATA_ELEMENTS)
-                .flatMap(elem -> map.keySet().stream().filter(k -> k.startsWith(prefix + elem)))
-                .forEach(key -> {
+                .forEach(elem -> {
+                    var key = prefix + elem;
                     copyIfPresent(map, "java.time." + key, formatData);
                     copyIfPresent(map, key, formatData);
                 });
+            availableSkeletons.forEach(s ->
+                copyIfPresent(map, prefix + "DateFormatItem." + s, formatData));
         }
 
         for (String key : map.keySet()) {