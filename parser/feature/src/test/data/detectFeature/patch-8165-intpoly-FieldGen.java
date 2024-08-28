@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -614,7 +614,7 @@ private String generate(FieldParams params) throws IOException {
         }
         result.appendLine("import java.math.BigInteger;");
 
-        result.appendLine("public class " + params.getClassName()
+        result.appendLine("public final class " + params.getClassName()
                 + " extends " + this.parentName + " {");
         result.incrIndent();
 