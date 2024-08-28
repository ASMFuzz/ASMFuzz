@@ -1724,5 +1724,6 @@ void SystemDictionaryShared::update_archived_mirror_native_pointers() {
     Klass* k = Universe::typeArrayKlassObj((BasicType)t);
     ArchivedMirrorPatcher::update_array_klasses(k);
   }
+  ArchivedMirrorPatcher::update_array_klasses(Universe::fillerArrayKlassObj());
 }
 #endif