@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2012, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -46,7 +46,7 @@
  * @author      Sean Mullan
  * @since       1.4
  */
-public class Vertex {
+final class Vertex {
 
     private static final Debug debug = Debug.getInstance("certpath");
     private X509Certificate cert;