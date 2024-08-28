@@ -1183,17 +1183,18 @@
     __ sve_bic(z8, z2, z0);                            //       bic     z8.d, z2.d, z0.d
     __ sve_uzp1(z23, __ S, z22, z0);                   //       uzp1    z23.s, z22.s, z0.s
     __ sve_uzp2(z25, __ H, z26, z23);                  //       uzp2    z25.h, z26.h, z23.h
+    __ sve_bext(z21, __ B, z21, z1);                   //       bext    z21.b, z21.b, z1.b
 
 // SVEReductionOp
-    __ sve_andv(v21, __ B, p5, z1);                    //       andv b21, p5, z1.b
-    __ sve_orv(v10, __ S, p5, z11);                    //       orv s10, p5, z11.s
-    __ sve_eorv(v23, __ D, p6, z8);                    //       eorv d23, p6, z8.d
-    __ sve_smaxv(v17, __ S, p5, z19);                  //       smaxv s17, p5, z19.s
-    __ sve_sminv(v4, __ D, p5, z13);                   //       sminv d4, p5, z13.d
-    __ sve_fminv(v22, __ D, p7, z30);                  //       fminv d22, p7, z30.d
-    __ sve_fmaxv(v17, __ S, p4, z14);                  //       fmaxv s17, p4, z14.s
-    __ sve_fadda(v12, __ S, p7, z20);                  //       fadda s12, p7, s12, z20.s
-    __ sve_uaddv(v1, __ B, p3, z13);                   //       uaddv d1, p3, z13.b
+    __ sve_andv(v10, __ S, p5, z11);                   //       andv s10, p5, z11.s
+    __ sve_orv(v23, __ D, p6, z8);                     //       orv d23, p6, z8.d
+    __ sve_eorv(v17, __ S, p5, z19);                   //       eorv s17, p5, z19.s
+    __ sve_smaxv(v4, __ D, p5, z13);                   //       smaxv d4, p5, z13.d
+    __ sve_sminv(v22, __ D, p7, z30);                  //       sminv d22, p7, z30.d
+    __ sve_fminv(v17, __ S, p4, z14);                  //       fminv s17, p4, z14.s
+    __ sve_fmaxv(v12, __ S, p7, z20);                  //       fmaxv s12, p7, z20.s
+    __ sve_fadda(v1, __ S, p3, z13);                   //       fadda s1, p3, s1, z13.s
+    __ sve_uaddv(v7, __ S, p2, z11);                   //       uaddv d7, p2, z11.s
 
     __ bind(forth);
 
@@ -1212,30 +1213,30 @@
     0x9101a1a0,     0xb10a5cc8,     0xd10810aa,     0xf10fd061,
     0x120cb166,     0x321764bc,     0x52174681,     0x720c0227,
     0x9241018e,     0xb25a2969,     0xd278b411,     0xf26aad01,
-    0x14000000,     0x17ffffd7,     0x140003e4,     0x94000000,
-    0x97ffffd4,     0x940003e1,     0x3400000a,     0x34fffa2a,
-    0x34007bca,     0x35000008,     0x35fff9c8,     0x35007b68,
-    0xb400000b,     0xb4fff96b,     0xb4007b0b,     0xb500001d,
-    0xb5fff91d,     0xb5007abd,     0x10000013,     0x10fff8b3,
-    0x10007a53,     0x90000013,     0x36300016,     0x3637f836,
-    0x363079d6,     0x3758000c,     0x375ff7cc,     0x3758796c,
+    0x14000000,     0x17ffffd7,     0x140003e5,     0x94000000,
+    0x97ffffd4,     0x940003e2,     0x3400000a,     0x34fffa2a,
+    0x34007bea,     0x35000008,     0x35fff9c8,     0x35007b88,
+    0xb400000b,     0xb4fff96b,     0xb4007b2b,     0xb500001d,
+    0xb5fff91d,     0xb5007add,     0x10000013,     0x10fff8b3,
+    0x10007a73,     0x90000013,     0x36300016,     0x3637f836,
+    0x363079f6,     0x3758000c,     0x375ff7cc,     0x3758798c,
     0x128313a0,     0x528a32c7,     0x7289173b,     0x92ab3acc,
     0xd2a0bf94,     0xf2c285e8,     0x9358722f,     0x330e652f,
     0x53067f3b,     0x93577c53,     0xb34a1aac,     0xd35a4016,
     0x13946c63,     0x93c3dbc8,     0x54000000,     0x54fff5a0,
