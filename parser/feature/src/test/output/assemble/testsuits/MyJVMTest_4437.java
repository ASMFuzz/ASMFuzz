import java.util.Arrays;

public class MyJVMTest_4437 {

    static int[] src = { 2, -556890223, 3, 9, 0, 6, 2, -594217619, 1, 0 };

    static int length = 636503026;

    int[] m4(int[] src, int length) {
        int tmp = src[0];
        int[] dest = new int[10];
        try {
            System.arraycopy(src, 0, dest, 0, length);
        } catch (IndexOutOfBoundsException npe) {
        }
        return dest;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_4437().m4(src, length)));
    }
}
