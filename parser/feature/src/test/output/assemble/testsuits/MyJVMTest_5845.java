import java.util.Arrays;

public class MyJVMTest_5845 {

    static int length = 0;

    Object test(int length) {
        Object[] src = new Object[length];
        final Object[] dst = Arrays.copyOf(src, 10);
        final Object[] dst2 = Arrays.copyOf(dst, 100);
        final Object v = dst[0];
        return v;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5845().test(length));
    }
}
