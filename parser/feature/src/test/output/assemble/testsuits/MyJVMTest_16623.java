public class MyJVMTest_16623 {

    static int nonStaticPublicField = 5;

    String protectedMethod() {
        return "protectedMethod";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16623().protectedMethod());
    }
}
