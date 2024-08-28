public class MyJVMTest_13871 {

    static String msg = "]ybYy6Fwxo";

    void echo(String msg) {
        System.out.println(msg);
    }

    static boolean verbose = false;

    static boolean force = false;

    String log(String msg) {
        if (verbose || force) {
            echo(msg);
        }
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13871().log(msg);
    }
}
