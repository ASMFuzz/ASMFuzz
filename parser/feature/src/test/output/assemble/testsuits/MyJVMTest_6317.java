public class MyJVMTest_6317 {

    static byte[] a1 = { -72, 76, -33, -123, -61, -97, -54, -69, -50, 33 };

    static byte[] a2 = { 68, 109, -34, 126, 32, 68, -21, -60, 127, -98 };

    boolean messagesEqual(byte[] a1, byte[] a2) {
        if (a1.length != a2.length)
            return false;
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6317().messagesEqual(a1, a2));
    }
}
