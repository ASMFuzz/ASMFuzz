public class MyJVMTest_5900 {

    static BadPredicateAfterPartialPeel o1 = null;

    static BadPredicateAfterPartialPeel o2 = null;

    static BadPredicateAfterPartialPeel o = null;

    static int i4 = 1208603041;

    void not_inlined1() {
    }

    int m_helper(int i, int i3, int i4) {
        return i3 == 4 ? i4 : i;
    }

    void not_inlined4() {
    }

    static float[] array = new float[1000];

    static int[] array2 = new int[1000];

    static boolean flag = false;

    static int j = 1670123016;

    int m(BadPredicateAfterPartialPeel o1, BadPredicateAfterPartialPeel o2, BadPredicateAfterPartialPeel o, int i4) {
        int i1 = 1;
        int i2 = 0;
        for (; i2 < 10; i2 += i1) ;
        i2 = i2 / 10;
        int i3 = 2;
        for (; i3 < 4; i3 *= 2) ;
        int i = 0;
        boolean b = true;
        not_inlined1();
        array[0] = -1;
        do {
            o.flag = false;
            o.j = 0;
            if (b) {
                array[i] = 0;
            }
            if (array[0] != 0) {
            }
            if (i >= 10) {
                return;
            }
            i += i2;
            b = false;
            int i5 = m_helper(i, i3, i4);
            if (array[i5] != 0) {
            }
            if (o2.flag) {
            }
            array2[0] = 0;
            array2[1] = 0;
            array2[2] = 0;
            array2[3] = 0;
            array2[4] = 0;
            array2[5] = 0;
            array2[6] = 0;
            array2[7] = 0;
            array2[8] = 0;
            array2[9] = 0;
            array2[10] = 0;
            array2[11] = 0;
            array2[12] = 0;
            array2[13] = 0;
            array2[14] = 0;
            array2[15] = 0;
            array2[16] = 0;
            array2[17] = 0;
            array2[18] = 0;
            array2[19] = 0;
            array2[20] = 0;
            array2[21] = 0;
            array2[22] = 0;
            array2[23] = 0;
            array2[24] = 0;
            array2[25] = 0;
            array2[26] = 0;
            array2[27] = 0;
            array2[28] = 0;
            array2[29] = 0;
            array2[30] = 0;
            array2[31] = 0;
            array2[32] = 0;
            array2[33] = 0;
            array2[34] = 0;
            array2[35] = 0;
            array2[36] = 0;
            array2[37] = 0;
            array2[38] = 0;
            array2[39] = 0;
            array2[40] = 0;
            array2[41] = 0;
            array2[42] = 0;
            array2[43] = 0;
            array2[44] = 0;
            array2[45] = 0;
            array2[46] = 0;
            array2[47] = 0;
            array2[48] = 0;
            array2[49] = 0;
            array2[50] = 0;
            array2[51] = 0;
            array2[52] = 0;
            array2[53] = 0;
            array2[54] = 0;
            array2[55] = 0;
            array2[56] = 0;
            array2[57] = 0;
            array2[58] = 0;
            array2[59] = 0;
            array2[60] = 0;
            array2[61] = 0;
            array2[62] = 0;
            array2[63] = 0;
            array2[64] = 0;
            array2[65] = 0;
            array2[66] = 0;
            array2[67] = 0;
            array2[68] = 0;
            array2[69] = 0;
            array2[70] = 0;
            array2[71] = 0;
            array2[72] = 0;
            array2[73] = 0;
            array2[74] = 0;
            array2[75] = 0;
            array2[76] = 0;
            array2[77] = 0;
            array2[78] = 0;
            array2[79] = 0;
            array2[80] = 0;
            array2[81] = 0;
            array2[82] = 0;
            array2[83] = 0;
            array2[84] = 0;
            array2[85] = 0;
            array2[86] = 0;
            array2[87] = 0;
            array2[88] = 0;
            array2[89] = 0;
            array2[90] = 0;
            array2[91] = 0;
            array2[92] = 0;
            array2[93] = 0;
            array2[94] = 0;
            array2[95] = 0;
            array2[96] = 0;
            array2[97] = 0;
            array2[98] = 0;
            array2[99] = 0;
            array2[100] = 0;
            array2[101] = 0;
            array2[102] = 0;
            array2[103] = 0;
            array2[104] = 0;
            array2[105] = 0;
            array2[106] = 0;
            array2[107] = 0;
            array2[108] = 0;
            array2[109] = 0;
            array2[110] = 0;
            array2[111] = 0;
            array2[112] = 0;
            array2[113] = 0;
            array2[114] = 0;
            array2[115] = 0;
            array2[116] = 0;
            array2[117] = 0;
            array2[118] = 0;
            array2[119] = 0;
            array2[120] = 0;
            array2[121] = 0;
            array2[122] = 0;
            array2[123] = 0;
            array2[124] = 0;
            array2[125] = 0;
            array2[126] = 0;
            array2[127] = 0;
            array2[128] = 0;
            array2[129] = 0;
            array2[130] = 0;
            array2[131] = 0;
            array2[132] = 0;
            array2[133] = 0;
            array2[134] = 0;
            array2[135] = 0;
            array2[136] = 0;
            array2[137] = 0;
            array2[138] = 0;
            array2[139] = 0;
            array2[140] = 0;
            array2[141] = 0;
            array2[142] = 0;
            array2[143] = 0;
            array2[144] = 0;
            array2[145] = 0;
            array2[146] = 0;
            array2[147] = 0;
            array2[148] = 0;
            array2[149] = 0;
            array2[150] = 0;
            array2[151] = 0;
            array2[152] = 0;
            array2[153] = 0;
            array2[154] = 0;
            array2[155] = 0;
            array2[156] = 0;
            array2[157] = 0;
            array2[158] = 0;
            array2[159] = 0;
            array2[160] = 0;
            array2[161] = 0;
            array2[162] = 0;
            array2[163] = 0;
            array2[164] = 0;
            array2[165] = 0;
            array2[166] = 0;
            array2[167] = 0;
            array2[168] = 0;
            array2[169] = 0;
            array2[170] = 0;
            array2[171] = 0;
            array2[172] = 0;
            array2[173] = 0;
            array2[174] = 0;
            array2[175] = 0;
            array2[176] = 0;
            array2[177] = 0;
            array2[178] = 0;
            array2[179] = 0;
            array2[180] = 0;
            array2[181] = 0;
            array2[182] = 0;
            array2[183] = 0;
            array2[184] = 0;
            array2[185] = 0;
            array2[186] = 0;
            array2[187] = 0;
            array2[188] = 0;
            array2[189] = 0;
            array2[190] = 0;
            array2[191] = 0;
            array2[192] = 0;
            array2[193] = 0;
            array2[194] = 0;
            array2[195] = 0;
            array2[196] = 0;
            array2[197] = 0;
            array2[198] = 0;
            array2[199] = 0;
            if (o1.j >= 20) {
                break;
            }
            o1.j++;
        } while (true);
        not_inlined4();
        return i2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5900().m(o1, o2, o, i4);
    }
}
