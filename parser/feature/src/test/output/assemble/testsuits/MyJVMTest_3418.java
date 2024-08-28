import java.util.Arrays;

public class MyJVMTest_3418 {

    static Object[] src = { 7, 8, 0, 1, 6, -772220453, -1128000698, 9, 1421323202, 6 };

    H[] m6(Object[] src) {
        Object tmp = src[0];
        H[] dest = new H[10];
        System.arraycopy(src, 0, dest, 0, 10);
        return dest;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_3418().m6(src)));
    }
}
