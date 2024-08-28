@@ -1195,17 +1195,18 @@
     __ sve_uzp1(z10, __ S, z19, z11);                  //       uzp1    z10.s, z19.s, z11.s
     __ sve_uzp2(z23, __ D, z23, z8);                   //       uzp2    z23.d, z23.d, z8.d
     __ sve_bext(z17, __ S, z19, z19);                  //       bext    z17.s, z19.s, z19.s
+    __ sve_bdep(z4, __ D, z20, z13);                   //       bdep    z4.d, z20.d, z13.d
 
 // SVEReductionOp
-    __ sve_andv(v4, __ D, p5, z13);                    //       andv d4, p5, z13.d
-    __ sve_orv(v22, __ D, p7, z30);                    //       orv d22, p7, z30.d
-    __ sve_eorv(v17, __ H, p4, z14);                   //       eorv h17, p4, z14.h
-    __ sve_smaxv(v12, __ B, p7, z20);                  //       smaxv b12, p7, z20.b
-    __ sve_sminv(v1, __ B, p3, z13);                   //       sminv b1, p3, z13.b
-    __ sve_fminv(v7, __ D, p2, z11);                   //       fminv d7, p2, z11.d
-    __ sve_fmaxv(v4, __ S, p6, z15);                   //       fmaxv s4, p6, z15.s
-    __ sve_fadda(v3, __ D, p7, z0);                    //       fadda d3, p7, d3, z0.d
-    __ sve_uaddv(v5, __ D, p5, z30);                   //       uaddv d5, p5, z30.d
+    __ sve_andv(v22, __ D, p7, z30);                   //       andv d22, p7, z30.d
+    __ sve_orv(v17, __ H, p4, z14);                    //       orv h17, p4, z14.h
+    __ sve_eorv(v12, __ B, p7, z20);                   //       eorv b12, p7, z20.b
+    __ sve_smaxv(v1, __ B, p3, z13);                   //       smaxv b1, p3, z13.b
+    __ sve_sminv(v7, __ S, p2, z11);                   //       sminv s7, p2, z11.s
+    __ sve_fminv(v4, __ S, p6, z15);                   //       fminv s4, p6, z15.s
+    __ sve_fmaxv(v3, __ D, p7, z0);                    //       fmaxv d3, p7, z0.d
+    __ sve_fadda(v5, __ D, p5, z30);                   //       fadda d5, p5, d5, z30.d
+    __ sve_uaddv(v13, __ H, p3, z8);                   //       uaddv d13, p3, z8.h
 
     __ bind(forth);
 
@@ -1224,30 +1225,30 @@
     0x9101a1a0,     0xb10a5cc8,     0xd10810aa,     0xf10fd061,
     0x120cb166,     0x321764bc,     0x52174681,     0x720c0227,
     0x9241018e,     0xb25a2969,     0xd278b411,     0xf26aad01,
-    0x14000000,     0x17ffffd7,     0x140003f0,     0x94000000,
-    0x97ffffd4,     0x940003ed,     0x3400000a,     0x34fffa2a,
-    0x34007d4a,     0x35000008,     0x35fff9c8,     0x35007ce8,
-    0xb400000b,     0xb4fff96b,     0xb4007c8b,     0xb500001d,
-    0xb5fff91d,     0xb5007c3d,     0x10000013,     0x10fff8b3,
-    0x10007bd3,     0x90000013,     0x36300016,     0x3637f836,
-    0x36307b56,     0x3758000c,     0x375ff7cc,     0x37587aec,
+    0x14000000,     0x17ffffd7,     0x140003f1,     0x94000000,
+    0x97ffffd4,     0x940003ee,     0x3400000a,     0x34fffa2a,
+    0x34007d6a,     0x35000008,     0x35fff9c8,     0x35007d08,
+    0xb400000b,     0xb4fff96b,     0xb4007cab,     0xb500001d,
+    0xb5fff91d,     0xb5007c5d,     0x10000013,     0x10fff8b3,
+    0x10007bf3,     0x90000013,     0x36300016,     0x3637f836,
+    0x36307b76,     0x3758000c,     0x375ff7cc,     0x37587b0c,
     0x128313a0,     0x528a32c7,     0x7289173b,     0x92ab3acc,
     0xd2a0bf94,     0xf2c285e8,     0x9358722f,     0x330e652f,
     0x53067f3b,     0x93577c53,     0xb34a1aac,     0xd35a4016,
     0x13946c63,     0x93c3dbc8,     0x54000000,     0x54fff5a0,
