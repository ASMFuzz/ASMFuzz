@@ -72,7 +72,7 @@
 
   // We don't have to flush registers, so the stack is always walkable.
   inline bool walkable(void) { return true; }
-  inline void make_walkable(JavaThread* thread) { }
+  inline void make_walkable() { }
 
  public:
 