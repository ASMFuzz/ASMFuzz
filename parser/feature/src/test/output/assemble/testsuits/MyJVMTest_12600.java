import java.util.Arrays;

public class MyJVMTest_12600 {

    static Object src = 0;

    static boolean flag = true;

    int[] m2(Object src, boolean flag) {
        Class tmp = src.getClass();
        if (flag) {
            return null;
        }
        int[] dest = new int[10];
        try {
            System.arraycopy(src, 0, dest, 0, 10);
        } catch (ArrayStoreException npe) {
        }
        return dest;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12600().m2(src, flag)));
    }
}
