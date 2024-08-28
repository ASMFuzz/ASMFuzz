public class MyJVMTest_12234 {

    static byte[] bytes = { -120, -81, 100, -30, 57, -76, 77, -111, 96, -84 };

    static int startIndex = -1819304309;

    static byte[] matching = { 49, 56, 29, -86, 123, 76, 68, -124, -127, 10 };

    boolean matches(byte[] bytes, int startIndex, byte[] matching) {
        for (int i = 0; i < matching.length; i++) {
            if (bytes[startIndex + i] != matching[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12234().matches(bytes, startIndex, matching));
    }
}
