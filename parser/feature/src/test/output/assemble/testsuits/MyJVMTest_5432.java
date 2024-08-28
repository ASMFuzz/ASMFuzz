public class MyJVMTest_5432 {

    static byte[] result = { -8, 18, 48, -126, 84, -125, -20, 111, -87, -128 };

    static int count = 100;

    byte[] generateSeed(byte[] result) {
        count--;
        return result;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5432().generateSeed(result);
    }
}
