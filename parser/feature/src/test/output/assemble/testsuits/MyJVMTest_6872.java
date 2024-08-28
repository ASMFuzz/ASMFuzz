public class MyJVMTest_6872 {

    static int[] a = { 8, 6, -1550638010, 9, 0, 891120460, -290100129, 4, 1474482307, 1 };

    int sum2(int[] a) {
        int result1 = 1;
        int result2 = 1;
        for (Integer i : a) {
            result1 += i;
            result2 += i + 1;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6872().sum2(a));
    }
}
