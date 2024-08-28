public class MyJVMTest_10830 {

    static byte result = 123;

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
        new MyJVMTest_10830().check(result);
    }
}
