public class MyJVMTest_458 {

    static Class c = null;

    boolean test1(Class c) {
        return A.class.isAssignableFrom(c);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_458().test1(c));
    }
}
