@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -566,8 +566,7 @@ public static Charset forName(String charsetName,
     private static void put(Iterator<Charset> i, Map<String,Charset> m) {
         while (i.hasNext()) {
             Charset cs = i.next();
-            if (!m.containsKey(cs.name()))
-                m.put(cs.name(), cs);
+            m.putIfAbsent(cs.name(), cs);
         }
     }
 