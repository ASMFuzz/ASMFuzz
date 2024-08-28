public class MyJVMTest_794 {

    static int x = 2;

    static int[] array = { 0, 2, 0, 0, 1, 0, 2, 9, 998040990, 9 };

    boolean test2(int x, int[] array) {
        int m = array.length;
        if ((x & (m - 1)) < 0 || (x & (m - 1)) >= m) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_794().test2(x, array));
    }
}
