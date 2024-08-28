import java.util.Arrays;

public class MyJVMTest_558 {

    static Object[] array = { 1518874180, 18471152, 2, 7, 0, -1258039453, 0, 5, 0, 0 };

    static boolean flag = true;

    Object[] m1_helper(Object[] array, boolean flag) {
        if (flag) {
            return Arrays.copyOf(array, 10, A[].class);
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_558().m1_helper(array, flag)));
    }
}
