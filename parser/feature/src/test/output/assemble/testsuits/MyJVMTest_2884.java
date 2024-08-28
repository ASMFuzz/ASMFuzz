public class MyJVMTest_2884 {

    static int[] a = { -1590026042, 767238275, 3, 1223718949, 0, 2, 6, 0, 0, -1699975558 };

    static int h = 2;

    long l(int[] a) {
        long m = 0;
        for (int i = 0; i < a.length; i++) m = a[i];
        return m;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2884().l(a));
    }
}
