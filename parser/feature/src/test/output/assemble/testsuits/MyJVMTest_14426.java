import java.util.Arrays;

public class MyJVMTest_14426 {

    static int[] src = { 0, -917684722, 9, 4, 4, 0, 8, 0, 0, 0 };

    int[] m1(int[] src) {
        int[] dest = new int[10];
        try {
            System.arraycopy(src, 0, dest, 0, 10);
        } catch (NullPointerException npe) {
        }
        return dest;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_14426().m1(src)));
    }
}
