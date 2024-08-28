public class MyJVMTest_4160 {

    static int[] a = { 0, 6, 0, -1419598911, 8, 0, 0, 1, 4, 1418330835 };

    static int[] b = { 5, 1, 0, 5, 0, 0, 3, -1582390546, 9, 4 };

    int[] prodReductionInit(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 2;
            b[i] = i + 1;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4160().prodReductionInit(a, b);
    }
}
