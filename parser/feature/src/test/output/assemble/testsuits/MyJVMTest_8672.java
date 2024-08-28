public class MyJVMTest_8672 {

    static long val = 227425581882733058L;

    long testRorOrLong16Bic(long val) {
        return val & (-1 ^ ((val >>> 16) | (val << (64 - 16))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8672().testRorOrLong16Bic(val));
    }
}
