public class MyJVMTest_17131 {

    static int[] array = { -1635292291, 0, 2, 0, 0, 0, 0, 0, 0, 162800727 };

    static int i = 9;

    static int dummy = 7;

    int m1(int[] array, int i) {
        for (; ; ) {
            for (; ; ) {
                if (array[i] < 0) {
                    break;
                }
                i++;
            }
            if ((i % 2) == 0) {
                if ((array[i] % 2) == 0) {
                    dummy = i;
                }
            }
            if (array[i - 1] == 9) {
                int res = array[i - 3];
                res += array[i];
                res += array[i - 2];
                return res;
            }
            i++;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17131().m1(array, i));
    }
}
