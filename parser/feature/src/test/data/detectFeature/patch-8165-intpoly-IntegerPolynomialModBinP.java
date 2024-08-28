@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -38,7 +38,7 @@
  * This class may only be used for primes of the form 2^a + b.
  */
 
-public class IntegerPolynomialModBinP extends IntegerPolynomial {
+public sealed class IntegerPolynomialModBinP extends IntegerPolynomial {
 
     private final long[] reduceLimbs;
     private final int bitOffset;
@@ -206,7 +206,7 @@ protected void square(long[] a, long[] r) {
     /**
      * The field of integers modulo the order of the Curve25519 subgroup
      */
-    public static class Curve25519OrderField extends IntegerPolynomialModBinP {
+    public final static class Curve25519OrderField extends IntegerPolynomialModBinP {
 
         public Curve25519OrderField() {
             super(26, 10, 252,
@@ -217,7 +217,7 @@ public Curve25519OrderField() {
     /**
      * The field of integers modulo the order of the Curve448 subgroup
      */
-    public static class Curve448OrderField extends IntegerPolynomialModBinP {
+    public final static class Curve448OrderField extends IntegerPolynomialModBinP {
 
         public Curve448OrderField() {
             super(28, 16, 446,