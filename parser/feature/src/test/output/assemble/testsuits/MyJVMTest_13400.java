public class MyJVMTest_13400 {

    static int[] array = { 0, 5, 5, 0, 9, 3, -1554892956, 0, 0, -2129775098 };

    int[] notInlined(int[] array) {
        java.util.Arrays.fill(array, 1);
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13400().notInlined(array);
    }
}
