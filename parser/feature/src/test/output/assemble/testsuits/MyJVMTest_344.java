public class MyJVMTest_344 {

    static String message = "UVInT/mG<~";

    static int failed = 1, passed = 0;

    String failed(String message) {
        System.out.println(message);
        failed++;
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_344().failed(message);
    }
}
