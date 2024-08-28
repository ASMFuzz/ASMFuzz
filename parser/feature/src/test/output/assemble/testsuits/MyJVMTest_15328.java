public class MyJVMTest_15328 {

    static String string = "sa[N_L;&3K";

    static boolean OPT_NOTHROW = false;

    static String id = "O@(WlX@b-Q";

    String err(String string) {
        if (OPT_NOTHROW) {
            System.out.println(id + " ERROR: " + string + " (continuing due to -n)");
        } else {
            throw new InternalError(id + ": " + string);
        }
        return string;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15328().err(string);
    }
}
