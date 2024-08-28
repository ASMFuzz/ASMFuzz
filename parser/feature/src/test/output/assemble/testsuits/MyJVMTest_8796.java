public class MyJVMTest_8796 {

    static long val = -6770182005042129721L;

    long testRorOrLong1Bic(long val) {
        return val & (-1 ^ ((val >>> 1) | (val << (64 - 1))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8796().testRorOrLong1Bic(val));
    }
}
