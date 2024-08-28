public class MyJVMTest_12350 {

    static String message = "2=\\=-.Ku5A";

    static int errors = 0;

    String fail(String message) {
        errors++;
        System.err.println(message);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12350().fail(message);
    }
}
