@@ -38,6 +38,13 @@
 
 #define guarantee_with_errno(cond, msg) check_with_errno(guarantee, cond, msg)
 
+// 32-bit RISC-V has no SYS_futex syscall.
+#ifdef RISCV32
+  #if !defined(SYS_futex) && defined(SYS_futex_time64)
+    #define SYS_futex SYS_futex_time64
+  #endif
+#endif
+
 static int futex(volatile int *addr, int futex_op, int op_arg) {
   return syscall(SYS_futex, addr, futex_op, op_arg, NULL, NULL, 0);
 }