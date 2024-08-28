public class MyJVMTest_714 {

    static long val = -4709269843229190819L;

    long testRorAddLong1(long val) {
        return (val >>> 1) + (val << (64 - 1));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_714().testRorAddLong1(val));
    }
}
