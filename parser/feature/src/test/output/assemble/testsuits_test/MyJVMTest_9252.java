import java.io.*;
import javax.tools.*;

public class MyJVMTest_9252 {

    static Diagnostic<? extends JavaFileObject> message = null;

    Diagnostic<? extends JavaFileObject> report(Diagnostic<? extends JavaFileObject> message) {
        JavaFileObject fo = message.getSource();
        if ("__input".equals(fo.toUri().getPath()))
            throw new AssertionError(fo);
        System.out.println(message);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9252().report(message);
    }
}
