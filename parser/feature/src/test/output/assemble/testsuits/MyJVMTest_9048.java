public class MyJVMTest_9048 {

    static String message = "~7SfwPF*o7";

    String Fail(String message) {
        System.out.println(message);
        System.exit(100);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9048().Fail(message);
    }
}
