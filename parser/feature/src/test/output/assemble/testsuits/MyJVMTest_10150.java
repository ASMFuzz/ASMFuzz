public class MyJVMTest_10150 {

    static T t = null;

    boolean test(T t) {
        System.out.println("Default method");
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10150().test(t));
    }
}
