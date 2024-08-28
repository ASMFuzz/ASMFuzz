import javax.swing.*;

public class MyJVMTest_10072 {

    static String msg = "$T4s'6%P3b";

    String fail(String msg) {
        throw new RuntimeException(msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10072().fail(msg);
    }
}
