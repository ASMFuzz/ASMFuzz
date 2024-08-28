import java.util.GregorianCalendar;

public class MyJVMTest_957 {

    static StringBuilder msg = new StringBuilder();

    boolean getStatus() {
        return msg.length() == 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_957().getStatus());
    }
}
