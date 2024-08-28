@@ -1908,6 +1908,7 @@ def generate(kind, names):
                        ["uzp2", "ZZZ"],
                        # SVE2 instructions
                        ["bext", "ZZZ"],
+                       ["bdep", "ZZZ"],
                       ])
 
 generate(SVEReductionOp, [["andv", 0], ["orv", 0], ["eorv", 0], ["smaxv", 0], ["sminv", 0],