@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -76,6 +76,7 @@ class Field extends AccessibleObject implements Member {
     // Generics and annotations support
     private final transient String    signature;
     // generic info repository; lazily initialized
+    @Stable
     private transient FieldRepository genericInfo;
     private final byte[]              annotations;
     // Cached field accessor created without override
@@ -105,11 +106,13 @@ private GenericsFactory getFactory() {
 
     // Accessor for generic info repository
     private FieldRepository getGenericInfo() {
+        var genericInfo = this.genericInfo;
         // lazily initialize repository if necessary
         if (genericInfo == null) {
             // create and cache generic info repository
             genericInfo = FieldRepository.make(getGenericSignature(),
                                                getFactory());
+            this.genericInfo = genericInfo;
         }
         return genericInfo; //return cached repository
     }