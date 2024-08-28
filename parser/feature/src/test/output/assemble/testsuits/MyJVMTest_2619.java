import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_2619 {

    static String oldName = "8P9?L^[s%O";

    static String newName = " <9jm:VN1r";

    static DirContext ctx = null;

    String rename(String oldName, String newName) throws NamingException {
        throw new OperationNotSupportedException();
        return oldName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2619().rename(oldName, newName);
    }
}
