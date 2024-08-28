public class MyJVMTest_6987 {

    static Class<?> c1 = null;

    static Class<?> c2 = null;

    int test(Class<?> c1, Class<?> c2) {
        if (c1 == null) {
        }
        if (c2 == null) {
        }
        int res = 0;
        if (!c1.isAssignableFrom(c2)) {
            if (c2.isAssignableFrom(c1)) {
                res = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6987().test(c1, c2));
    }
}
