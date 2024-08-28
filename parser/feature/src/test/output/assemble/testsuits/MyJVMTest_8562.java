public class MyJVMTest_8562 {

    static int[] arr = { 1478330006, -1315585844, 0, 0, 4, 1, -28813293, 0, -1849084334, 1541110037 };

    static int inc = 4;

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
        new MyJVMTest_8562().test(arr, inc);
    }
}
