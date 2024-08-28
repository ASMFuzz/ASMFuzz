@@ -3230,7 +3230,7 @@ const char* nmethod::reloc_string_for(u_char* begin, u_char* end) {
   return have_one ? "other" : NULL;
 }
 
-// Return a the last scope in (begin..end]
+// Return the last scope in (begin..end]
 ScopeDesc* nmethod::scope_desc_in(address begin, address end) {
   PcDesc* p = pc_desc_near(begin+1);
   if (p != NULL && p->real_pc(this) <= end) {