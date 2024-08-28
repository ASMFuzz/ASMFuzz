@@ -67,7 +67,7 @@
   // Always walkable.
   bool walkable(void) { return true; }
   // Never any thing to do since we are always walkable and can find address of return addresses.
-  void make_walkable(JavaThread* thread) { }
+  void make_walkable() { }
 
   intptr_t* last_Java_sp(void) const  { return _last_Java_sp; }
 