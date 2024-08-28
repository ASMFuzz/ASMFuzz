public class MyJVMTest_11483 {

    static String message = "f$_{M!,;FM";

    static String causeParam1Param1 = "='%2<&ZtYq";

    static Throwable causeParam1 = new Throwable(causeParam1Param1);

    static Throwable cause = new Throwable(causeParam1);

    String fail(String message, Throwable cause) {
        throw new RuntimeException(message, cause);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11483().fail(message, cause);
    }
}
