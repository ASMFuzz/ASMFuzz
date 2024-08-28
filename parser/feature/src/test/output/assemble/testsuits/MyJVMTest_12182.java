public class MyJVMTest_12182 {

    static int[] a = { 1758321561, 2, 0, 2, 0, -1392372114, 0, 9, 0, 0 };

    static int h = -1086501855;

    long l(int[] a) {
        long m = 0;
        for (int i = 0; i < a.length; i++) m = a[i];
        return m;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12182().l(a));
    }
}
