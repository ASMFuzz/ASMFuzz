@@ -144,6 +144,8 @@ source %{
       case Op_LoadVector:
       case Op_StoreVector:
         return Matcher::vector_size_supported(bt, vlen);
+      case Op_VectorMaskToLong:
+        if (vlen > 64) return false;
       default:
         break;
     }
@@ -3040,8 +3042,7 @@ instruct vmask_lasttrue(iRegINoSp dst, pReg src, pReg ptmp) %{
 %}
 
 instruct vmask_tolong(iRegLNoSp dst, pReg src, vReg vtmp1, vReg vtmp2) %{
-  predicate(UseSVE > 0 &&
-            n->in(1)->bottom_type()->is_vect()->length() <= 64);
+  predicate(UseSVE > 0);
   match(Set dst (VectorMaskToLong src));
   effect(TEMP vtmp1, TEMP vtmp2);
   ins_cost(13 * SVE_COST);