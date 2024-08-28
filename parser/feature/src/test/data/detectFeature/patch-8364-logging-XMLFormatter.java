@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -175,7 +175,7 @@ public String format(LogRecord record) {
             // date field, using the ISO_INSTANT formatter.
             DateTimeFormatter.ISO_INSTANT.formatTo(instant, sb);
         } else {
-            // If useInstant is false - we will keep the 'old' formating
+            // If useInstant is false - we will keep the 'old' formatting
             appendISO8601(sb, instant.toEpochMilli());
         }
         sb.append("</date>\n");