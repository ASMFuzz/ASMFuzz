@@ -1628,7 +1628,11 @@ void * os::dll_load(const char *filename, char *ebuf, int ebuflen) {
     {EM_PARISC,      EM_PARISC,  ELFCLASS32, ELFDATA2MSB, (char*)"PARISC"},
     {EM_68K,         EM_68K,     ELFCLASS32, ELFDATA2MSB, (char*)"M68k"},
     {EM_AARCH64,     EM_AARCH64, ELFCLASS64, ELFDATA2LSB, (char*)"AARCH64"},
-    {EM_RISCV,       EM_RISCV,   ELFCLASS64, ELFDATA2LSB, (char*)"RISC-V"},
+#ifdef _LP64
+    {EM_RISCV,       EM_RISCV,   ELFCLASS64, ELFDATA2LSB, (char*)"RISCV64"},
+#else
+    {EM_RISCV,       EM_RISCV,   ELFCLASS32, ELFDATA2LSB, (char*)"RISCV32"},
+#endif
     {EM_LOONGARCH,   EM_LOONGARCH, ELFCLASS64, ELFDATA2LSB, (char*)"LoongArch"},
   };
 
@@ -2497,7 +2501,7 @@ void os::get_summary_cpu_info(char* cpuinfo, size_t length) {
 #elif defined(PPC)
   strncpy(cpuinfo, "PPC64", length);
 #elif defined(RISCV)
-  strncpy(cpuinfo, "RISCV64", length);
+  strncpy(cpuinfo, LP64_ONLY("RISCV64") NOT_LP64("RISCV32"), length);
 #elif defined(S390)
   strncpy(cpuinfo, "S390", length);
 #elif defined(SPARC)