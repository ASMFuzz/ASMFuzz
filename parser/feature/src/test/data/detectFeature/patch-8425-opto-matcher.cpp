@@ -2254,6 +2254,9 @@ bool Matcher::find_shared_visit(MStack& mstack, Node* n, uint opcode, bool& mem_
     case Op_MacroLogicV:
     case Op_LoadVectorMasked:
     case Op_VectorCmpMasked:
+    case Op_CompressV:
+    case Op_CompressM:
+    case Op_ExpandV:
     case Op_VectorLoadMask:
       set_shared(n); // Force result into register (it will be anyways)
       break;