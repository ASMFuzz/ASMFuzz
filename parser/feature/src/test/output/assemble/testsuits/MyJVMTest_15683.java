public class MyJVMTest_15683 {

    static int x = 0;

    static int y = 20;

    static int[] intArr = new int[21000];

    int test2() {
        int i = 0;
        while (i < 100) {
            int j = 0;
            while (j < 10000) {
                if (x == 100) {
                    y = 34;
                }
                intArr[2 * j + 35] = 45;
                if (x == 100) {
                    y = 35;
                    break;
                }
                if (j == 9800) {
                    return 2;
                }
                j++;
            }
            i++;
            intArr[i] = 45;
        }
        return y;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15683().test2());
    }
}
