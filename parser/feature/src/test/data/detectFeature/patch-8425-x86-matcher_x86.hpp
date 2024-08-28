@@ -186,15 +186,29 @@
   // Returns pre-selection estimated size of a vector operation.
   static int vector_op_pre_select_sz_estimate(int vopc, BasicType ety, int vlen) {
     switch(vopc) {
-      default: return 0;
-      case Op_PopCountVI: return VM_Version::supports_avx512_vpopcntdq() ? 0 : 50;
-      case Op_PopCountVL: return VM_Version::supports_avx512_vpopcntdq() ? 0 : 40;
+      default:
+        return 0;
+      case Op_CountTrailingZerosV:
+      case Op_CountLeadingZerosV:
+        return VM_Version::supports_avx512cd() && (ety == T_INT || ety == T_LONG) ? 0 : 40;
+      case Op_PopCountVI:
+        if (is_subword_type(ety)) {
+          return VM_Version::supports_avx512_bitalg() ? 0 : 50;
+        } else {
+          assert(ety == T_INT, "sanity"); // for documentation purposes
+          return VM_Version::supports_avx512_vpopcntdq() ? 0 : 50;
+        }
+      case Op_PopCountVL:
+        return VM_Version::supports_avx512_vpopcntdq() ? 0 : 40;
+      case Op_ReverseV:
+        return VM_Version::supports_gfni() ? 0 : 30;
       case Op_RoundVF: // fall through
       case Op_RoundVD: {
         return 30;
       }
     }
   }
+
   // Returns pre-selection estimated size of a scalar operation.
   static int scalar_op_pre_select_sz_estimate(int vopc, BasicType ety) {
     switch(vopc) {