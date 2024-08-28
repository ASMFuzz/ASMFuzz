@@ -755,7 +755,7 @@ private static BinaryOperation<ShortVector, VectorMask<Short>> binaryOperations(
             case VECTOR_OP_RSHIFT: return (v0, v1, vm) ->
                     v0.bOp(v1, vm, (i, a, n) -> (short)(a >> n));
             case VECTOR_OP_URSHIFT: return (v0, v1, vm) ->
-                    v0.bOp(v1, vm, (i, a, n) -> (short)((a & LSHR_SETUP_MASK) >>> n));
+                    v0.bOp(v1, vm, (i, a, n) -> (short)(a >>> n));
             case VECTOR_OP_LROTATE: return (v0, v1, vm) ->
                     v0.bOp(v1, vm, (i, a, n) -> rotateLeft(a, (int)n));
             case VECTOR_OP_RROTATE: return (v0, v1, vm) ->
@@ -932,7 +932,7 @@ private static VectorBroadcastIntOp<ShortVector, VectorMask<Short>> broadcastInt
             case VECTOR_OP_RSHIFT: return (v, n, m) ->
                     v.uOp(m, (i, a) -> (short)(a >> n));
             case VECTOR_OP_URSHIFT: return (v, n, m) ->
-                    v.uOp(m, (i, a) -> (short)((a & LSHR_SETUP_MASK) >>> n));
+                    v.uOp(m, (i, a) -> (short)(a >>> n));
             case VECTOR_OP_LROTATE: return (v, n, m) ->
                     v.uOp(m, (i, a) -> rotateLeft(a, (int)n));
             case VECTOR_OP_RROTATE: return (v, n, m) ->
@@ -947,8 +947,6 @@ private static VectorBroadcastIntOp<ShortVector, VectorMask<Short>> broadcastInt
     // since our lane types are first-class types, not just dressed
     // up ints.
     private static final int SHIFT_MASK = (Short.SIZE - 1);
-    // Also simulate >>> on sub-word variables with a mask.
-    private static final int LSHR_SETUP_MASK = ((1 << Short.SIZE) - 1);
 
     // Ternary lanewise support
 