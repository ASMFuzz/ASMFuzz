public class MyJVMTest_3489 {

    static int flag = 0;

    static String[] FLAGNAMES = { "DIRECTION_DEFAULT_LEFT_TO_RIGHT", "DIRECTION_DEFAULT_RIGHT_TO_LEFT", "DIRECTION_LEFT_TO_RIGHT", "DIRECTION_RIGHT_TO_LEFT" };

    static char L = '\u200E';

    String getFlagName(int flag) {
        if (flag == -2 || flag == 0x7e)
            return FLAGNAMES[0];
        else if (flag == -1 || flag == 0x7f)
            return FLAGNAMES[1];
        else if (flag == 0)
            return FLAGNAMES[2];
        else if (flag == 1)
            return FLAGNAMES[3];
        else
            return "Unknown(0x" + Integer.toHexString(flag) + ")";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3489().getFlagName(flag));
    }
}
