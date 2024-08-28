public class MyJVMTest_11819 {

    static int i1 = 5, i2 = 2, i3 = -2026574070, i4 = 0, i5 = 0, i6 = 1507173588, i7 = -1675025106, i8 = 6, i9 = 1, i10 = 0, i11 = 346080213, i12 = 9, i13 = 4;

    static int j = 21;

    static boolean bol = true;

    int fopt() {
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
        res = i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i10 + i11 + i12 + i13;
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11819().fopt());
    }
}
