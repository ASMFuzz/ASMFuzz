public class MyJVMTest_18153 {

    static int[] arr = { 9, 2, 496560835, 0, 2, 5, 1402055882, 0, 5, 1 };

    static int inc = 1414971205;

    int[] test(int[] arr, int inc) {
        int i = 0;
        for (; ; ) {
            for (int j = 0; j < 10; j++) ;
            arr[i] = i;
            i++;
            if (i >= 100) {
                break;
            }
            for (int j = 0; j < 10; j++) ;
        }
        return arr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18153().test(arr, inc);
    }
}
