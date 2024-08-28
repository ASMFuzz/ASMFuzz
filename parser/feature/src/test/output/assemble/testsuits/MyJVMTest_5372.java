public class MyJVMTest_5372 {

    String staticPrivateMethod() {
        return "I am a private static method";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5372().staticPrivateMethod());
    }
}
