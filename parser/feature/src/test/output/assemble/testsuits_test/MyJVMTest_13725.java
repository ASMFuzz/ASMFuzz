import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_13725 {

    static String name = "B|ey;.mOG]";

    static DirContext ctx = null;

    DirContext getSchema(String name) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13725().getSchema(name));
    }
}
