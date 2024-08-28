public class MyJVMTest_8994 {

    static long val = 0;

    long testRorAddLong64(long val) {
        return (val >>> 64) + (val << (64 - 64));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8994().testRorAddLong64(val));
    }
}
