public class MyJVMTest_1608 {

    static byte result = -77;

    byte check(byte result) throws Exception {
        if (result != 2) {
            if (result == 1) {
                throw new Exception("critical native arguments mismatch");
            }
            throw new Exception("critical native lookup failed");
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1608().check(result);
    }
}
