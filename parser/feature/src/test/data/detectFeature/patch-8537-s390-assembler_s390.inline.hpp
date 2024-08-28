@@ -767,17 +767,18 @@ inline void Assembler::z_cvdg(Register r1, int64_t d2, Register x2, Register b2)
 // Load (transfer from memory)
 inline void Assembler::z_vlm(    VectorRegister v1, VectorRegister v3, int64_t d2, Register b2)       {emit_48(VLM_ZOPC   | vreg(v1,  8)     | vreg(v3, 12)     | rsmask_48(d2,     b2)); }
 inline void Assembler::z_vl(     VectorRegister v1, int64_t d2, Register x2, Register b2)             {emit_48(VL_ZOPC    | vreg(v1,  8)                        | rxmask_48(d2, x2, b2)); }
-inline void Assembler::z_vleb(   VectorRegister v1, int64_t d2, Register x2, Register b2, int64_t m3) {emit_48(VLEB_ZOPC  | vreg(v1,  8)                        | rxmask_48(d2, x2, b2) | veix_mask(m3, VRET_BYTE, 32)); }
-inline void Assembler::z_vleh(   VectorRegister v1, int64_t d2, Register x2, Register b2, int64_t m3) {emit_48(VLEH_ZOPC  | vreg(v1,  8)                        | rxmask_48(d2, x2, b2) | veix_mask(m3, VRET_HW,   32)); }
-inline void Assembler::z_vlef(   VectorRegister v1, int64_t d2, Register x2, Register b2, int64_t m3) {emit_48(VLEF_ZOPC  | vreg(v1,  8)                        | rxmask_48(d2, x2, b2) | veix_mask(m3, VRET_FW,   32)); }
-inline void Assembler::z_vleg(   VectorRegister v1, int64_t d2, Register x2, Register b2, int64_t m3) {emit_48(VLEG_ZOPC  | vreg(v1,  8)                        | rxmask_48(d2, x2, b2) | veix_mask(m3, VRET_DW,   32)); }
+inline void Assembler::z_vleb(   VectorRegister v1, int64_t d2, Register x2, Register b2, int64_t ix3){emit_48(VLEB_ZOPC  | vreg(v1,  8)                        | rxmask_48(d2, x2, b2) | uimm4(ix3, 32, 48)); }
+inline void Assembler::z_vleh(   VectorRegister v1, int64_t d2, Register x2, Register b2, int64_t ix3){emit_48(VLEH_ZOPC  | vreg(v1,  8)                        | rxmask_48(d2, x2, b2) | uimm4(ix3, 32, 48)); }
+inline void Assembler::z_vlef(   VectorRegister v1, int64_t d2, Register x2, Register b2, int64_t ix3){emit_48(VLEF_ZOPC  | vreg(v1,  8)                        | rxmask_48(d2, x2, b2) | uimm4(ix3, 32, 48)); }
+inline void Assembler::z_vleg(   VectorRegister v1, int64_t d2, Register x2, Register b2, int64_t ix3){emit_48(VLEG_ZOPC  | vreg(v1,  8)                        | rxmask_48(d2, x2, b2) | uimm4(ix3, 32, 48)); }
+
 
 // Gather/Scatter
-inline void Assembler::z_vgef(   VectorRegister v1, int64_t d2, VectorRegister vx2, Register b2, int64_t m3) {emit_48(VGEF_ZOPC  | vreg(v1,  8)                 | rvmask_48(d2, vx2, b2) | veix_mask(m3, VRET_FW,   32)); }
-inline void Assembler::z_vgeg(   VectorRegister v1, int64_t d2, VectorRegister vx2, Register b2, int64_t m3) {emit_48(VGEG_ZOPC  | vreg(v1,  8)                 | rvmask_48(d2, vx2, b2) | veix_mask(m3, VRET_DW,   32)); }
+inline void Assembler::z_vgef(   VectorRegister v1, int64_t d2, VectorRegister vx2, Register b2, int64_t ix3) {emit_48(VGEF_ZOPC  | vreg(v1,  8)                | rvmask_48(d2, vx2, b2) | uimm4(ix3, 32, 48)); }
+inline void Assembler::z_vgeg(   VectorRegister v1, int64_t d2, VectorRegister vx2, Register b2, int64_t ix3) {emit_48(VGEG_ZOPC  | vreg(v1,  8)                | rvmask_48(d2, vx2, b2) | uimm4(ix3, 32, 48)); }
 
