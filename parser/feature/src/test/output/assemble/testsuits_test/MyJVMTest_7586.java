public class MyJVMTest_7586 {

    static int[] array = { -384691992, 0, 0, 3, -535298615, 7, 0, 5, 3, 1 };

    static int i = 9;

    static int dummy = -848263355;

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
        System.out.println(new MyJVMTest_7586().m1(array, i));
    }
}
