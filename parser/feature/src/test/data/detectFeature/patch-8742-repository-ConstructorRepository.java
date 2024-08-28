@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -26,6 +26,7 @@
 package sun.reflect.generics.repository;
 
 import java.lang.reflect.Type;
+import jdk.internal.vm.annotation.Stable;
 import sun.reflect.generics.factory.GenericsFactory;
 import sun.reflect.generics.parser.SignatureParser;
 import sun.reflect.generics.tree.FieldTypeSignature;
@@ -44,10 +45,12 @@ public class ConstructorRepository
     extends GenericDeclRepository<MethodTypeSignature> {
 
     /** The generic parameter types.  Lazily initialized. */
-    private volatile Type[] parameterTypes;
+    @Stable
+    private Type[] parameterTypes;
 
     /** The generic exception types.  Lazily initialized. */
-    private volatile Type[] exceptionTypes;
+    @Stable
+    private Type[] exceptionTypes;
 
     // protected, to enforce use of static factory yet allow subclassing
     protected ConstructorRepository(String rawSig, GenericsFactory f) {