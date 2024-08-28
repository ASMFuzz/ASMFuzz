public class MyJVMTest_11968 {

    static boolean[] o = { true, true, true, false, true, false, true, false, true, false };

    static int nonStaticPublicField = 0;

    static int nonStaticFinalPublicField = 0;

    int getLength(boolean[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11968().getLength(o));
    }
}
