public class MyJVMTest_1921 {

    static int[] o = { 0, 553203015, 0, 0, 9, 8, 285217449, 6, 4, 4 };

    static int nonStaticPublicField = 3;

    static int nonStaticFinalPublicField = 2;

    int getLength(int[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1921().getLength(o));
    }
}
