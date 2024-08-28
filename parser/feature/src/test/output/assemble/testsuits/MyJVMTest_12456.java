import javax.smartcardio.*;

public class MyJVMTest_12456 {

    static String s = "QMvCfPX46O";

    String invalid(String s) throws Exception {
        try {
            CardPermission c = new CardPermission("*", s);
            throw new Exception("Created invalid action: " + c);
        } catch (IllegalArgumentException e) {
            System.out.println("OK: " + e);
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12456().invalid(s);
    }
}
