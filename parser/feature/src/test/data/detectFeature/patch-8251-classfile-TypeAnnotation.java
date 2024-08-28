@@ -338,7 +338,7 @@ public int hashCode() {
         public TargetType type = TargetType.UNKNOWN;
 
         // For generic/array types.
-        // TODO: or should we use null? Noone will use this object.
+        // TODO: or should we use null? No one will use this object.
         public List<TypePathEntry> location = new ArrayList<>(0);
 
         // Tree position.