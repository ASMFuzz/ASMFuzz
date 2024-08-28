import java.util.Arrays;

public class MyJVMTest_4140 {

    static int[] src = { 0, -800552098, -1129087005, 2, 3, -666865107, 0, 9, 1846659837, 4 };

    static int l = 0;

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
        System.out.println(Arrays.asList(new MyJVMTest_4140().m1(src, l)));
    }
}
