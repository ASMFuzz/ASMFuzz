import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_969 {

    static Name name = null;

    static Object obj = 0;

    static DirContext ctx = null;

    Name rebind(Name name, Object obj) throws NamingException {
        throw new OperationNotSupportedException();
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_969().rebind(name, obj);
    }
}
