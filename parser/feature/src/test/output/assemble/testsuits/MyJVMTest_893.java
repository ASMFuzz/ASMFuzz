import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_893 {

    static String name = "ZFM;W~I1\"/";

    static DirContext ctx = null;

    Object lookupLink(String name) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_893().lookupLink(name));
    }
}
