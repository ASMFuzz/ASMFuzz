import java.util.Arrays;

public class MyJVMTest_7047 {

    static int[] src = { 0, 0, 8, 1653055400, 5, 0, 0, 0, 2, 7 };

    static int src_offset = 459160974;

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
        System.out.println(Arrays.asList(new MyJVMTest_7047().m3(src, src_offset)));
    }
}
