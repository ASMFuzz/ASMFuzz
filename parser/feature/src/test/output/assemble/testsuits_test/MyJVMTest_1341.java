public class MyJVMTest_1341 {

    static long val = -6069362758114330828L;

    long testRorAddLong64(long val) {
        return (val >>> 64) + (val << (64 - 64));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1341().testRorAddLong64(val));
    }
}
