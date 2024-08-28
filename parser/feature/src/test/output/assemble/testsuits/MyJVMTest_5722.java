public class MyJVMTest_5722 {

    static String message = "a;k(WAM;.2";

    String fail(String message) {
        throw new RuntimeException(message);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5722().fail(message);
    }
}
