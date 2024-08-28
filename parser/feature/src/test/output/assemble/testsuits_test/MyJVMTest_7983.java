import java.io.*;

public class MyJVMTest_7983 {

    static int t = 1806794230;

    static DataOutputStream uo = null;

    static BufferedWriter to = null;

    static PrintWriter log = null;

    String termString(int t) {
        switch(t) {
            case 0:
                return "\n";
            case 1:
                return "\r";
            case 2:
                return "\r\n";
            default:
                return "";
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7983().termString(t));
    }
}
