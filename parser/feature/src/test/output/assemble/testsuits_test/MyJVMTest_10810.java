public class MyJVMTest_10810 {

    static int x = 8;

    static int[] array = { 237105278, 6, 1, 5, 0, -379388088, 5, 1030345266, 8, 1692973796 };

    boolean test3(int x, int[] array) {
        try {
            int v = array[x & (array.length - 1)];
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10810().test3(x, array));
    }
}
