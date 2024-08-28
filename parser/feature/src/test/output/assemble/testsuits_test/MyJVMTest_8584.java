import java.util.GregorianCalendar;

public class MyJVMTest_8584 {

    static StringBuilder msg = new StringBuilder();

    String setMessage(String msg) {
        this.msg = new StringBuilder(msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8584().setMessage(msg);
    }
}