-inline void Assembler::z_vscef(  VectorRegister v1, int64_t d2, VectorRegister vx2, Register b2, int64_t m3) {emit_48(VSCEF_ZOPC | vreg(v1,  8)                 | rvmask_48(d2, vx2, b2) | veix_mask(m3, VRET_FW,   32)); }
-inline void Assembler::z_vsceg(  VectorRegister v1, int64_t d2, VectorRegister vx2, Register b2, int64_t m3) {emit_48(VSCEG_ZOPC | vreg(v1,  8)                 | rvmask_48(d2, vx2, b2) | veix_mask(m3, VRET_DW,   32)); }
+inline void Assembler::z_vscef(  VectorRegister v1, int64_t d2, VectorRegister vx2, Register b2, int64_t ix3) {emit_48(VSCEF_ZOPC | vreg(v1,  8)                | rvmask_48(d2, vx2, b2) | uimm4(ix3, 32, 48)); }
+inline void Assembler::z_vsceg(  VectorRegister v1, int64_t d2, VectorRegister vx2, Register b2, int64_t ix3) {emit_48(VSCEG_ZOPC | vreg(v1,  8)                | rvmask_48(d2, vx2, b2) | uimm4(ix3, 32, 48)); }
 
 // load and replicate
 inline void Assembler::z_vlrep(  VectorRegister v1, int64_t d2, Register x2, Register b2, int64_t m3) {emit_48(VLREP_ZOPC | vreg(v1,  8)                        | rxmask_48(d2, x2, b2) | vesc_mask(m3, VRET_BYTE, VRET_DW, 32)); }
