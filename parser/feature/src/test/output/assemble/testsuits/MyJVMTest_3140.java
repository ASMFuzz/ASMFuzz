import javax.smartcardio.*;

public class MyJVMTest_3140 {

    static String s = "pwk*o12hJ}";

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
        new MyJVMTest_3140().invalid(s);
    }
}
