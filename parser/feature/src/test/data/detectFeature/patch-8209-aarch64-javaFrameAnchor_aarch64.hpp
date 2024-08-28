@@ -65,8 +65,8 @@
   }
 
   bool walkable(void)                            { return _last_Java_sp != NULL && _last_Java_pc != NULL; }
-  void make_walkable(JavaThread* thread);
-  void capture_last_Java_pc(void);
+
+  void make_walkable();
 
   intptr_t* last_Java_sp(void) const             { return _last_Java_sp; }
 