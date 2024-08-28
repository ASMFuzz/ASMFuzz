public class MyJVMTest_9074 {

    static long val = 939117852212056901L;

    long testRorOrLong64Bic(long val) {
        return val & (-1 ^ ((val >>> 64) | (val << (64 - 64))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9074().testRorOrLong64Bic(val));
    }
}
