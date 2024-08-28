public class MyJVMTest_14017 {

    static int[] ia = { 0, 6, 2, 7, 0, 0, 9, -935743332, 3, 0 };

    static long MASK = -738185717205508349L;

    long doload(int[] ia) {
        return ia[0] & MASK;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14017().doload(ia));
    }
}
