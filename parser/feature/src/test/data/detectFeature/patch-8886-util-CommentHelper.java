@@ -125,19 +125,8 @@ public String getTagName(DocTree dtree) {
         }
     }
 
-    public boolean isTypeParameter(DocTree dtree) {
-        if (dtree.getKind() == PARAM) {
-            return ((ParamTree)dtree).isTypeParameter();
-        }
-        return false;
-    }
-
-    public String getParameterName(DocTree dtree) {
-        if (dtree.getKind() == PARAM) {
-            return ((ParamTree) dtree).getName().getName().toString();
-        } else {
-            return null;
-        }
+    public String getParameterName(ParamTree p) {
+        return p.getName().getName().toString();
     }
 
     Element getElement(ReferenceTree rtree) {
@@ -558,10 +547,8 @@ public List<? extends DocTree> getReference(DocTree dtree) {
         return dtree.getKind() == SEE ? ((SeeTree)dtree).getReference() : null;
     }
 
-    public ReferenceTree getExceptionName(DocTree dtree) {
-        return (dtree.getKind() == THROWS || dtree.getKind() == EXCEPTION)
-                ? ((ThrowsTree)dtree).getExceptionName()
-                : null;
+    public ReferenceTree getExceptionName(ThrowsTree tt) {
+        return tt.getExceptionName();
     }
 
     public IdentifierTree getName(DocTree dtree) {