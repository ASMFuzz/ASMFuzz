@@ -922,6 +922,7 @@ void VM_Version::get_processor_features() {
     _features &= ~CPU_AVX512_VNNI;
     _features &= ~CPU_AVX512_VBMI;
     _features &= ~CPU_AVX512_VBMI2;
+    _features &= ~CPU_AVX512_BITALG;
   }
 
   if (UseAVX < 2)
@@ -951,6 +952,8 @@ void VM_Version::get_processor_features() {
       _features &= ~CPU_AVX512_VBMI2;
       _features &= ~CPU_CLWB;
       _features &= ~CPU_FLUSHOPT;
+      _features &= ~CPU_GFNI;
+      _features &= ~CPU_AVX512_BITALG;
     }
   }
 