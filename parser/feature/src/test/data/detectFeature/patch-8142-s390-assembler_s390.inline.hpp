@@ -531,6 +531,11 @@ inline void Assembler::z_algfi(Register r1, int64_t i2) { emit_48( ALGFI_ZOPC |
 inline void Assembler::z_alhsik( Register r1, Register r3, int64_t i2) { emit_48( ALHSIK_ZOPC  | regt(r1, 8, 48) | reg(r3, 12, 48) | simm16(i2, 16, 48)); }
 inline void Assembler::z_alghsik(Register r1, Register r3, int64_t i2) { emit_48( ALGHSIK_ZOPC | regt(r1, 8, 48) | reg(r3, 12, 48) | simm16(i2, 16, 48)); }
 
+inline void Assembler::z_alc( Register r1, int64_t d2, Register x2, Register b2) { emit_48( ALC_ZOPC  | regt(r1, 8, 48) | rxymask_48(d2, x2, b2)); }
+inline void Assembler::z_alcg(Register r1, int64_t d2, Register x2, Register b2) { emit_48( ALCG_ZOPC | regt(r1, 8, 48) | rxymask_48(d2, x2, b2)); }
+inline void Assembler::z_alc( Register r1, const Address& a) { z_alc( r1, a.disp(), a.indexOrR0(), a.baseOrR0()); }
+inline void Assembler::z_alcg(Register r1, const Address& a) { z_alcg(r1, a.disp(), a.indexOrR0(), a.baseOrR0()); }
+
 // In-memory arithmetic (add signed, add logical with signed immediate)
 inline void Assembler::z_asi(  int64_t d1, Register b1, int64_t i2) { emit_48( ASI_ZOPC   | simm8(i2, 8, 48) | rsymask_48(d1, b1)); }
 inline void Assembler::z_agsi( int64_t d1, Register b1, int64_t i2) { emit_48( AGSI_ZOPC  | simm8(i2, 8, 48) | rsymask_48(d1, b1)); }