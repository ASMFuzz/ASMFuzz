public class MyJVMTest_8938 {

    static int port = 0;

    static int EXIT_VALUE = 123;

    int checkListen(int port) {
        System.exit(EXIT_VALUE);
        return port;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8938().checkListen(port);
    }
}
