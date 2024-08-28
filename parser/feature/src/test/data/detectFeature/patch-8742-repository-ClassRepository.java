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
 import sun.reflect.generics.tree.ClassSignature;
 import sun.reflect.generics.tree.TypeTree;
@@ -43,10 +44,12 @@ public class ClassRepository extends GenericDeclRepository<ClassSignature> {
     public static final ClassRepository NONE = ClassRepository.make("Ljava/lang/Object;", null);
 
     /** The generic superclass info.  Lazily initialized. */
-    private volatile Type superclass;
+    @Stable
+    private Type superclass;
 
     /** The generic superinterface info.  Lazily initialized. */
-    private volatile Type[] superInterfaces;
+    @Stable
+    private Type[] superInterfaces;
 
     // private, to enforce use of static factory
     private ClassRepository(String rawSig, GenericsFactory f) {