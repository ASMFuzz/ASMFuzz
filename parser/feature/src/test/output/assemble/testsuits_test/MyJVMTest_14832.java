public class MyJVMTest_14832 {

    static Object message = 489861301;

    Object complain(Object message) {
        System.err.println("# " + message);
        System.err.flush();
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14832().complain(message);
    }
}
