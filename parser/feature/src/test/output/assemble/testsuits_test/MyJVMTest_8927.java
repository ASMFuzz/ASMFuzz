public class MyJVMTest_8927 {

    static Object in = 1849448419;

    String foo(Object in) {
        return "a";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8927().foo(in));
    }
}
