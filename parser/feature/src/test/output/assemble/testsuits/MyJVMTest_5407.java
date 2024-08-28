public class MyJVMTest_5407 {

    static Object message = 0;

    Object complain(Object message) {
        System.err.println("# " + message);
        System.err.flush();
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5407().complain(message);
    }
}
