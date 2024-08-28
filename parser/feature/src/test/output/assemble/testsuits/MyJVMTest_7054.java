public class MyJVMTest_7054 {

    static short[] o = { 2810, 0, 0, 32767, -32768, -32768, 32767, 8377, 32767, 18917 };

    static int nonStaticPublicField = 1242107051;

    static int nonStaticFinalPublicField = 5;

    int getLength(short[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7054().getLength(o));
    }
}
