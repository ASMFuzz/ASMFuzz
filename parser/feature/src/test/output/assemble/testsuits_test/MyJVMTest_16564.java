import java.util.Arrays;

public class MyJVMTest_16564 {

    static int[] src = { 8, 1, 0, -1190189573, 0, 2, 6, 0, 6, 0 };

    static int src_offset = 0;

    int[] m3(int[] src, int src_offset) {
        int tmp = src[0];
        int[] dest = new int[10];
        try {
            System.arraycopy(src, src_offset, dest, 0, 10);
        } catch (IndexOutOfBoundsException npe) {
        }
        return dest;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_16564().m3(src, src_offset)));
    }
}
