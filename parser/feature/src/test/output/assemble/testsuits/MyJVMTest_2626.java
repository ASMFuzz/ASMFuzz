public class MyJVMTest_2626 {

    static long val = 7281604848476468519L;

    long testRorOrLong1(long val) {
        return (val >>> 1) | (val << (64 - 1));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2626().testRorOrLong1(val));
    }
}
