public class MyJVMTest_8605 {

    static String message = "P]Qmz'`?o9";

    String error(String message) {
        throw new RuntimeException(message);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8605().error(message);
    }
}
