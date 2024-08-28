public class MyJVMTest_2543 {

    static int i1 = 1, i2 = -1913516501, i3 = 0, i4 = 0, i5 = 6, i6 = -1833005876, i7 = 9, i8 = 4, i9 = 7, i10 = 0, i11 = 5, i12 = 763218646, i13 = 0;

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
        System.out.println(new MyJVMTest_2543().fopt());
    }
}
