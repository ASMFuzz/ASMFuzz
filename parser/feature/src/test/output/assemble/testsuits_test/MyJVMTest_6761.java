public class MyJVMTest_6761 {

    static int[] array = { 0, 0, 0, 1068627062, 0, 0, 9, -140043082, 0, 8 };

    static int i = 0;

    int accessArrayVariables(int[] array, int i) {
        for (int j = 0; j < 100000; j++) {
            array[i - 2]++;
            array[i - 1]++;
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6761().accessArrayVariables(array, i);
    }
}
