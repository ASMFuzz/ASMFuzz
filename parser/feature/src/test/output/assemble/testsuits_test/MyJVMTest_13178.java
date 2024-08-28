public class MyJVMTest_13178 {

    static int port = 4;

    static int EXIT_VALUE = 123;

    int checkListen(int port) {
        System.exit(EXIT_VALUE);
        return port;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13178().checkListen(port);
    }
}
