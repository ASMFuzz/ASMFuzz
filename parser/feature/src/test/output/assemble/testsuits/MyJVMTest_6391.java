import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_6391 {

    static Name name = null;

    static Name prefix = null;

    static DirContext ctx = null;

    Name composeName(Name name, Name prefix) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6391().composeName(name, prefix));
    }
}
