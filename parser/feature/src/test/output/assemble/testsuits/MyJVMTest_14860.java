public class MyJVMTest_14860 {

    static byte[] result = { 45, 12, 10, -30, 14, 1, 59, -77, -95, -95 };

    static int count = 100;

    byte[] generateSeed(byte[] result) {
        count--;
        return result;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14860().generateSeed(result);
    }
}
