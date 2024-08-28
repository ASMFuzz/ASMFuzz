public class MyJVMTest_15795 {

    static byte[] a1 = { -22, 90, 22, -24, -81, 61, -87, -3, 116, -62 };

    static byte[] a2 = { -38, 57, -24, 19, 34, -52, -15, 3, 21, 0 };

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
        System.out.println(new MyJVMTest_15795().messagesEqual(a1, a2));
    }
}
