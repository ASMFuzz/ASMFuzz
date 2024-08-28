import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_918 {

    static String name = "<2Q.%>%|6~";

    static String prefix = "$[CT-<_4uX";

    static DirContext ctx = null;

    String composeName(String name, String prefix) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_918().composeName(name, prefix));
    }
}
