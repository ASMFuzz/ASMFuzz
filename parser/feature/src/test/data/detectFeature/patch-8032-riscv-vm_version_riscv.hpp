@@ -58,8 +58,7 @@ class VM_Version : public Abstract_VM_Version {
     decl(F,            "f",            5)     \
     decl(D,            "d",            3)     \
     decl(C,            "c",            2)     \
-    decl(V,            "v",           21)     \
-    decl(B,            "b",            1)
+    decl(V,            "v",           21)
 
 #define DECLARE_CPU_FEATURE_FLAG(id, name, bit) CPU_##id = (1 << bit),
     CPU_FEATURE_FLAGS(DECLARE_CPU_FEATURE_FLAG)