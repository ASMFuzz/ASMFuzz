public class MyJVMTest_15553 {

    String staticProtectedMethod() {
        return "I am a cross-package public static method";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15553().staticProtectedMethod());
    }
}
