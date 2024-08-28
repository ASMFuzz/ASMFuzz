@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2008, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2008, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -194,7 +194,7 @@ protected MethodTypeForm(MethodType erasedType) {
             this.lambdaForms   = new SoftReference[LF_LIMIT];
             this.methodHandles = new SoftReference[MH_LIMIT];
         } else {
-            this.basicType = MethodType.makeImpl(basicReturnType, basicPtypes, true);
+            this.basicType = MethodType.methodType(basicReturnType, basicPtypes, true);
             // fill in rest of data from the basic type:
             MethodTypeForm that = this.basicType.form();
             assert(this != that);
@@ -250,7 +250,7 @@ public static MethodType canonicalize(MethodType mt, int how) {
         // Find the erased version of the method type:
         if (rtypeCanonical == null)  rtypeCanonical = rtype;
         if (ptypesCanonical == null)  ptypesCanonical = ptypes;
-        return MethodType.makeImpl(rtypeCanonical, ptypesCanonical, true);
+        return MethodType.methodType(rtypeCanonical, ptypesCanonical, true);
     }
 
     /** Canonicalize the given return or param type.