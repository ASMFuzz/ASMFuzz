@@ -755,7 +755,7 @@ private static BinaryOperation<ByteVector, VectorMask<Byte>> binaryOperations(in
             case VECTOR_OP_RSHIFT: return (v0, v1, vm) ->
                     v0.bOp(v1, vm, (i, a, n) -> (byte)(a >> n));
             case VECTOR_OP_URSHIFT: return (v0, v1, vm) ->
-                    v0.bOp(v1, vm, (i, a, n) -> (byte)((a & LSHR_SETUP_MASK) >>> n));
+                    v0.bOp(v1, vm, (i, a, n) -> (byte)(a >>> n));
             case VECTOR_OP_LROTATE: return (v0, v1, vm) ->
                     v0.bOp(v1, vm, (i, a, n) -> rotateLeft(a, (int)n));
             case VECTOR_OP_RROTATE: return (v0, v1, vm) ->
@@ -932,7 +932,7 @@ private static VectorBroadcastIntOp<ByteVector, VectorMask<Byte>> broadcastIntOp
             case VECTOR_OP_RSHIFT: return (v, n, m) ->
                     v.uOp(m, (i, a) -> (byte)(a >> n));
             case VECTOR_OP_URSHIFT: return (v, n, m) ->
-                    v.uOp(m, (i, a) -> (byte)((a & LSHR_SETUP_MASK) >>> n));
+                    v.uOp(m, (i, a) -> (byte)(a >>> n));
             case VECTOR_OP_LROTATE: return (v, n, m) ->
                     v.uOp(m, (i, a) -> rotateLeft(a, (int)n));
             case VECTOR_OP_RROTATE: return (v, n, m) ->
@@ -947,8 +947,6 @@ private static VectorBroadcastIntOp<ByteVector, VectorMask<Byte>> broadcastIntOp
     // since our lane types are first-class types, not just dressed
     // up ints.
     private static final int SHIFT_MASK = (Byte.SIZE - 1);
-    // Also simulate >>> on sub-word variables with a mask.
-    private static final int LSHR_SETUP_MASK = ((1 << Byte.SIZE) - 1);
 
     // Ternary lanewise support
 