public class MyJVMTest_3836 {

    static int port = 0;

    static int EXIT_VALUE = 123;

    int checkListen(int port) {
        System.exit(EXIT_VALUE);
        return port;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3836().checkListen(port);
    }
}
