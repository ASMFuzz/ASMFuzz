import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_7552 {

    static String name = "K`)lO(K<Q|";

    static DirContext ctx = null;

    NameParser getNameParser(String name) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7552().getNameParser(name));
    }
}
