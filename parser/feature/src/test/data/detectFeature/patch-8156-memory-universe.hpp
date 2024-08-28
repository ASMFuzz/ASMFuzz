@@ -95,6 +95,9 @@ class Universe: AllStatic {
   // Known classes in the VM
   static Klass* _typeArrayKlassObjs[T_LONG+1];
   static Klass* _objectArrayKlassObj;
+  // Special int-Array that represents filler objects that are used by GC to overwrite
+  // dead objects. References to them are generally an error.
+  static Klass* _fillerArrayKlassObj;
 
   // Known objects in the VM
   static OopHandle    _main_thread_group;             // Reference to the main thread group object
@@ -208,6 +211,8 @@ class Universe: AllStatic {
 
   static Klass* objectArrayKlassObj()               { return _objectArrayKlassObj; }
 
+  static Klass* fillerArrayKlassObj()               { return _fillerArrayKlassObj; }
+
   static Klass* typeArrayKlassObj(BasicType t) {
     assert((uint)t >= T_BOOLEAN, "range check for type: %s", type2name(t));
     assert((uint)t < T_LONG+1,   "range check for type: %s", type2name(t));