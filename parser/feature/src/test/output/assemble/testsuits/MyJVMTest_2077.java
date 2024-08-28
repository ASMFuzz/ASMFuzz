public class MyJVMTest_2077 {

    static Object message = 0;

    static boolean debug = true;

    Object debug(Object message) {
        if (debug) {
            System.out.println(message);
        }
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2077().debug(message);
    }
}
