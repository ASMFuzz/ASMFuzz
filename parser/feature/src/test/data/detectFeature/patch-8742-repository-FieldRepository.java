@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -27,6 +27,7 @@
 
 
 import java.lang.reflect.Type;
+import jdk.internal.vm.annotation.Stable;
 import sun.reflect.generics.factory.GenericsFactory;
 import sun.reflect.generics.tree.TypeSignature;
 import sun.reflect.generics.parser.SignatureParser;
@@ -42,7 +43,8 @@
 public class FieldRepository extends AbstractRepository<TypeSignature> {
 
     /** The generic type info.  Lazily initialized. */
-    private volatile Type genericType;
+    @Stable
+    private Type genericType;
 
     // protected, to enforce use of static factory yet allow subclassing
     protected FieldRepository(String rawSig, GenericsFactory f) {