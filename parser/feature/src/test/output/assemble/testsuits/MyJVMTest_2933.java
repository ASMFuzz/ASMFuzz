public class MyJVMTest_2933 {

    static byte[] bytes = { -113, 83, 99, -80, 115, -76, -117, 40, -4, -56 };

    static int startIndex = 213021393;

    static byte[] matching = { 95, -6, 77, 103, 16, -79, -48, -97, 52, -124 };

    boolean matches(byte[] bytes, int startIndex, byte[] matching) {
        for (int i = 0; i < matching.length; i++) {
            if (bytes[startIndex + i] != matching[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2933().matches(bytes, startIndex, matching));
    }
}
