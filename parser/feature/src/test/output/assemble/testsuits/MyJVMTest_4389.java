import java.util.Arrays;

public class MyJVMTest_4389 {

    static Object src = 7;

    static int mod = Integer.MAX_VALUE;

    int[] m1(Object src) {
        if (src == null)
            return null;
        int[] dest = new int[10];
        try {
            int pos = 8 + mod + mod;
            int start = 2 + mod + mod;
            int len = 12 + mod + mod;
            System.arraycopy(src, pos, dest, 0, 10);
        } catch (ArrayStoreException npe) {
        }
        return dest;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_4389().m1(src)));
    }
}
