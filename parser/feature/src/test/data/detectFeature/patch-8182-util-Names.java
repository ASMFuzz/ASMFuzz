@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -69,6 +69,7 @@ public static Names instance(Context context) {
     public final Name transitive;
     public final Name uses;
     public final Name open;
+    public final Name when;
     public final Name with;
     public final Name yield;
 
@@ -248,6 +249,7 @@ public Names(Context context) {
         transitive = fromString("transitive");
         uses = fromString("uses");
         open = fromString("open");
+        when = fromString("when");
         with = fromString("with");
         yield = fromString("yield");
 