import java.util.Arrays;

public class MyJVMTest_3168 {

    static int[] a2 = { 0, 827330300, 5, 2120437404, 0, 7, 6, 0, -652900897, 0 };

    int[] m1(int[] a2) {
        int[] a1 = new int[10];
        System.arraycopy(a1, 0, a2, 0, 10);
        return a1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_3168().m1(a2)));
    }
}
