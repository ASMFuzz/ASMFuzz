@@ -100,11 +100,6 @@ public void setControlPoints(List<Point> list) {
         controlPoints = list;
     }
 
-    @Override
-    public boolean isAlwaysVisible() {
-        return true;
-    }
-
     @Override
     public boolean hasSlots() {
         return false;