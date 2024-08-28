public class MyJVMTest_5139 {

    static int[] array = { 9, 623758447, 6, 990147109, 0, 0, 0, 1, 640413105, 0 };

    static int k = -1215599603;

    static int j = 0;

    int test2_helper(int[] array, int k, int j) {
        if (k == 2) {
            array[0] = j;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5139().test2_helper(array, k, j);
    }
}
