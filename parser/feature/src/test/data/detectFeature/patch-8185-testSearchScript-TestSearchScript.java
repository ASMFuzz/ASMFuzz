@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2019, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2019, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -109,7 +109,7 @@ public void testModuleSearch() throws ScriptException, IOException, NoSuchMethod
                                         "mappkg.impl.MyMap.MyMap()", "mappkg.impl.MyMap.MyMap(Map)", "mappkg.system.property"));
         checkSearch(inv, "MAP", List.of("mapmodule", "mapmodule/mappkg", "mapmodule/mappkg.impl", "mappkg.Map", "mappkg.impl.MyMap",
                                         "mappkg.impl.MyMap.MyMap()", "mappkg.impl.MyMap.MyMap(Map)", "mappkg.system.property"));
-        checkSearch(inv, "value", List.of("mappkg.impl.MyMap.OTHER_VALUE", "mappkg.impl.MyMap.some_value"));
+        checkSearch(inv, "value", List.of("mappkg.impl.MyMap.some_value", "mappkg.impl.MyMap.OTHER_VALUE"));
         checkSearch(inv, "VALUE", List.of("mappkg.impl.MyMap.OTHER_VALUE", "mappkg.impl.MyMap.some_value"));
         checkSearch(inv, "map.other", List.of("mappkg.impl.MyMap.OTHER_VALUE"));
         checkSearch(inv, "Map.Some_", List.of("mappkg.impl.MyMap.some_value"));
@@ -167,13 +167,20 @@ public void testModuleSearch() throws ScriptException, IOException, NoSuchMethod
         // search tag
         checkSearch(inv, "search tag", List.of("search tag", "multiline search tag"));
         checkSearch(inv, "search   tag", List.of("search tag", "multiline search tag"));
-        checkSearch(inv, "search ", List.of("multiline search tag", "search tag"));
-        checkSearch(inv, "tag", List.of("multiline search tag", "search tag"));
-        checkSearch(inv, "sea", List.of("multiline search tag", "search tag"));
+        checkSearch(inv, "search ", List.of("search tag", "multiline search tag"));
+        checkSearch(inv, "tag", List.of("search tag", "multiline search tag"));
+        checkSearch(inv, "sea", List.of("search tag", "multiline search tag"));
         checkSearch(inv, "multi", List.of("multiline search tag"));
         checkSearch(inv, "ear", List.of());
-    }
 
