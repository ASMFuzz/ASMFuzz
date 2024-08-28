@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2019, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2019, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -68,6 +68,8 @@
  *
  * <li>{@code ESIZE} &mdash; the size in bytes of the operand type
  *
+ * <li>{@code EMASK} &mdash; the bit mask of the operand type, where {@code EMASK=(1<<(ESIZE*8))-1}
+ *
  * <li>{@code intVal}, {@code byteVal}, etc. &mdash; the operand of a
  * conversion, with the indicated type
  * </ul>
@@ -548,7 +550,7 @@ static boolean opKind(Operator op, int bit) {
     public static final /*bitwise*/ Binary LSHL = binary("LSHL", "<<", VectorSupport.VECTOR_OP_LSHIFT, VO_SHIFT);
     /** Produce {@code a>>(n&(ESIZE*8-1))}.  Integral only. */
     public static final /*bitwise*/ Binary ASHR = binary("ASHR", ">>", VectorSupport.VECTOR_OP_RSHIFT, VO_SHIFT);
-    /** Produce {@code a>>>(n&(ESIZE*8-1))}.  Integral only. */
+    /** Produce {@code (a&EMASK)>>>(n&(ESIZE*8-1))}.  Integral only. */
     public static final /*bitwise*/ Binary LSHR = binary("LSHR", ">>>", VectorSupport.VECTOR_OP_URSHIFT, VO_SHIFT);
     /** Produce {@code rotateLeft(a,n)}.  Integral only. */
     public static final /*bitwise*/ Binary ROL = binary("ROL", "rotateLeft", VectorSupport.VECTOR_OP_LROTATE, VO_SHIFT);