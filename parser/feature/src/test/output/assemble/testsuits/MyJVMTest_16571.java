public class MyJVMTest_16571 {

    static short[] o = { 32559, -32768, -32768, 0, -17236, 0, 0, -32768, 0, 14546 };

    static int nonStaticPublicField = -1103327282;

    static int nonStaticFinalPublicField = 0;

    int getLength(short[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16571().getLength(o));
    }
}
