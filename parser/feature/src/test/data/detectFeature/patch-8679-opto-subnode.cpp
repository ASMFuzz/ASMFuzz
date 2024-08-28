@@ -827,11 +827,10 @@ const Type* CmpUNode::Value(PhaseGVN* phase) const {
         int w = MAX2(r0->_widen, r1->_widen); // _widen does not matter here
         const TypeInt* tr1 = TypeInt::make(lo_tr1, hi_tr1, w);
         const TypeInt* tr2 = TypeInt::make(lo_tr2, hi_tr2, w);
-        const Type* cmp1 = sub(tr1, t2);
-        const Type* cmp2 = sub(tr2, t2);
-        if (cmp1 == cmp2) {
-          return cmp1; // Hit!
-        }
+        const TypeInt* cmp1 = sub(tr1, t2)->is_int();
+        const TypeInt* cmp2 = sub(tr2, t2)->is_int();
+        // compute union, so that cmp handles all possible results from the two cases
+        return cmp1->meet(cmp2);
       }
     }
   }