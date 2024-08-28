public class MyJVMTest_9618 {

    static Class c = null;

    boolean test1(Class c) {
        return A.class.isAssignableFrom(c);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9618().test1(c));
    }
}
