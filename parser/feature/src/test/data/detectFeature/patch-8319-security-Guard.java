@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -32,7 +32,7 @@
  * <p>This interface contains a single method, {@code checkGuard},
  * with a single {@code object} argument. {@code checkGuard} is
  * invoked (by the GuardedObject {@code getObject} method)
- * to determine whether or not to allow access to the object.
+ * to determine whether to allow access to the object.
  *
  * @see GuardedObject
  *
@@ -44,7 +44,7 @@
 public interface Guard {
 
     /**
-     * Determines whether or not to allow access to the guarded object
+     * Determines whether to allow access to the guarded object
      * {@code object}. Returns silently if access is allowed.
      * Otherwise, throws a SecurityException.
      *