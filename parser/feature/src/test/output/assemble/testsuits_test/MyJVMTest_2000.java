public class MyJVMTest_2000 {

    static int nonStaticPublicField = 8;

    String finalProtectedMethod() {
        return "finalProtectedMethod";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2000().finalProtectedMethod());
    }
}
