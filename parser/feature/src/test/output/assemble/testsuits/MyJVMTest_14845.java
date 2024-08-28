import java.io.*;
import java.util.*;
import java.util.logging.*;

public class MyJVMTest_14845 {

    static LogManager INSTANCE = null;

    static Properties props = initConfig();

    Properties initConfig() {
        Properties props = new Properties();
        props.put(".level", "CONFIG");
        props.put("CustomLogManagerTest.level", "WARNING");
        props.put("CustomLogManagerTest.handlers", "CustomLogManager$CustomHandler");
        props.put("SimpleLogManager.level", "INFO");
        props.put("SimpleLogManager.handlers", "CustomLogManager$CustomHandler");
        props.put("CustomLogManager$CustomHandler.level", "WARNING");
        props.put(".handlers", "CustomLogManager$CustomHandler");
        props.put("org.foo.bar.level", "SEVERE");
        props.put("org.foo.bar.useParentHandlers", "true");
        props.put("org.foo.handlers", "CustomLogManager$CustomHandler");
        props.put("org.foo.useParentHandlers", "false");
        props.put("org.openjdk.level", "SEVERE");
        props.put("org.openjdk.handlers", "CustomLogManager$CustomHandler");
        props.put("org.openjdk.core.level", "INFO");
        props.put("org.openjdk.core.useParentHandlers", "false");
        return props;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14845().initConfig());
    }
}
