public class MyJVMTest_16602 {

    static String message = "WcGlz+$2]?";

    static Exception e = new Exception();

    static int failed = 1, passed = 0;

    String failed(String message, Exception e) {
        System.out.println(message);
        System.out.println(e);
        failed++;
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16602().failed(message, e);
    }
}
