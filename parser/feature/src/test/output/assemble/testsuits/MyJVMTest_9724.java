import java.util.Arrays;

public class MyJVMTest_9724 {

    static Object[] array = { 3, -193937553, 0, 0, 8, 3, 0, -1306256005, -79234980, 3 };

    static boolean flag = true;

    Object[] m1_helper(Object[] array, boolean flag) {
        if (flag) {
            return Arrays.copyOf(array, 10, A[].class);
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_9724().m1_helper(array, flag)));
    }
}