+        // multiple space separated tokens
+        checkSearch(inv, "my map map", List.of("mappkg.impl.MyMap.MyMap(Map)", "mappkg.impl.MyMap.MyMap()"));
+        checkSearch(inv, "map get", List.of("mappkg.Map.get(Object)", "mappkg.impl.MyMap.get(Object)"));
+        checkSearch(inv, "get", List.of("mappkg.impl.MyMap.get(Object)", "mappkg.Map.get(Object)"));
+        checkSearch(inv, "get o", List.of("mappkg.Map.get(Object)", "mappkg.impl.MyMap.get(Object)"));
+        checkSearch(inv, "put o o", List.of("mappkg.Map.put(Object, Object)", "mappkg.impl.MyMap.put(Object, Object)"));
+        checkSearch(inv, "put(o o)", List.of("mappkg.Map.put(Object, Object)", "mappkg.impl.MyMap.put(Object, Object)"));
+    }
 
     @Test
     public void testPackageSource() throws ScriptException, IOException, NoSuchMethodException {
@@ -187,16 +194,16 @@ public void testPackageSource() throws ScriptException, IOException, NoSuchMetho
         Invocable inv = getEngine();
 
         // exact match, case sensitvity, left boundaries
-        checkSearch(inv, "list", List.of("listpkg", "listpkg.List", "listpkg.ListProvider", "listpkg.MyList",
-                                         "listpkg.MyListFactory", "listpkg.ListProvider.ListProvider()",
+        checkSearch(inv, "list", List.of("listpkg", "listpkg.List", "listpkg.MyList", "listpkg.ListProvider",
+                                         "listpkg.MyListFactory", "listpkg.MyList.MyList()",
                                          "listpkg.MyListFactory.createList(ListProvider, MyListFactory)",
-                                         "listpkg.ListProvider.makeNewList()",
-                                         "listpkg.MyList.MyList()", "listpkg.MyListFactory.MyListFactory()"));
-        checkSearch(inv, "List", List.of("listpkg", "listpkg.List", "listpkg.ListProvider", "listpkg.MyList",
-                                         "listpkg.MyListFactory", "listpkg.ListProvider.ListProvider()",
+                                         "listpkg.ListProvider.ListProvider()", "listpkg.ListProvider.makeNewList()",
+                                         "listpkg.MyListFactory.MyListFactory()"));
+        checkSearch(inv, "List", List.of("listpkg", "listpkg.List", "listpkg.MyList", "listpkg.ListProvider",
+                                         "listpkg.MyListFactory", "listpkg.MyList.MyList()",
                                          "listpkg.MyListFactory.createList(ListProvider, MyListFactory)",
-                                         "listpkg.ListProvider.makeNewList()",
-                                         "listpkg.MyList.MyList()", "listpkg.MyListFactory.MyListFactory()"));
+                                         "listpkg.ListProvider.ListProvider()", "listpkg.ListProvider.makeNewList()",
+                                         "listpkg.MyListFactory.MyListFactory()"));
         // partial match
         checkSearch(inv, "fact", List.of("listpkg.MyListFactory", "listpkg.MyListFactory.MyListFactory()"));
         checkSearch(inv, "pro", List.of("listpkg.ListProvider", "listpkg.ListProvider.ListProvider()"));
@@ -278,9 +285,9 @@ public void testPackageSource() throws ScriptException, IOException, NoSuchMetho
         checkSearch(inv, "some", List.of("listpkg.Nolist.SOME_INT_CONSTANT"));
         checkSearch(inv, "SOME", List.of("listpkg.Nolist.SOME_INT_CONSTANT"));
         checkSearch(inv, "Some", List.of("listpkg.Nolist.SOME_INT_CONSTANT"));
-        checkSearch(inv, "int", List.of("listpkg.Nolist.SOME_INT_CONSTANT"));
-        checkSearch(inv, "INT", List.of("listpkg.Nolist.SOME_INT_CONSTANT"));
-        checkSearch(inv, "Int", List.of("listpkg.Nolist.SOME_INT_CONSTANT"));
+        checkSearch(inv, "int", List.of("All Classes and Interfaces", "listpkg.Nolist.SOME_INT_CONSTANT"));
+        checkSearch(inv, "INT", List.of("All Classes and Interfaces", "listpkg.Nolist.SOME_INT_CONSTANT"));
+        checkSearch(inv, "Int", List.of("All Classes and Interfaces", "listpkg.Nolist.SOME_INT_CONSTANT"));
         checkSearch(inv, "int_con", List.of("listpkg.Nolist.SOME_INT_CONSTANT"));
         checkSearch(inv, "INT_CON", List.of("listpkg.Nolist.SOME_INT_CONSTANT"));
         checkSearch(inv, "NT", List.of());
@@ -289,9 +296,9 @@ public void testPackageSource() throws ScriptException, IOException, NoSuchMetho
         checkSearch(inv, "_CONST", List.of("listpkg.Nolist.SOME_INT_CONSTANT"));
 
         // Test for all packages, all classes links
-        checkSearch(inv, "all", List.of("All Packages", "All Classes"));
-        checkSearch(inv, "All", List.of("All Packages", "All Classes"));
-        checkSearch(inv, "ALL", List.of("All Packages", "All Classes"));
+        checkSearch(inv, "all", List.of("All Packages", "All Classes and Interfaces"));
+        checkSearch(inv, "All", List.of("All Packages", "All Classes and Interfaces"));
+        checkSearch(inv, "ALL", List.of("All Packages", "All Classes and Interfaces"));
 
         // test for generic types, var-arg and array args
         checkSearch(inv, "(map<string, ? ext collection>)",
@@ -303,14 +310,36 @@ public void testPackageSource() throws ScriptException, IOException, NoSuchMetho
         checkSearch(inv, "(e..", List.of("listpkg.List.of(E...)"));
         checkSearch(inv, "(int[]", List.of("listpkg.Nolist.withArrayArg(int[])"));
         checkSearch(inv, "(i[]", List.of("listpkg.Nolist.withArrayArg(int[])"));
+
+        // multiple space separated tokens
+        checkSearch(inv, "list of", List.of("listpkg.List.of()", "listpkg.List.of(E)",
+                "listpkg.List.of(E, E)", "listpkg.List.of(E, E, E)", "listpkg.List.of(E, E, E, E)",
+                "listpkg.List.of(E, E, E, E, E)", "listpkg.List.of(E...)"));
+        checkSearch(inv, "list of e", List.of("listpkg.List.of(E)", "listpkg.List.of(E, E)",
+                "listpkg.List.of(E, E, E)", "listpkg.List.of(E, E, E, E)",
+                "listpkg.List.of(E, E, E, E, E)", "listpkg.List.of(E...)"));
+        checkSearch(inv, "list of e e e", List.of("listpkg.List.of(E, E, E)",
+                "listpkg.List.of(E, E, E, E)", "listpkg.List.of(E, E, E, E, E)"));
+        checkSearch(inv, "list of e..", List.of("listpkg.List.of(E...)"));
+
+        checkSearch(inv, "list with", List.of());
+        checkSearch(inv, "nolist with", List.of("listpkg.Nolist.withVarArgs(Object...)",
+                "listpkg.Nolist.withArrayArg(int[])",
+                "listpkg.Nolist.withTypeParams(Map<String, ? extends Collection>)"));
+        checkSearch(inv, "with arg", List.of("listpkg.Nolist.withVarArgs(Object...)",
+                "listpkg.Nolist.withArrayArg(int[])"));
+        checkSearch(inv, "with int", List.of("listpkg.Nolist.withArrayArg(int[])"));
+        checkSearch(inv, "with map", List.of(
+                "listpkg.Nolist.withTypeParams(Map<String, ? extends Collection>)"));
+
     }
 
     void checkSearch(Invocable inv, String query, List<String> results) throws ScriptException, NoSuchMethodException {
-        checkList((List) inv.invokeFunction("search", query), results);
+        checkList(query, (List<?>) inv.invokeFunction("search", query), results);
     }
 
-    void checkList(List<?> result, List<?> expected) {
-        checking("Checking list: " + result);
+    void checkList(String query, List<?> result, List<?> expected) {
+        checking("Checking resut for query \"" + query + "\"");
         if (!expected.equals(result)) {
             failed("Expected: " + expected + ", got: " + result);
         } else {
@@ -320,7 +349,7 @@ void checkList(List<?> result, List<?> expected) {
 
     void checkNullSearch(Invocable inv, String query) throws ScriptException, NoSuchMethodException {
         Object result = inv.invokeFunction("search", query);
-        checking("Checking null result");
+        checking("Checking result for query \"" + query + "\"");
         if (result == null) {
             passed("Result is null as expected");
         } else {