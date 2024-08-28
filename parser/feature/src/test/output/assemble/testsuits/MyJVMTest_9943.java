public class MyJVMTest_9943 {

    static int[] a = { -1649132770, 9, 0, 0, 9, 0, 5, 0, 0, -2111171788 };

    static int[] b = { -1601956547, -1080873791, 6439401, 1787838286, -258389152, 6, 992065419, 0, 149372368, 5 };

    static int j = 0;

    int m(int[] a, int[] b, int j) {
        for (int i = 0; i < 10; i++) {
            a[i] = i;
        }
        a[j] = 0;
        a[j + 5] = 0;
        b[j + 4] = 0;
        return j;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9943().m(a, b, j);
    }
}
