import java.util.*;

public class MyJVMTest_1050 {

    static ResourceBundle messages = new ListResourceBundle();

    ResourceBundle checkMessages(ResourceBundle messages) {
        String greetings = messages.getString("greetings");
        String inquiry = messages.getString("inquiry");
        String farewell = messages.getString("farewell");
        System.out.println(greetings);
        System.out.println(inquiry);
        System.out.println(farewell);
        if (!greetings.equals("Hiya.")) {
            throw new RuntimeException("got wrong resource bundle");
        }
        return messages;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1050().checkMessages(messages);
    }
}
