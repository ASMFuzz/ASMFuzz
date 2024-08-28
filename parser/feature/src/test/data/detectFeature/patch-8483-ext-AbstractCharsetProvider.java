@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -31,7 +31,6 @@
 import java.util.ArrayList;
 import java.util.TreeMap;
 import java.util.Iterator;
-import java.util.Locale;
 import java.util.Map;
 
 
@@ -75,14 +74,6 @@ protected AbstractCharsetProvider(String pkgPrefixName) {
         packagePrefix = pkgPrefixName.concat(".");
     }
 
-    /* Add an entry to the given map, but only if no mapping yet exists
-     * for the given name.
-     */
-    private static <K,V> void put(Map<K,V> m, K name, V value) {
-        if (!m.containsKey(name))
-            m.put(name, value);
-    }
-
     private static <K,V> void remove(Map<K,V> m, K name) {
         V x  = m.remove(name);
         assert (x != null);
@@ -92,10 +83,10 @@ private static <K,V> void remove(Map<K,V> m, K name) {
      */
     protected void charset(String name, String className, String[] aliases) {
         synchronized (this) {
-            put(classMap, name, className);
+            classMap.putIfAbsent(name, className);
             for (int i = 0; i < aliases.length; i++)
-                put(aliasMap, aliases[i], name);
-            put(aliasNameMap, name, aliases);
+                aliasMap.putIfAbsent(aliases[i], name);
+            aliasNameMap.putIfAbsent(name, aliases);
             cache.clear();
         }
     }