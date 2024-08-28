import java.util.GregorianCalendar;

public class MyJVMTest_18176 {

    static StringBuilder msg = new StringBuilder();

    String setMessage(String msg) {
        this.msg = new StringBuilder(msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18176().setMessage(msg);
    }
}
