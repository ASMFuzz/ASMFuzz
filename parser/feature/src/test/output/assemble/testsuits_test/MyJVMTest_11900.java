import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_11900 {

    static String oldName = "XZQi1%DWT?";

    static String newName = "QMYsvu<l3u";

    static DirContext ctx = null;

    String rename(String oldName, String newName) throws NamingException {
        throw new OperationNotSupportedException();
        return oldName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11900().rename(oldName, newName);
    }
}
