@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -35,6 +35,7 @@
 import sun.reflect.annotation.TypeAnnotation;
 import sun.reflect.annotation.TypeAnnotationParser;
 import sun.reflect.generics.repository.ConstructorRepository;
+import sun.reflect.generics.repository.GenericDeclRepository;
 import sun.reflect.generics.factory.CoreReflectionFactory;
 import sun.reflect.generics.factory.GenericsFactory;
 import sun.reflect.generics.scope.ConstructorScope;
@@ -244,7 +245,7 @@ public TypeVariable<Constructor<T>>[] getTypeParameters() {
       if (getSignature() != null) {
         return (TypeVariable<Constructor<T>>[])getGenericInfo().getTypeParameters();
       } else
-          return (TypeVariable<Constructor<T>>[])new TypeVariable[0];
+          return (TypeVariable<Constructor<T>>[])GenericDeclRepository.EMPTY_TYPE_VARS;
     }
 
 