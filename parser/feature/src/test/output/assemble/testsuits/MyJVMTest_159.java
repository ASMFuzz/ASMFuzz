public class MyJVMTest_159 {

    static int[] a = { 0, 9, 1, 1167691831, 1362091178, 9, 4, 9, 3, 2 };

    static int[] iArrFld = new int[10];

    int[] init(int[] a) {
        for (int j = 0; j < a.length; j++) {
            a[j] = j;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_159().init(a);
    }
}
