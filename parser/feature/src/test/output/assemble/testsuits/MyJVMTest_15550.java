import java.util.Arrays;

public class MyJVMTest_15550 {

    static Object src = -253686860;

    static boolean flag = false;

    Object m7_src(Object src) {
        return src;
    }

    int[] m7(Object src, boolean flag) {
        Class tmp = src.getClass();
        if (flag) {
            return null;
        }
        src = m7_src(src);
        int[] dest = new int[10];
        try {
            System.arraycopy(src, 0, dest, 0, 10);
        } catch (ArrayStoreException npe) {
        }
        return dest;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_15550().m7(src, flag)));
    }
}
