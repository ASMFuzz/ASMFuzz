@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2021, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -38,6 +38,7 @@
 import java.lang.invoke.MethodHandles;
 import java.lang.invoke.MethodHandles.Lookup;
 import java.lang.invoke.MethodType;
+import java.lang.ref.Reference;
 
 import sun.hotspot.WhiteBox;
 
@@ -48,14 +49,14 @@ final class MyClass {
 
 public class TestHiddenClassIsAlive {
 
-
     public static void main(String[] args) throws Throwable {
         byte[] classBytes = readClassFile("MyClass.class");
         Lookup lookup = MethodHandles.lookup();
         Class<?> c = lookup.defineHiddenClass(classBytes, true).lookupClass();
         if (!WhiteBox.getWhiteBox().isClassAlive("MyClass")) {
             throw new RuntimeException("Hidden class should be alive");
         }
+        Reference.reachabilityFence(c);
     }
 
     static byte[] readClassFile(String classFileName) throws Exception {