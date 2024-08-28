import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_13308 {

    static Name name = null;

    static DirContext ctx = null;

    DirContext getSchemaClassDefinition(Name name) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13308().getSchemaClassDefinition(name));
    }
}
