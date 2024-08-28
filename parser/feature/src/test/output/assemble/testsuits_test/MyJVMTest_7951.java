public class MyJVMTest_7951 {

    static byte[] a = { -119, -35, 29, -101, -9, 13, 42, -53, 59, -66 };

    static byte[] b = { -91, -36, 25, 120, 49, 109, 96, -30, -49, -125 };

    boolean equals(byte[] a, byte[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++) if (a[i] != b[i])
            return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7951().equals(a, b));
    }
}
