@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2011, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2011, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -1310,9 +1310,11 @@ public List<? extends DocTree> getDescription() {
     }
 
     public static class DCValue extends DCInlineTag implements ValueTree {
+        public final DCText format;
         public final DCReference ref;
 
-        DCValue(DCReference ref) {
+        DCValue(DCText format, DCReference ref) {
+            this.format = format;
             this.ref = ref;
         }
 
@@ -1326,6 +1328,11 @@ public <R, D> R accept(DocTreeVisitor<R, D> v, D d) {
             return v.visitValue(this, d);
         }
 
+        @Override @DefinedBy(Api.COMPILER_TREE)
+        public TextTree getFormat() {
+            return format;
+        }
+
         @Override @DefinedBy(Api.COMPILER_TREE)
         public ReferenceTree getReference() {
             return ref;