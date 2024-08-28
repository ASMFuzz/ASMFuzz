@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2002, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2002, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -1567,7 +1567,7 @@ static int getNumberOfButtonsForMask() {
     @Override
     protected Object lazilyLoadDesktopProperty(String name) {
         if (name.startsWith(prefix)) {
-            String cursorName = name.substring(prefix.length(), name.length()) + postfix;
+            String cursorName = name.substring(prefix.length()) + postfix;
 
             try {
                 return Cursor.getSystemCustomCursor(cursorName);