-    0x540078c0,     0x54000001,     0x54fff541,     0x54007861,
-    0x54000002,     0x54fff4e2,     0x54007802,     0x54000002,
-    0x54fff482,     0x540077a2,     0x54000003,     0x54fff423,
-    0x54007743,     0x54000003,     0x54fff3c3,     0x540076e3,
-    0x54000004,     0x54fff364,     0x54007684,     0x54000005,
-    0x54fff305,     0x54007625,     0x54000006,     0x54fff2a6,
-    0x540075c6,     0x54000007,     0x54fff247,     0x54007567,
-    0x54000008,     0x54fff1e8,     0x54007508,     0x54000009,
-    0x54fff189,     0x540074a9,     0x5400000a,     0x54fff12a,
-    0x5400744a,     0x5400000b,     0x54fff0cb,     0x540073eb,
-    0x5400000c,     0x54fff06c,     0x5400738c,     0x5400000d,
-    0x54fff00d,     0x5400732d,     0x5400000e,     0x54ffefae,
-    0x540072ce,     0x5400000f,     0x54ffef4f,     0x5400726f,
+    0x540078e0,     0x54000001,     0x54fff541,     0x54007881,
+    0x54000002,     0x54fff4e2,     0x54007822,     0x54000002,
+    0x54fff482,     0x540077c2,     0x54000003,     0x54fff423,
+    0x54007763,     0x54000003,     0x54fff3c3,     0x54007703,
+    0x54000004,     0x54fff364,     0x540076a4,     0x54000005,
+    0x54fff305,     0x54007645,     0x54000006,     0x54fff2a6,
+    0x540075e6,     0x54000007,     0x54fff247,     0x54007587,
+    0x54000008,     0x54fff1e8,     0x54007528,     0x54000009,
+    0x54fff189,     0x540074c9,     0x5400000a,     0x54fff12a,
+    0x5400746a,     0x5400000b,     0x54fff0cb,     0x5400740b,
+    0x5400000c,     0x54fff06c,     0x540073ac,     0x5400000d,
+    0x54fff00d,     0x5400734d,     0x5400000e,     0x54ffefae,
+    0x540072ee,     0x5400000f,     0x54ffef4f,     0x5400728f,
     0xd40658e1,     0xd4014d22,     0xd4046543,     0xd4273f60,
     0xd44cad80,     0xd503201f,     0xd503203f,     0xd503205f,
     0xd503209f,     0xd50320bf,     0xd503219f,     0xd50323bf,
@@ -1474,8 +1475,8 @@
     0x65eec81b,     0x65e3f415,     0x65fd4739,     0x65ee6191,
     0x04c2422d,     0x045d76b4,     0x04203048,     0x04a032d7,
     0x04773359,     0x04e132b5,     0x05ab6a6a,     0x05e86ef7,
-    0x4593b271,     0x04da35a4,     0x04d83fd6,     0x045931d1,
-    0x04083e8c,     0x040a2da1,     0x65c72967,     0x658639e4,
-    0x65d83c03,     0x04c137c5,
+    0x4593b271,     0x45cdb684,     0x04da3fd6,     0x045831d1,
+    0x04193e8c,     0x04082da1,     0x048a2967,     0x658739e4,
+    0x65c63c03,     0x65d837c5,     0x04412d0d,
   };
 // END  Generated code -- do not edit