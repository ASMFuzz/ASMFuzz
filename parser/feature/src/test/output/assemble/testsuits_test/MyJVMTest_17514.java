public class MyJVMTest_17514 {

    static byte[] a = { 83, -11, 91, -24, -107, -126, -109, 49, 86, -93 };

    static byte[] b = { -95, 10, 34, -95, 33, 41, 67, 52, 99, -95 };

    boolean equals(byte[] a, byte[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++) if (a[i] != b[i])
            return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17514().equals(a, b));
    }
}
