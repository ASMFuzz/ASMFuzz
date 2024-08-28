import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_16779 {

    static Name name = null;

    static Name newName = null;

    static DirContext ctx = null;

    Name rename(Name name, Name newName) throws NamingException {
        throw new OperationNotSupportedException();
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16779().rename(name, newName);
    }
}
