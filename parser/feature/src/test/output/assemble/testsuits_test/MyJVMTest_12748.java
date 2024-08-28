import java.util.Arrays;

public class MyJVMTest_12748 {

    static Object[] src = { 1962383713, 0, 7, 6, 0, 0, 2, 1099242566, 707842712, 0 };

    H[] m6(Object[] src) {
        Object tmp = src[0];
        H[] dest = new H[10];
        System.arraycopy(src, 0, dest, 0, 10);
        return dest;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12748().m6(src)));
    }
}
