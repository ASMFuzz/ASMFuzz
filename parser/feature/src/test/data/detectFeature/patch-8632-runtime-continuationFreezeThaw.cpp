@@ -2460,10 +2460,10 @@ class ConfigResolve {
   static void resolve() {
     typedef Config<use_compressed ? oop_kind::NARROW : oop_kind::WIDE, BarrierSetT> SelectedConfigT;
 
-    freeze_entry = (address)freeze<SelectedConfigT>;
+    freeze_entry = (address)(void*)freeze<SelectedConfigT>;
 
     // If we wanted, we could templatize by kind and have three different thaw entries
-    thaw_entry   = (address)thaw<SelectedConfigT>;
+    thaw_entry   = (address)(void*)thaw<SelectedConfigT>;
   }
 };
 