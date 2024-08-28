public class MyJVMTest_8965 {

    static int[] a = { -1730133139, 9, 5, 1767784674, 0, 2, -2047792074, 0, 8, 9 };

    static int[] iArrFld = new int[10];

    int[] init(int[] a) {
        for (int j = 0; j < a.length; j++) {
            a[j] = j;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8965().init(a);
    }
}
