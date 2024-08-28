public class MyJVMTest_4074 {

    static int nonStaticPublicField = 0;

    String defaultMethod() {
        return "defaultMethod";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4074().defaultMethod());
    }
}
