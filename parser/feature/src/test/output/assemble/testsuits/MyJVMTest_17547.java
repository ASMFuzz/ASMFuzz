import java.io.*;

public class MyJVMTest_17547 {

    static int t = -417010372;

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
        System.out.println(new MyJVMTest_17547().termString(t));
    }
}
