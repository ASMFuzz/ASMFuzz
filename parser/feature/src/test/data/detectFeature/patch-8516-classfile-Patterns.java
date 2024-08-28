@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2009, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2009, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -28,10 +28,12 @@
  * @modules java.compiler
  *          jdk.jdeps/com.sun.tools.javap
  * @build toolbox.JavapTask
- * @run main Patterns
+ * @compile --enable-preview -source ${jdk.version} Patterns.java
+ * @run main/othervm --enable-preview Patterns
  */
 
 import java.lang.annotation.*;
+import java.util.List;
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;
 import java.util.stream.Collectors;
@@ -45,10 +47,11 @@ public class Patterns {
     private ToolBox tb = new ToolBox();
 
     public static void main(String[] args) throws Exception {
-        new Patterns().run();
+        new Patterns().runBinding();
+        new Patterns().runDeconstruction();
     }
 
-    public void run() throws Exception {
+    public void runBinding() throws Exception {
         String out = new JavapTask(tb)
                 .options("-private",
                          "-verbose")
@@ -161,6 +164,132 @@ public void run() throws Exception {
         }
     }
 
+    public void runDeconstruction() throws Exception {
+        List<String> outLines = new JavapTask(tb)
+                .options("-private",
+                         "-verbose")
+                .classpath(System.getProperty("test.classes"))
+                .classes("Patterns$DeconstructionPattern")
+                .run()
+                .getOutputLines(Task.OutputKind.DIRECT);
+
+        String out = clearCodeAttribute(outLines);
+        String constantPool = out.substring(0, out.indexOf('{'));
+
+        out = out.substring(out.indexOf('{'));
+        out = out.substring(0, out.lastIndexOf('}') + 1);
+
+        String A = snipCPNumber(constantPool, "LPatterns$DeconstructionPattern$A;");
+        String CA = snipCPNumber(constantPool, "LPatterns$DeconstructionPattern$CA;");
+        String value = snipCPNumber(constantPool, "value");
+
+        String expected = """
+                          {
+                            private static final java.lang.Object o;
+                              descriptor: Ljava/lang/Object;
+                              flags: (0x001a) ACC_PRIVATE, ACC_STATIC, ACC_FINAL
+
+                            private static final boolean B1s;
+                              descriptor: Z
+                              flags: (0x001a) ACC_PRIVATE, ACC_STATIC, ACC_FINAL
+
+                            private static final boolean B1m;
+                              descriptor: Z
+                              flags: (0x001a) ACC_PRIVATE, ACC_STATIC, ACC_FINAL
+
+                            private final boolean B2s;
+                              descriptor: Z
+                              flags: (0x0012) ACC_PRIVATE, ACC_FINAL
+
+                            private final boolean B2m;
+                              descriptor: Z
+                              flags: (0x0012) ACC_PRIVATE, ACC_FINAL
+
+                            public Patterns$DeconstructionPattern();
+                              descriptor: ()V
+                              flags: (0x0001) ACC_PUBLIC
+                                RuntimeInvisibleTypeAnnotations:
+                                  0: #_A_(): LOCAL_VARIABLE, {start_pc=251, length=11, index=2}
+                                    Patterns$DeconstructionPattern$A
+                                  1: #_CA_(#_value_=[@#_A_(),@#_A_()]): LOCAL_VARIABLE, {start_pc=290, length=11, index=3}
+                                    Patterns$DeconstructionPattern$CA(
+                                      value=[@Patterns$DeconstructionPattern$A,@Patterns$DeconstructionPattern$A]
+                                    )
+                                  2: #_A_(): LOCAL_VARIABLE, {start_pc=26, length=11, index=1}
+                                    Patterns$DeconstructionPattern$A
+                                  3: #_CA_(#_value_=[@#_A_(),@#_A_()]): LOCAL_VARIABLE, {start_pc=63, length=11, index=1}
+                                    Patterns$DeconstructionPattern$CA(
+                                      value=[@Patterns$DeconstructionPattern$A,@Patterns$DeconstructionPattern$A]
+                                    )
+                                  4: #_A_(): LOCAL_VARIABLE, {start_pc=101, length=11, index=2}
+                                    Patterns$DeconstructionPattern$A
+                                  5: #_CA_(#_value_=[@#_A_(),@#_A_()]): LOCAL_VARIABLE, {start_pc=140, length=11, index=3}
+                                    Patterns$DeconstructionPattern$CA(
+                                      value=[@Patterns$DeconstructionPattern$A,@Patterns$DeconstructionPattern$A]
+                                    )
+                                  6: #_A_(): LOCAL_VARIABLE, {start_pc=176, length=11, index=2}
+                                    Patterns$DeconstructionPattern$A
+                                  7: #_CA_(#_value_=[@#_A_(),@#_A_()]): LOCAL_VARIABLE, {start_pc=215, length=11, index=3}
+                                    Patterns$DeconstructionPattern$CA(
+                                      value=[@Patterns$DeconstructionPattern$A,@Patterns$DeconstructionPattern$A]
+                                    )
+
+                            void testPatterns();
+                              descriptor: ()V
+                              flags: (0x0000)
+                                RuntimeInvisibleTypeAnnotations:
+                                  0: #_A_(): LOCAL_VARIABLE, {start_pc=23, length=11, index=2}
+                                    Patterns$DeconstructionPattern$A
+                                  1: #_CA_(#_value_=[@#_A_(),@#_A_()]): LOCAL_VARIABLE, {start_pc=62, length=11, index=3}
+                                    Patterns$DeconstructionPattern$CA(
+                                      value=[@Patterns$DeconstructionPattern$A,@Patterns$DeconstructionPattern$A]
+                                    )
+
+                            static java.lang.String $proxy$s(Patterns$DeconstructionPattern$R);
+                              descriptor: (LPatterns$DeconstructionPattern$R;)Ljava/lang/String;
+                              flags: (0x1008) ACC_STATIC, ACC_SYNTHETIC
+
+                            static {};
+                              descriptor: ()V
+                              flags: (0x0008) ACC_STATIC
+                                RuntimeInvisibleTypeAnnotations:
+                                  0: #_A_(): LOCAL_VARIABLE, {start_pc=26, length=11, index=0}
+                                    Patterns$DeconstructionPattern$A
+                                  1: #_CA_(#_value_=[@#_A_(),@#_A_()]): LOCAL_VARIABLE, {start_pc=62, length=11, index=0}
+                                    Patterns$DeconstructionPattern$CA(
+                                      value=[@Patterns$DeconstructionPattern$A,@Patterns$DeconstructionPattern$A]
+                                    )
+                                  2: #_A_(): LOCAL_VARIABLE, {start_pc=98, length=11, index=1}
+                                    Patterns$DeconstructionPattern$A
+                                  3: #_CA_(#_value_=[@#_A_(),@#_A_()]): LOCAL_VARIABLE, {start_pc=134, length=11, index=2}
+                                    Patterns$DeconstructionPattern$CA(
+                                      value=[@Patterns$DeconstructionPattern$A,@Patterns$DeconstructionPattern$A]
+                                    )
+                          }""".replace("_A_", A).replace("_CA_", CA).replace("_value_", value);
+
+        if (!expected.equals(out)) {
+            throw new AssertionError("Unexpected output:\n" + out + "\nexpected:\n" + expected);
+        }
+    }
+
+    private String clearCodeAttribute(List<String> out) {
+        StringBuilder result = new StringBuilder();
+        boolean codeSeen = false;
+
+        for (String line : out) {
+            if (line.contains("    Code:")) {
+                codeSeen = true;
+            } else if (codeSeen && line.startsWith("      ") &&
+                       !line.contains("RuntimeInvisibleTypeAnnotations")) {
+                //ignore
+            } else {
+                result.append(line).append("\n");
+                codeSeen = false;
+            }
+        }
+
+        return result.toString();
+    }
     private String snipCPNumber(String constantPool, String expectedConstant) {
         Matcher m = Pattern.compile("#([0-9]+).*" + Pattern.quote(expectedConstant))
                            .matcher(constantPool);
@@ -218,4 +347,47 @@ void testPatternsDesugared() {
             boolean B8sx = o instanceof String && (s = (String) o) == s && s.isEmpty();
         }
     }
+
+    static class DeconstructionPattern {
+        @Target(ElementType.TYPE_USE)
+        @Repeatable(CA.class)
+        @interface A {}
+        @Target(ElementType.TYPE_USE)
+        @interface CA {
+            public A[] value();
+        }
+
+        private static final Object o = "";
+        private static final boolean B1s = o instanceof R(@A String s) && s.isEmpty();
+        private static final boolean B1m = o instanceof R(@A @A String s) && s.isEmpty();
+        private final boolean B2s = o instanceof R(@A String s) && s.isEmpty();
+        private final boolean B2m = o instanceof R(@A @A String s) && s.isEmpty();
+
+        static {
+            boolean B3s = o instanceof R(@A String s) && s.isEmpty();
+            boolean B3m = o instanceof R(@A @A String s) && s.isEmpty();
+        }
+
+        {
+            boolean B4s = o instanceof R(@A String s) && s.isEmpty();
+            boolean B4m = o instanceof R(@A @A String s) && s.isEmpty();
+        }
+
+        {
+            boolean B5s = o instanceof R(@A String s) && s.isEmpty();
+            boolean B5m = o instanceof R(@A @A String s) && s.isEmpty();
+        }
+
+        public DeconstructionPattern() {
+            boolean B6s = o instanceof R(@A String s) && s.isEmpty();
+            boolean B6m = o instanceof R(@A @A String s) && s.isEmpty();
+        }
+
+        void testPatterns() {
+            boolean B7s = o instanceof R(@A String s) && s.isEmpty();
+            boolean B7m = o instanceof R(@A @A String s) && s.isEmpty();
+        }
+
+        record R(String s) {}
+    }
 }