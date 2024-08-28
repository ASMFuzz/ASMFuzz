import java.util.GregorianCalendar;

public class MyJVMTest_102 {

    static StringBuilder msg = new StringBuilder();

    String getMessage() {
        String s = msg.toString();
        msg = new StringBuilder();
        return "    " + s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_102().getMessage());
    }
}
