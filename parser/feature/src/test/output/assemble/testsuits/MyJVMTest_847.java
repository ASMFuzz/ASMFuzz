public class MyJVMTest_847 {

    static String message = "v[#l=3$`VT";

    static boolean error = false;

    String error(String message) {
        System.err.println(message);
        error = true;
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_847().error(message);
    }
}
