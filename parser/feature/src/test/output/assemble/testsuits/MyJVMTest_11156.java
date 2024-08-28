public class MyJVMTest_11156 {

    static int[] o = { 0, 4, 0, 3, 0, 7, 3, 0, 8, 6 };

    static int nonStaticPublicField = 1;

    static int nonStaticFinalPublicField = 6;

    int getLength(int[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11156().getLength(o));
    }
}
