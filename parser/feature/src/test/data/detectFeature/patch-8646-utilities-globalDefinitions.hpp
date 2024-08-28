@@ -728,10 +728,14 @@ inline bool is_floating_point_type(BasicType t) {
 extern char type2char_tab[T_CONFLICT+1];     // Map a BasicType to a jchar
 inline char type2char(BasicType t) { return (uint)t < T_CONFLICT+1 ? type2char_tab[t] : 0; }
 extern int type2size[T_CONFLICT+1];         // Map BasicType to result stack elements
-extern const char* type2name_tab[T_CONFLICT+1];     // Map a BasicType to a jchar
-inline const char* type2name(BasicType t) { return (uint)t < T_CONFLICT+1 ? type2name_tab[t] : NULL; }
+extern const char* type2name_tab[T_CONFLICT+1];     // Map a BasicType to a char*
 extern BasicType name2type(const char* name);
 
+inline const char* type2name(BasicType t) {
+  assert((uint)t < T_CONFLICT + 1, "invalid type");
+  return type2name_tab[t];
+}
+
 inline jlong max_signed_integer(BasicType bt) {
   if (bt == T_INT) {
     return max_jint;