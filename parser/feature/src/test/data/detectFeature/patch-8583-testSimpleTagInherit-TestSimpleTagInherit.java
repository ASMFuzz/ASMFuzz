@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2013, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2013, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -35,16 +35,6 @@
 
 public class TestSimpleTagInherit extends JavadocTester {
 
-    //Javadoc arguments.
-    private static final String[] ARGS = new String[] {
-
-    };
-
-    //Input for string search tests.
-    private static final String[][] TEST = {
-        {  }
-    };
-
     public static void main(String... args) throws Exception {
         TestSimpleTagInherit tester = new TestSimpleTagInherit();
         tester.runTests();