import javax.tools.*;
import java.io.File;

public class MyJVMTest_8297 {

    static Diagnostic<? extends JavaFileObject> message = null;

    Diagnostic<? extends JavaFileObject> report(Diagnostic<? extends JavaFileObject> message) {
        System.out.println(message.getSource() + ":" + message.getStartPosition() + ":" + message.getStartPosition() + ":" + message.getPosition());
        System.out.println(message.toString());
        System.out.format("Found problem: %s%n", message.getCode());
        System.out.flush();
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8297().report(message);
    }
}
