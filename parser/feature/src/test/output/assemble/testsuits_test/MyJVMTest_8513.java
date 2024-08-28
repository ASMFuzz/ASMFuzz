import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_8513 {

    static Name name = null;

    static Object obj = 891953461;

    static DirContext ctx = null;

    Name bind(Name name, Object obj) throws NamingException {
        throw new OperationNotSupportedException();
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8513().bind(name, obj);
    }
}
