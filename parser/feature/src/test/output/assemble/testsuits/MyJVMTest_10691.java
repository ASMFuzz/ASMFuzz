import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_10691 {

    static Name name = null;

    static DirContext ctx = null;

    Name destroySubcontext(Name name) throws NamingException {
        throw new OperationNotSupportedException();
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10691().destroySubcontext(name);
    }
}
