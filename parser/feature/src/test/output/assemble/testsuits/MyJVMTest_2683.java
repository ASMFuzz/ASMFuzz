public class MyJVMTest_2683 {

    static boolean[] o = { true, true, false, false, false, false, true, true, false, false };

    static int nonStaticPublicField = 1161122727;

    static int nonStaticFinalPublicField = 0;

    int getLength(boolean[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2683().getLength(o));
    }
}
