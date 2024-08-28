@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2019, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2019, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -26,6 +26,7 @@
 package java.lang.reflect;
 
 import jdk.internal.access.SharedSecrets;
+import jdk.internal.vm.annotation.Stable;
 import sun.reflect.annotation.AnnotationParser;
 import sun.reflect.annotation.TypeAnnotation;
 import sun.reflect.annotation.TypeAnnotationParser;
@@ -54,6 +55,7 @@ public final class RecordComponent implements AnnotatedElement {
     private Method accessor;
     private String signature;
     // generic info repository; lazily initialized
+    @Stable
     private transient FieldRepository genericInfo;
     private byte[] annotations;
     private byte[] typeAnnotations;
@@ -127,10 +129,12 @@ public Type getGenericType() {
 
     // Accessor for generic info repository
     private FieldRepository getGenericInfo() {
+        var genericInfo = this.genericInfo;
         // lazily initialize repository if necessary
         if (genericInfo == null) {
             // create and cache generic info repository
             genericInfo = FieldRepository.make(getGenericSignature(), getFactory());
+            this.genericInfo = genericInfo;
         }
         return genericInfo; //return cached repository
     }