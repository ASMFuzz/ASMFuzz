import java.util.Arrays;

public class MyJVMTest_13501 {

    static int[] src = { 4, 4, 0, 9, 0, -181640195, 1798906826, 1, -1231375046, -1663719524 };

    static int l = 5;

    static int val = 7;

    int[] m1(int[] src, int l) {
        if (src == null) {
            return null;
        }
        int[] dest = new int[10];
        val++;
        try {
            System.arraycopy(src, 0, dest, 0, l);
        } catch (IndexOutOfBoundsException npe) {
        }
        return dest;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_13501().m1(src, l)));
    }
}
