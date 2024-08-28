@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -49,28 +49,28 @@ public interface Principal {
      * @return true if the principal passed in is the same as that
      * encapsulated by this principal, and false otherwise.
      */
-    public boolean equals(Object another);
+    boolean equals(Object another);
 
     /**
      * Returns a string representation of this principal.
      *
      * @return a string representation of this principal.
      */
-    public String toString();
+    String toString();
 
     /**
      * Returns a hashcode for this principal.
      *
      * @return a hashcode for this principal.
      */
-    public int hashCode();
+    int hashCode();
 
     /**
      * Returns the name of this principal.
      *
      * @return the name of this principal.
      */
-    public String getName();
+    String getName();
 
     /**
      * Returns true if the specified subject is implied by this principal.
@@ -88,7 +88,7 @@ public interface Principal {
      *              implied by this principal, or false otherwise.
      * @since 1.8
      */
-    public default boolean implies(Subject subject) {
+    default boolean implies(Subject subject) {
         if (subject == null)
             return false;
         return subject.getPrincipals().contains(this);