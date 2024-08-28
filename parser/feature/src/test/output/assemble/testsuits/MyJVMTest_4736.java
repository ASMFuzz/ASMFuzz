import javax.net.ssl.*;

public class MyJVMTest_4736 {

    static String str = "Jb@&c(QZcZ";

    static boolean DEBUG = false;

    String log(String str) {
        if (DEBUG) {
            System.err.println(str);
        }
        return str;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4736().log(str);
    }
}
