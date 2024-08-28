public class MyJVMTest_9973 {

    static int x = -503664858;

    static int[] array = { 0, 0, 9, 0, 0, 2, 6, 3, 4, -1716702409 };

    boolean test2(int x, int[] array) {
        int m = array.length;
        if ((x & (m - 1)) < 0 || (x & (m - 1)) >= m) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9973().test2(x, array));
    }
}
