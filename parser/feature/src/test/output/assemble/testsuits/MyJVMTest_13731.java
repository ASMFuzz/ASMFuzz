import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_13731 {

    static String name = "X[9xGu0;\"s";

    static DirContext ctx = null;

    String unbind(String name) throws NamingException {
        throw new OperationNotSupportedException();
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13731().unbind(name);
    }
}
