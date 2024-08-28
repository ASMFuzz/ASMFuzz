public class MyJVMTest_179 {

    static byte[] o = { 42, 29, 109, -119, -32, -58, -8, 0, 100, 97 };

    static int nonStaticPublicField = -1663508071;

    static int nonStaticFinalPublicField = 0;

    int getLength(byte[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_179().getLength(o));
    }
}
