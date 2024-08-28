@@ -1894,6 +1894,8 @@ def generate(kind, names):
                        ["bic", "ZZZ"],
                        ["uzp1", "ZZZ"],
                        ["uzp2", "ZZZ"],
+                       # SVE2 instructions
+                       ["bext", "ZZZ"],
                       ])
 
 generate(SVEReductionOp, [["andv", 0], ["orv", 0], ["eorv", 0], ["smaxv", 0], ["sminv", 0],
@@ -1904,8 +1906,9 @@ def generate(kind, names):
 
 outfile.close()
 
-# compile for sve with 8.3 and sha3 because of SHA3 crypto extension.
-subprocess.check_call([AARCH64_AS, "-march=armv8.3-a+sha3+sve", "aarch64ops.s", "-o", "aarch64ops.o"])
+# compile for sve with armv9-a+sha3+sve2-bitperm because of SHA3 crypto extension and SVE2 bitperm instructions.
+# armv9-a enables sve and sve2 by default.
+subprocess.check_call([AARCH64_AS, "-march=armv9-a+sha3+sve2-bitperm", "aarch64ops.s", "-o", "aarch64ops.o"])
 
 print
 print "/*"