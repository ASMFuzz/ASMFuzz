@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2011, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -27,6 +27,7 @@
 
 import java.lang.reflect.GenericDeclaration;
 import java.lang.reflect.TypeVariable;
+import jdk.internal.vm.annotation.Stable;
 
 
 /**
@@ -43,7 +44,8 @@ public abstract class AbstractScope<D extends GenericDeclaration>
     private final D recvr; // the declaration whose scope this instance represents
 
     /** The enclosing scope of this scope.  Lazily initialized. */
-    private volatile Scope enclosingScope;
+    @Stable
+    private Scope enclosingScope;
 
     /**
      * Constructor. Takes a reflective object whose scope the newly