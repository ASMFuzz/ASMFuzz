@@ -713,7 +713,7 @@ private static BinaryOperation<LongVector, VectorMask<Long>> binaryOperations(in
             case VECTOR_OP_RSHIFT: return (v0, v1, vm) ->
                     v0.bOp(v1, vm, (i, a, n) -> (long)(a >> n));
             case VECTOR_OP_URSHIFT: return (v0, v1, vm) ->
-                    v0.bOp(v1, vm, (i, a, n) -> (long)((a & LSHR_SETUP_MASK) >>> n));
+                    v0.bOp(v1, vm, (i, a, n) -> (long)(a >>> n));
             case VECTOR_OP_LROTATE: return (v0, v1, vm) ->
                     v0.bOp(v1, vm, (i, a, n) -> rotateLeft(a, (int)n));
             case VECTOR_OP_RROTATE: return (v0, v1, vm) ->
@@ -845,7 +845,7 @@ private static VectorBroadcastIntOp<LongVector, VectorMask<Long>> broadcastIntOp
             case VECTOR_OP_RSHIFT: return (v, n, m) ->
                     v.uOp(m, (i, a) -> (long)(a >> n));
             case VECTOR_OP_URSHIFT: return (v, n, m) ->
-                    v.uOp(m, (i, a) -> (long)((a & LSHR_SETUP_MASK) >>> n));
+                    v.uOp(m, (i, a) -> (long)(a >>> n));
             case VECTOR_OP_LROTATE: return (v, n, m) ->
                     v.uOp(m, (i, a) -> rotateLeft(a, (int)n));
             case VECTOR_OP_RROTATE: return (v, n, m) ->
@@ -860,7 +860,6 @@ private static VectorBroadcastIntOp<LongVector, VectorMask<Long>> broadcastIntOp
     // since our lane types are first-class types, not just dressed
     // up ints.
     private static final int SHIFT_MASK = (Long.SIZE - 1);
-    private static final long LSHR_SETUP_MASK = -1;
 
     // Ternary lanewise support
 