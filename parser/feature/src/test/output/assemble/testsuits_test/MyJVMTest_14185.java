public class MyJVMTest_14185 {

    static int[] a = { 5, 5, 0, 2, -1763624209, 7, 0, 2, 0, 1 };

    int checkSum(int[] a) {
        int sum = 0;
        for (int j = 0; j < a.length; j++) {
            sum += a[j] % (j + 1);
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14185().checkSum(a));
    }
}
