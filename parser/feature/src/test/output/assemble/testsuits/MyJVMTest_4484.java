public class MyJVMTest_4484 {

    static String msg = "&/Sm8eaj_:";

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
        new MyJVMTest_4484().log(msg);
    }
}
