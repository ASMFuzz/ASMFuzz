public class MyJVMTest_9891 {

    static long val = 0;

    long testRorAddLong1(long val) {
        return (val >>> 1) + (val << (64 - 1));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9891().testRorAddLong1(val));
    }
}
