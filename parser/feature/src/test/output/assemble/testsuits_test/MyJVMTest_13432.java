public class MyJVMTest_13432 {

    static int nonStaticPublicField = 6;

    String defaultMethod() {
        return "defaultMethod";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13432().defaultMethod());
    }
}
