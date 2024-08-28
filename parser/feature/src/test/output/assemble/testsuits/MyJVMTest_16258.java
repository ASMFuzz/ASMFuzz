public class MyJVMTest_16258 {

    static int[] array = { 1608187003, -836815257, 7, 7, 0, 7, -2091092382, 2, 9, 1 };

    static int i = 8;

    int accessArrayVariables(int[] array, int i) {
        for (int j = 0; j < 100000; j++) {
            array[i - 2]++;
            array[i - 1]++;
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16258().accessArrayVariables(array, i);
    }
}
