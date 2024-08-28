@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2021, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -27,6 +27,9 @@
 import compiler.lib.ir_framework.shared.TestRunException;
 import jdk.test.lib.Asserts;
 
+import java.io.ByteArrayOutputStream;
+import java.io.PrintStream;
+
 /*
  * @test
  * @requires vm.debug == true & vm.compMode != "Xint" & vm.compiler2.enabled & vm.flagless
@@ -37,35 +40,35 @@
 
 public class TestScenarios {
     public static void main(String[] args) {
+        ByteArrayOutputStream baos = new ByteArrayOutputStream();
+        PrintStream ps = new PrintStream(baos);
+        PrintStream oldOut = System.out;
+        System.setOut(ps);
+
         Scenario sDefault = new Scenario(0);
         Scenario s1 = new Scenario(1, "-XX:TLABRefillWasteFraction=51");
         Scenario s2 = new Scenario(2, "-XX:TLABRefillWasteFraction=52");
         Scenario s3 = new Scenario(3, "-XX:TLABRefillWasteFraction=53");
         Scenario s3dup = new Scenario(3, "-XX:TLABRefillWasteFraction=53");
         try {
             new TestFramework().addScenarios(sDefault, s1, s2, s3).start();
-            if (Utils.notAllBailedOut(sDefault, s1, s3)) {
-                // Not all scenarios had a bailout which means that at least one exception should have been thrown.
-                Asserts.fail("Should have thrown an exception");
-            }
+            Utils.shouldHaveThrownException(baos.toString());
         } catch (TestRunException e) {
             if (!e.getMessage().contains("The following scenarios have failed: #0, #1, #3")) {
-                // Was there a bailout in a scenario? If not fail.
-                Asserts.assertTrue(Utils.anyBailedOut(sDefault, s1, s3), e.getMessage());
+                Utils.throwIfNoSafepointPrinting(baos.toString(), e);
             }
         }
+
+        baos.reset();
         try {
             new TestFramework().addScenarios(s1, s2, s3).start();
-            if (Utils.notAllBailedOut(s1, s3)) {
-                // Not all scenarios had a bailout which means that at least one exception should have been thrown.
-                Asserts.fail("Should have thrown an exception");
-            }
+            Utils.shouldHaveThrownException(baos.toString());
         } catch (TestRunException e) {
             if (!e.getMessage().contains("The following scenarios have failed: #1, #3")) {
-                // Was there a bailout in a scenario? If not fail.
-                Asserts.assertTrue(Utils.anyBailedOut(sDefault, s1, s3), e.getMessage());
+                Utils.throwIfNoSafepointPrinting(baos.toString(), e);
             }
         }
+        System.setOut(oldOut);
         new TestFramework(ScenarioTest.class).addScenarios(s1, s2, s3).start();
         try {
             new TestFramework().addScenarios(s1, s3dup, s2, s3).start();