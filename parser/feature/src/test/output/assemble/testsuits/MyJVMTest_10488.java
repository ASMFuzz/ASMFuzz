public class MyJVMTest_10488 {

    static int error = -717294023;

    static String errorName = "AAM+vew-e*";

    static String file = ">=Yd|f\"r|b";

    static String function = "qrt0+lOoUH";

    static int line = 1471615024;

    static String message = "Z}7pVce{6'";

    String getMessage() {
        String msg = "";
        msg += "\tError: " + error + "  " + errorName + "\n";
        msg += "\t\t" + message + "\n";
        msg += "\t\tLocation: " + file + " -> [" + function + "():" + line + "]\n";
        return msg;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10488().getMessage());
    }
}
