public class MyJVMTest_14797 {

    String staticPrivateMethod() {
        return "I am a private static method";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14797().staticPrivateMethod());
    }
}
