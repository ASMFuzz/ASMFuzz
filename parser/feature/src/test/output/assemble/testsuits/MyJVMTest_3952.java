public class MyJVMTest_3952 {

    static int i1 = -85217080, i2 = 0, i3 = 3, i4 = 0, i5 = -1965007244, i6 = -1205661360, i7 = 3, i8 = 0, i9 = 478800723, i10 = 2, i11 = 4, i12 = 0, i13 = 0;

    static boolean i14 = false, i15 = true, i16 = true, i17 = true, i18 = true;

    static int j = 21;

    static boolean bol = true;

    int f() {
        int res;
        i1 = j + 1;
        i2 = j - 1;
        i3 = j * 3;
        i4 = j / 31;
        i5 = j % 71;
        i6 = j << 3;
        i7 = j >> 4;
        i8 = j >>> 5;
        i9 = bol ? 7 : 9;
        i10 = ~j;
        i11 = j & 3;
        i12 = j | 4;
        i13 = j ^ 4;
        i14 = bol && (j < 3);
        i15 = bol || (j > 4);
        i16 = !bol;
        i17 = j == 9;
        i18 = j != 10;
        res = i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i10 + i11 + i12 + i13;
        i14 = i14 && i15 && i16 && i17 && i18;
        i1 = j + 1;
        i2 = j - 1;
        i3 = j * 3;
        i4 = j / 31;
        i5 = j % 71;
        i6 = j << 3;
        i7 = j >> 4;
        i8 = j >>> 5;
        i9 = bol ? 7 : 9;
        i10 = ~j;
        i11 = j & 3;
        i12 = j | 4;
        i13 = j ^ 4;
        i14 = bol && (j < 3);
        i15 = bol || (j > 4);
        i16 = !bol;
        i17 = j == 9;
        i18 = j != 10;
        res = i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i10 + i11 + i12 + i13;
        i14 = i14 && i15 && i16 && i17 && i18;
        i1 = j + 1;
        i2 = j - 1;
        i3 = j * 3;
        i4 = j / 31;
        i5 = j % 71;
        i6 = j << 3;
        i7 = j >> 4;
        i8 = j >>> 5;
        i9 = bol ? 7 : 9;
        i10 = ~j;
        i11 = j & 3;
        i12 = j | 4;
        i13 = j ^ 4;
        i14 = bol && (j < 3);
        i15 = bol || (j > 4);
        i16 = !bol;
        i17 = j == 9;
        i18 = j != 10;
        res = i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i10 + i11 + i12 + i13;
        i14 = i14 && i15 && i16 && i17 && i18;
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3952().f());
    }
}
