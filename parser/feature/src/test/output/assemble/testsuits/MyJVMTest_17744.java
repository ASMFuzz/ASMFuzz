public class MyJVMTest_17744 {

    static long val = 9223372036854775807L;

    long testRorAddLong16(long val) {
        return (val >>> 16) + (val << (64 - 16));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17744().testRorAddLong16(val));
    }
}
