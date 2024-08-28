@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -36,6 +36,7 @@
 import jdk.internal.vm.annotation.Stable;
 import sun.reflect.annotation.ExceptionProxy;
 import sun.reflect.annotation.TypeNotPresentExceptionProxy;
+import sun.reflect.generics.repository.GenericDeclRepository;
 import sun.reflect.generics.repository.MethodRepository;
 import sun.reflect.generics.factory.CoreReflectionFactory;
 import sun.reflect.generics.factory.GenericsFactory;
@@ -254,7 +255,7 @@ public TypeVariable<Method>[] getTypeParameters() {
         if (getGenericSignature() != null)
             return (TypeVariable<Method>[])getGenericInfo().getTypeParameters();
         else
-            return (TypeVariable<Method>[])new TypeVariable[0];
+            return (TypeVariable<Method>[])GenericDeclRepository.EMPTY_TYPE_VARS;
     }
 
     /**