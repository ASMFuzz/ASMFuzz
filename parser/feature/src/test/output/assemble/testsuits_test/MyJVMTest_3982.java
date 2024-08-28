public class MyJVMTest_3982 {

    static int[] array = { 0, 1, -549417673, 5, 6, 9, 0, 0, 8, 5 };

    int[] test(int[] array) {
        array[0] = 1;
        array[array.length - 1] = 1;
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3982().test(array);
    }
}
