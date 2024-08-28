import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_17094 {

    static String name = "+D>SZt2cj,";

    static DirContext ctx = null;

    NameParser getNameParser(String name) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17094().getNameParser(name));
    }
}
