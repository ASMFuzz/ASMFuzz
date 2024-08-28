import java.util.GregorianCalendar;

public class MyJVMTest_9600 {

    static StringBuilder msg = new StringBuilder();

    String appendMessage(String msg) {
        this.msg.append(msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9600().appendMessage(msg);
    }
}
