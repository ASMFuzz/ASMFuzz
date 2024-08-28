public class MyJVMTest_17317 {

    static String message = "oPO}>abPwo";

    static int errors = 0;

    String error(String message) {
        System.out.println(message);
        errors++;
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17317().error(message);
    }
}
