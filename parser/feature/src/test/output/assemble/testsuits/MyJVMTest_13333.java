public class MyJVMTest_13333 {

    static int[] array = { 0, -1509195385, -1829332402, -1776549117, 0, -1543217503, 0, 389868417, 0, 0 };

    int[] test(int[] array) {
        array[0] = 1;
        array[array.length - 1] = 1;
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13333().test(array);
    }
}
