import javax.swing.*;

public class MyJVMTest_891 {

    static String msg = "O2;8J*ax3l";

    String fail(String msg) {
        throw new RuntimeException(msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_891().fail(msg);
    }
}
