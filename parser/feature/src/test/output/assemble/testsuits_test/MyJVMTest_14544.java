public class MyJVMTest_14544 {

    static byte and = 0b0011, or = 0b0011, xor = 0b0011;

    static byte mask = 0b0101;

    void test() {
        and &= mask;
        or |= mask;
        xor ^= mask;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14544().test();
    }
}
