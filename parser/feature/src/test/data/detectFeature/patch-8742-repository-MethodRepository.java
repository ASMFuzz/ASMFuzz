@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -27,6 +27,7 @@
 
 
 import java.lang.reflect.Type;
+import jdk.internal.vm.annotation.Stable;
 import sun.reflect.generics.factory.GenericsFactory;
 import sun.reflect.generics.visitor.Reifier;
 
@@ -40,7 +41,8 @@
 public class MethodRepository extends ConstructorRepository {
 
     /** The generic return type info.  Lazily initialized. */
-    private volatile Type returnType;
+    @Stable
+    private Type returnType;
 
  // private, to enforce use of static factory
     private MethodRepository(String rawSig, GenericsFactory f) {