import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_13242 {

    static String name = "1R1C4a1d${";

    static Object obj = 0;

    static DirContext ctx = null;

    String rebind(String name, Object obj) throws NamingException {
        throw new OperationNotSupportedException();
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13242().rebind(name, obj);
    }
}
