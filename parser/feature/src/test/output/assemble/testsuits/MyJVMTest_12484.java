import java.util.Arrays;

public class MyJVMTest_12484 {

    static int[] a2 = { -1046520537, 4, 2, -1107701733, 7, 2, -74363785, 0, 9, 2 };

    int[] m1(int[] a2) {
        int[] a1 = new int[10];
        System.arraycopy(a1, 0, a2, 0, 10);
        return a1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12484().m1(a2)));
    }
}
