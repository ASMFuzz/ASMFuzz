public class MyJVMTest_11852 {

    static String message = "X%e9~khi4(";

    String Fail(String message) {
        System.out.println(message);
        System.exit(100);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11852().Fail(message);
    }
}
