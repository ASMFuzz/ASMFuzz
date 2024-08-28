@@ -64,6 +64,7 @@ class CastLLNode;
 class CatchNode;
 class CatchProjNode;
 class CheckCastPPNode;
+class CastPPNode;
 class ClearArrayNode;
 class CmpNode;
 class CodeBuffer;
@@ -152,6 +153,7 @@ class ProjNode;
 class RangeCheckNode;
 class RegMask;
 class RegionNode;
+class ReducedAllocationMergeNode;
 class RootNode;
 class SafePointNode;
 class SafePointScalarObjectNode;
@@ -691,6 +693,7 @@ class Node {
         DEFINE_CLASS_ID(CastFF, ConstraintCast, 3)
         DEFINE_CLASS_ID(CastDD, ConstraintCast, 4)
         DEFINE_CLASS_ID(CastVV, ConstraintCast, 5)
+        DEFINE_CLASS_ID(CastPP, ConstraintCast, 6)
       DEFINE_CLASS_ID(CMove, Type, 3)
       DEFINE_CLASS_ID(SafePointScalarObject, Type, 4)
       DEFINE_CLASS_ID(DecodeNarrowPtr, Type, 5)
@@ -704,6 +707,7 @@ class Node {
         DEFINE_CLASS_ID(VectorUnbox, Vector, 1)
         DEFINE_CLASS_ID(VectorReinterpret, Vector, 2)
         DEFINE_CLASS_ID(ShiftV, Vector, 3)
+      DEFINE_CLASS_ID(ReducedAllocationMerge,   Type, 8)
 
     DEFINE_CLASS_ID(Proj,  Node, 3)
       DEFINE_CLASS_ID(CatchProj, Proj, 0)
@@ -850,6 +854,7 @@ class Node {
   DEFINE_CLASS_QUERY(Catch)
   DEFINE_CLASS_QUERY(CatchProj)
   DEFINE_CLASS_QUERY(CheckCastPP)
+  DEFINE_CLASS_QUERY(CastPP)
   DEFINE_CLASS_QUERY(CastII)
   DEFINE_CLASS_QUERY(CastLL)
   DEFINE_CLASS_QUERY(ConstraintCast)
@@ -938,6 +943,7 @@ class Node {
   DEFINE_CLASS_QUERY(StoreVectorScatter)
   DEFINE_CLASS_QUERY(ShiftV)
   DEFINE_CLASS_QUERY(Unlock)
+  DEFINE_CLASS_QUERY(ReducedAllocationMerge)
 
   #undef DEFINE_CLASS_QUERY
 