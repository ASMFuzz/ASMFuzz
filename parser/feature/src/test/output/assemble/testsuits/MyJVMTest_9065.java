public class MyJVMTest_9065 {

    static long val = -7125559038391800020L;

    long testRorAddLong1(long val) {
        return (val >>> 1) + (val << (64 - 1));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9065().testRorAddLong1(val));
    }
}
