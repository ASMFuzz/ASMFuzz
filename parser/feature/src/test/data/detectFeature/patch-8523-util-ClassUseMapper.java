@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1998, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1998, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -60,7 +60,7 @@
  */
 public class ClassUseMapper {
 
-    private final ClassTree classtree;
+    private final ClassTree classTree;
 
     /**
      * Mapping of TypeElements to set of PackageElements used by that class.
@@ -192,19 +192,19 @@ public class ClassUseMapper {
     private final Utils utils;
     private final Comparators comparators;
 
-    public ClassUseMapper(BaseConfiguration configuration, ClassTree classtree) {
+    public ClassUseMapper(BaseConfiguration configuration, ClassTree classTree) {
         docEnv = configuration.docEnv;
         elementUtils = docEnv.getElementUtils();
         typeUtils = docEnv.getTypeUtils();
         utils = configuration.utils;
         comparators = utils.comparators;
-        this.classtree = classtree;
+        this.classTree = classTree;
         classToPackage = new TreeMap<>(comparators.makeClassUseComparator());
         // Map subclassing, subinterfacing implementing, ...
-        for (TypeElement te : classtree.baseClasses()) {
+        for (TypeElement te : classTree.classes().roots()) {
             subclasses(te);
         }
-        for (TypeElement intfc : classtree.baseInterfaces()) {
+        for (TypeElement intfc : classTree.interfaces().roots()) {
             // does subinterfacing as a side-effect
             implementingClasses(intfc);
         }
@@ -286,7 +286,7 @@ private Collection<TypeElement> subclasses(TypeElement te) {
         Collection<TypeElement> ret = classToSubclass.get(te);
         if (ret == null) {
             ret = new TreeSet<>(comparators.makeClassUseComparator());
-            Set<TypeElement> subs = classtree.subClasses(te);
+            Set<TypeElement> subs = classTree.subClasses(te);
             if (subs != null) {
                 ret.addAll(subs);
                 for (TypeElement sub : subs) {
@@ -305,7 +305,7 @@ private Collection<TypeElement> subinterfaces(TypeElement te) {
         Collection<TypeElement> ret = classToSubinterface.get(te);
         if (ret == null) {
             ret = new TreeSet<>(comparators.makeClassUseComparator());
-            Set<TypeElement> subs = classtree.subInterfaces(te);
+            Set<TypeElement> subs = classTree.subInterfaces(te);
             if (subs != null) {
                 ret.addAll(subs);
                 for (TypeElement sub : subs) {
@@ -326,7 +326,7 @@ private Collection<TypeElement> implementingClasses(TypeElement te) {
         Collection<TypeElement> ret = classToImplementingClass.get(te);
         if (ret == null) {
             ret = new TreeSet<>(comparators.makeClassUseComparator());
-            Set<TypeElement> impl = classtree.implementingClasses(te);
+            Set<TypeElement> impl = classTree.implementingClasses(te);
             if (impl != null) {
                 ret.addAll(impl);
                 for (TypeElement anImpl : impl) {