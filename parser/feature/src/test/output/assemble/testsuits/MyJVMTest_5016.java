import java.util.Arrays;

public class MyJVMTest_5016 {

    static int[] src = { 0, 0, 1, 5, 7, -1462243364, 5, 921388228, 0, 0 };

    int[] m1(int[] src) {
        int[] dest = new int[10];
        try {
            System.arraycopy(src, 0, dest, 0, 10);
        } catch (NullPointerException npe) {
        }
        return dest;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_5016().m1(src)));
    }
}
