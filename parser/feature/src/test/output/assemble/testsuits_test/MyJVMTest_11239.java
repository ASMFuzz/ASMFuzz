public class MyJVMTest_11239 {

    static int nonStaticPublicField = 0;

    String finalProtectedMethod() {
        return "finalProtectedMethod";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11239().finalProtectedMethod());
    }
}
