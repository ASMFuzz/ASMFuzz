public class MyJVMTest_2229 {

    static String message = "$ro!AL}E#e";

    static Throwable causeParam1Param1 = new Throwable();

    static Throwable causeParam1 = new Throwable(causeParam1Param1);

    static Throwable cause = new Throwable(causeParam1);

    String fail(String message, Throwable cause) {
        throw new RuntimeException(message, cause);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2229().fail(message, cause);
    }
}
