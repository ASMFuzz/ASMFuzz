public class MyJVMTest_1589 {

    static int x = 4;

    static int[] array = { 0, 0, 8, -251814748, 0, 8, 329484396, 5, 0, 2012858393 };

    boolean test3(int x, int[] array) {
        try {
            int v = array[x & (array.length - 1)];
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1589().test3(x, array));
    }
}
