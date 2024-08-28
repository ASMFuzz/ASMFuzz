import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_4351 {

    static String name = "idxefkTd1P";

    static DirContext ctx = null;

    DirContext getSchema(String name) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4351().getSchema(name));
    }
}
