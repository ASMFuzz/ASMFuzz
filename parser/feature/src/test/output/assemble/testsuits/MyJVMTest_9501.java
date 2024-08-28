public class MyJVMTest_9501 {

    static String message = "w#.]bQ\\Az=";

    static int failed = 0, passed = 0;

    String failed(String message) {
        System.out.println(message);
        failed++;
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9501().failed(message);
    }
}
