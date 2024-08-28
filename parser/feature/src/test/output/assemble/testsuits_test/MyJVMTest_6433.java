import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_6433 {

    static String name = "pXo)og7]? ";

    static String[] attrIds = { "\"<q87ZWxoO", "={_ksFb2Ft", "+1nfMIH;qJ", "xE*J)+FhD?", "@SI:%5$HS9", "75lr@e^K>,", "~]-+@DYH=&", ";0J#xM$P K", "t%$cv3s-zv", "#d<~poa+`[" };

    static DirContext ctx = null;

    Attributes getAttributes(String name, String[] attrIds) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6433().getAttributes(name, attrIds));
    }
}
