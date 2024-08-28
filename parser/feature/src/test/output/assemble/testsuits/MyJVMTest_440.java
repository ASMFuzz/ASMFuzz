import java.util.GregorianCalendar;

public class MyJVMTest_440 {

    static StringBuilder msg = new StringBuilder();

    String appendMessage(String msg) {
        this.msg.append(msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_440().appendMessage(msg);
    }
}
