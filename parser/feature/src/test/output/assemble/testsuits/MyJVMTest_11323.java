public class MyJVMTest_11323 {

    static Object message = -1500665365;

    static boolean debug = true;

    Object debug(Object message) {
        if (debug) {
            System.out.println(message);
        }
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11323().debug(message);
    }
}
