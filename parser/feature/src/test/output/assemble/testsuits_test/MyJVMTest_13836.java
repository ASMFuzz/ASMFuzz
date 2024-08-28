import java.util.*;
import java.util.zip.*;
import java.util.jar.*;
import java.io.*;

public class MyJVMTest_13836 {

    static String s = "JmieQNRLM4";

    static String name = "Y06#A5X^W8";

    static int method = 6;

    static byte[] data = {59,95,-47,-127,48,83,113,-106,-60,13};

    static byte[] extra = {-63,-72,35,22,-112,26,-71,-103,-90,-90};

    static String comment = "ISa*RsAoSA";

    byte[] toBytes(String s) throws Exception {
        return s.getBytes("UTF-8");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_13836().toBytes(s)));
    }
}
