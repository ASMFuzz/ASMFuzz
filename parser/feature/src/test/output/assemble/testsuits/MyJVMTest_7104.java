public class MyJVMTest_7104 {

    static int nonStaticPublicField = 1;

    String protectedMethod() {
        return "protectedMethod";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7104().protectedMethod());
    }
}
