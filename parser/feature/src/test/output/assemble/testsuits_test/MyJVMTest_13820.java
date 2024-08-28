import java.util.Arrays;

public class MyJVMTest_13820 {

    static int[] src = { 0, 275538312, 0, 778484675, 0, 5, 0, -1256559438, 0, 6 };

    static int length = 0;

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
        System.out.println(Arrays.asList(new MyJVMTest_13820().m4(src, length)));
    }
}
