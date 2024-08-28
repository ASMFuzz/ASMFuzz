@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,12 +25,9 @@
 
 package java.security;
 
+import java.io.FilterOutputStream;
 import java.io.IOException;
-import java.io.EOFException;
 import java.io.OutputStream;
-import java.io.FilterOutputStream;
-import java.io.PrintStream;
-import java.io.ByteArrayOutputStream;
 
 /**
  * A transparent stream that updates the associated message digest using