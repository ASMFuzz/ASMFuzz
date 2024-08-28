public class MyJVMTest_4787 {

    static int[] a = { 5, 0, 3, 0, 7, 2, -1971229345, 6, -574623190, 655623950 };

    int checkSum(int[] a) {
        int sum = 0;
        for (int j = 0; j < a.length; j++) {
            sum += a[j] % (j + 1);
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4787().checkSum(a));
    }
}
