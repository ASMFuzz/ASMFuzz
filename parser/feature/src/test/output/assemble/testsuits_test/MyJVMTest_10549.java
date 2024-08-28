public class MyJVMTest_10549 {

    static long val = 9223372036854775807L;

    long testRorAddLong64(long val) {
        return (val >>> 64) + (val << (64 - 64));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10549().testRorAddLong64(val));
    }
}
