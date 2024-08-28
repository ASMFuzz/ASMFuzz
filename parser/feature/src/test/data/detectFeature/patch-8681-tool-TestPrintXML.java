@@ -138,9 +138,13 @@ static boolean compare(Object eventObject, Object xmlObject) {
                 Object xmlValue = xmlMap.get(name);
                 Object expectedValue = re.getValue(name);
                 if (v.getAnnotation(Timestamp.class) != null) {
-                    // Make instant of OffsetDateTime
-                    xmlValue = OffsetDateTime.parse("" + xmlValue).toInstant().toString();
-                    expectedValue = re.getInstant(name);
+                    if (expectedValue.equals(Long.MIN_VALUE)) { // Missing
+                        expectedValue = OffsetDateTime.MIN;
+                    } else {
+                        // Make instant of OffsetDateTime
+                        xmlValue = OffsetDateTime.parse("" + xmlValue).toInstant().toString();
+                        expectedValue = re.getInstant(name);
+                    }
                 }
                 if (v.getAnnotation(Timespan.class) != null) {
                     expectedValue = re.getDuration(name);