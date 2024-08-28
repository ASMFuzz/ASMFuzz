public class MyJVMTest_6093 {

    String staticProtectedMethod() {
        return "I am a cross-package public static method";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6093().staticProtectedMethod());
    }
}
