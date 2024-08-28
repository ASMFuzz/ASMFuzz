public class MyJVMTest_1284 {

    static int error = 0;

    static String errorName = "t9j%*\\xqV)";

    static String file = "nZm\"Ee0f5h";

    static String function = "sAPc{~uiq^";

    static int line = 2;

    static String message = "hFA_eAY/WK";

    String getMessage() {
        String msg = "";
        msg += "\tError: " + error + "  " + errorName + "\n";
        msg += "\t\t" + message + "\n";
        msg += "\t\tLocation: " + file + " -> [" + function + "():" + line + "]\n";
        return msg;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1284().getMessage());
    }
}
