public class MyJVMTest_9329 {

    static byte[] o = { -16, -65, -6, 66, -88, -105, 103, -108, -46, -19 };

    static int nonStaticPublicField = 2092009311;

    static int nonStaticFinalPublicField = 0;

    int getLength(byte[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9329().getLength(o));
    }
}
