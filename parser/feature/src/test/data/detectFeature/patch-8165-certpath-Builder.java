@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -50,7 +50,7 @@
  * @author      Yassir Elley
  */
 
-public abstract class Builder {
+abstract class Builder {
 
     private static final Debug debug = Debug.getInstance("certpath");
     private Set<String> matchingPolicies;