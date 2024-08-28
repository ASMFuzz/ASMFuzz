public class MyJVMTest_7763 {

    static String message = "CH6\\`S`/io";

    static int errors = 6;

    String error(String message) {
        System.out.println(message);
        errors++;
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7763().error(message);
    }
}
