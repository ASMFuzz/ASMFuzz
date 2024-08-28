public class MyJVMTest_444 {

    static int[] a = { 0, 0, 0, 0, 1, 8, 3, 200823249, 2077598721, 880346624 };

    static int[] b = { -1512248302, 8, 2, 4, -334330228, 1060167591, 9, 3, 5, 0 };

    static int[] c = { 2, 3, 926386574, 3, 0, 1, 0, 5, 0, 0 };

    static int[] d = { 521362545, 4, 0, 1, 9, -1685986524, 9, 0, 0, 736830535 };

    int xorReductionImplement(int[] a, int[] b, int[] c, int[] d) {
        int total = -1;
        for (int i = 0; i < a.length; i++) {
            d[i] = (a[i] * b[i]) + (a[i] * c[i]) + (b[i] * c[i]);
            total ^= d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_444().xorReductionImplement(a, b, c, d));
    }
}
