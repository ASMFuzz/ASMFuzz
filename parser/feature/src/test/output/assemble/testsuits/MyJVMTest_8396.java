public class MyJVMTest_8396 {

    static Object in = -541554347;

    String foo(Object in) {
        return "a";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8396().foo(in));
    }
}
