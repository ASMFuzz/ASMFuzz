public class MyJVMTest_9285 {

    static int[] a = { 6, 8, -210241112, 7, 9, 2, 7, 5, -1887029858, 0 };

    long sum(int[] a) {
        long sum = 0;
        for (int index = 0; index < a.length; index++) {
            sum += a[index];
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9285().sum(a));
    }
}