-    0x54007740,     0x54000001,     0x54fff541,     0x540076e1,
-    0x54000002,     0x54fff4e2,     0x54007682,     0x54000002,
-    0x54fff482,     0x54007622,     0x54000003,     0x54fff423,
-    0x540075c3,     0x54000003,     0x54fff3c3,     0x54007563,
-    0x54000004,     0x54fff364,     0x54007504,     0x54000005,
-    0x54fff305,     0x540074a5,     0x54000006,     0x54fff2a6,
-    0x54007446,     0x54000007,     0x54fff247,     0x540073e7,
-    0x54000008,     0x54fff1e8,     0x54007388,     0x54000009,
-    0x54fff189,     0x54007329,     0x5400000a,     0x54fff12a,
-    0x540072ca,     0x5400000b,     0x54fff0cb,     0x5400726b,
-    0x5400000c,     0x54fff06c,     0x5400720c,     0x5400000d,
-    0x54fff00d,     0x540071ad,     0x5400000e,     0x54ffefae,
-    0x5400714e,     0x5400000f,     0x54ffef4f,     0x540070ef,
+    0x54007760,     0x54000001,     0x54fff541,     0x54007701,
+    0x54000002,     0x54fff4e2,     0x540076a2,     0x54000002,
+    0x54fff482,     0x54007642,     0x54000003,     0x54fff423,
+    0x540075e3,     0x54000003,     0x54fff3c3,     0x54007583,
+    0x54000004,     0x54fff364,     0x54007524,     0x54000005,
+    0x54fff305,     0x540074c5,     0x54000006,     0x54fff2a6,
+    0x54007466,     0x54000007,     0x54fff247,     0x54007407,
+    0x54000008,     0x54fff1e8,     0x540073a8,     0x54000009,
+    0x54fff189,     0x54007349,     0x5400000a,     0x54fff12a,
+    0x540072ea,     0x5400000b,     0x54fff0cb,     0x5400728b,
+    0x5400000c,     0x54fff06c,     0x5400722c,     0x5400000d,
+    0x54fff00d,     0x540071cd,     0x5400000e,     0x54ffefae,
+    0x5400716e,     0x5400000f,     0x54ffef4f,     0x5400710f,
     0xd40658e1,     0xd4014d22,     0xd4046543,     0xd4273f60,
     0xd44cad80,     0xd503201f,     0xd503203f,     0xd503205f,
     0xd503209f,     0xd50320bf,     0xd503219f,     0xd50323bf,
@@ -1459,8 +1460,8 @@
     0x65f1af0b,     0x65eec9f1,     0x65a7fed6,     0x65aa5f65,
     0x65b47aae,     0x04c55723,     0x0441723d,     0x042d33ae,
     0x04be3051,     0x047d32b6,     0x04e03048,     0x05a06ad7,
-    0x05776f59,     0x041a3435,     0x0498356a,     0x04d93917,
-    0x04883671,     0x04ca35a4,     0x65c73fd6,     0x658631d1,
-    0x65983e8c,     0x04012da1,
+    0x05776f59,     0x4501b2b5,     0x049a356a,     0x04d83917,
+    0x04993671,     0x04c835a4,     0x04ca3fd6,     0x658731d1,
+    0x65863e8c,     0x65982da1,     0x04812967,
   };
 // END  Generated code -- do not edit