@@ -879,26 +880,26 @@ inline void Assembler::z_vrepf(  VectorRegister v1, VectorRegister v3, int64_t i
 inline void Assembler::z_vrepg(  VectorRegister v1, VectorRegister v3, int64_t imm2)                  {z_vrep(v1, v3, imm2, VRET_DW); }    // vector element type 'G'
 inline void Assembler::z_vrepi(  VectorRegister v1, int64_t imm2,      int64_t m3)                    {emit_48(VREPI_ZOPC | vreg(v1,  8)                        | simm16(imm2, 16, 48) | vesc_mask(m3, VRET_BYTE, VRET_DW, 32)); }
 inline void Assembler::z_vrepib( VectorRegister v1, int64_t imm2)                                     {z_vrepi(v1, imm2, VRET_BYTE); }     // vector element type 'B'
-inline void Assembler::z_vrepih( VectorRegister v1, int64_t imm2)                                     {z_vrepi(v1, imm2, VRET_HW); }       // vector element type 'B'
-inline void Assembler::z_vrepif( VectorRegister v1, int64_t imm2)                                     {z_vrepi(v1, imm2, VRET_FW); }       // vector element type 'B'
-inline void Assembler::z_vrepig( VectorRegister v1, int64_t imm2)                                     {z_vrepi(v1, imm2, VRET_DW); }       // vector element type 'B'
+inline void Assembler::z_vrepih( VectorRegister v1, int64_t imm2)                                     {z_vrepi(v1, imm2, VRET_HW); }       // vector element type 'H'
+inline void Assembler::z_vrepif( VectorRegister v1, int64_t imm2)                                     {z_vrepi(v1, imm2, VRET_FW); }       // vector element type 'F'
+inline void Assembler::z_vrepig( VectorRegister v1, int64_t imm2)                                     {z_vrepi(v1, imm2, VRET_DW); }       // vector element type 'G'
 
 inline void Assembler::z_vsel(   VectorRegister v1, VectorRegister v2, VectorRegister v3, VectorRegister v4) {emit_48(VSEL_ZOPC  | vreg(v1,  8) |  vreg(v2, 12) |  vreg(v3, 16) |  vreg(v4, 32)); }
 inline void Assembler::z_vseg(   VectorRegister v1, VectorRegister v2, int64_t m3)                    {emit_48(VSEG_ZOPC  | vreg(v1,  8)     | vreg(v2, 12)     | uimm4(m3, 32, 48)); }
 
 // Load (immediate)
-inline void Assembler::z_vleib(  VectorRegister v1, int64_t imm2, int64_t m3)                         {emit_48(VLEIB_ZOPC | vreg(v1,  8)                        | simm16(imm2, 32, 48)  | veix_mask(m3, VRET_BYTE, 32)); }
-inline void Assembler::z_vleih(  VectorRegister v1, int64_t imm2, int64_t m3)                         {emit_48(VLEIH_ZOPC | vreg(v1,  8)                        | simm16(imm2, 32, 48)  | veix_mask(m3, VRET_HW,   32)); }
-inline void Assembler::z_vleif(  VectorRegister v1, int64_t imm2, int64_t m3)                         {emit_48(VLEIF_ZOPC | vreg(v1,  8)                        | simm16(imm2, 32, 48)  | veix_mask(m3, VRET_FW,   32)); }
-inline void Assembler::z_vleig(  VectorRegister v1, int64_t imm2, int64_t m3)                         {emit_48(VLEIG_ZOPC | vreg(v1,  8)                        | simm16(imm2, 32, 48)  | veix_mask(m3, VRET_DW,   32)); }
+inline void Assembler::z_vleib(  VectorRegister v1, int64_t imm2, int64_t ix3)                        {emit_48(VLEIB_ZOPC | vreg(v1,  8)                        | simm16(imm2, 16, 48)  | uimm4(ix3, 32, 48)); }
+inline void Assembler::z_vleih(  VectorRegister v1, int64_t imm2, int64_t ix3)                        {emit_48(VLEIH_ZOPC | vreg(v1,  8)                        | simm16(imm2, 16, 48)  | uimm4(ix3, 32, 48)); }
+inline void Assembler::z_vleif(  VectorRegister v1, int64_t imm2, int64_t ix3)                        {emit_48(VLEIF_ZOPC | vreg(v1,  8)                        | simm16(imm2, 16, 48)  | uimm4(ix3, 32, 48)); }
+inline void Assembler::z_vleig(  VectorRegister v1, int64_t imm2, int64_t ix3)                        {emit_48(VLEIG_ZOPC | vreg(v1,  8)                        | simm16(imm2, 16, 48)  | uimm4(ix3, 32, 48)); }
 
 // Store
 inline void Assembler::z_vstm(   VectorRegister v1, VectorRegister v3, int64_t d2, Register b2)       {emit_48(VSTM_ZOPC  | vreg(v1,  8)     | vreg(v3, 12)     | rsmask_48(d2,     b2)); }
 inline void Assembler::z_vst(    VectorRegister v1, int64_t d2, Register x2, Register b2)             {emit_48(VST_ZOPC   | vreg(v1,  8)                        | rxmask_48(d2, x2, b2)); }
-inline void Assembler::z_vsteb(  VectorRegister v1, int64_t d2, Register x2, Register b2, int64_t m3) {emit_48(VSTEB_ZOPC | vreg(v1,  8)                        | rxmask_48(d2, x2, b2) | veix_mask(m3, VRET_BYTE, 32)); }
-inline void Assembler::z_vsteh(  VectorRegister v1, int64_t d2, Register x2, Register b2, int64_t m3) {emit_48(VSTEH_ZOPC | vreg(v1,  8)                        | rxmask_48(d2, x2, b2) | veix_mask(m3, VRET_HW,   32)); }
-inline void Assembler::z_vstef(  VectorRegister v1, int64_t d2, Register x2, Register b2, int64_t m3) {emit_48(VSTEF_ZOPC | vreg(v1,  8)                        | rxmask_48(d2, x2, b2) | veix_mask(m3, VRET_FW,   32)); }
-inline void Assembler::z_vsteg(  VectorRegister v1, int64_t d2, Register x2, Register b2, int64_t m3) {emit_48(VSTEG_ZOPC | vreg(v1,  8)                        | rxmask_48(d2, x2, b2) | veix_mask(m3, VRET_DW,   32)); }
+inline void Assembler::z_vsteb(  VectorRegister v1, int64_t d2, Register x2, Register b2, int64_t ix3){emit_48(VSTEB_ZOPC | vreg(v1,  8)                        | rxmask_48(d2, x2, b2) | uimm4(ix3, 32, 48)); }
+inline void Assembler::z_vsteh(  VectorRegister v1, int64_t d2, Register x2, Register b2, int64_t ix3){emit_48(VSTEH_ZOPC | vreg(v1,  8)                        | rxmask_48(d2, x2, b2) | uimm4(ix3, 32, 48)); }
+inline void Assembler::z_vstef(  VectorRegister v1, int64_t d2, Register x2, Register b2, int64_t ix3){emit_48(VSTEF_ZOPC | vreg(v1,  8)                        | rxmask_48(d2, x2, b2) | uimm4(ix3, 32, 48)); }
+inline void Assembler::z_vsteg(  VectorRegister v1, int64_t d2, Register x2, Register b2, int64_t ix3){emit_48(VSTEG_ZOPC | vreg(v1,  8)                        | rxmask_48(d2, x2, b2) | uimm4(ix3, 32, 48)); }
 inline void Assembler::z_vstl(   VectorRegister v1, Register r3, int64_t d2, Register b2)             {emit_48(VSTL_ZOPC  | vreg(v1,  8)     |  reg(r3, 12, 48) | rsmask_48(d2,     b2)); }
 
 // Misc