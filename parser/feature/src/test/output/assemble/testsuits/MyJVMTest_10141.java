import java.util.GregorianCalendar;

public class MyJVMTest_10141 {

    static StringBuilder msg = new StringBuilder();

    boolean getStatus() {
        return msg.length() == 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10141().getStatus());
    }
}
