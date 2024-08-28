import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_8191 {

    static String name = "nE#&=85? N";

    static DirContext ctx = null;

    NamingEnumeration<NameClassPair> list(String name) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8191().list(name));
    }
}
