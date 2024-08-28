import java.io.*;
import java.net.URI;

public class MyJVMTest_2059 {

    static String dirParam1Param1 = "mQLZOFxZ$s";

    static String dirParam1Param2 = "!.|\\$4!Odq";

    static String dirParam1Param3 = "/!N[eNzz'K";

    static String dirParam1Param4 = "fx8f4[wi-^";

    static String dirParam1Param5 = "&Z/aX\"@|P4";

    static URI dirParam1 = new URI(dirParam1Param1, dirParam1Param2, dirParam1Param3, dirParam1Param4, dirParam1Param5);

    static File dir = new File(dirParam1);

    static String name = "]-,]q7{>8m";

    boolean accept(File dir, String name) {
        return name.endsWith(".class");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2059().accept(dir, name));
    }
}
