import javax.tools.*;

public class MyJVMTest_7886 {

    static String msg = "RE}$7Q]BR?";

    String error(String msg) {
        throw new AssertionError(msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7886().error(msg);
    }
}
