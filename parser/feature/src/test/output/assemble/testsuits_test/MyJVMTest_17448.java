import javax.tools.*;

public class MyJVMTest_17448 {

    static String msg = "^+@]G3'o}J";

    String error(String msg) {
        throw new AssertionError(msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17448().error(msg);
    }
}
