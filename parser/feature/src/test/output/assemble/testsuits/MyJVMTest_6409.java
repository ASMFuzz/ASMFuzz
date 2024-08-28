import java.util.*;
import java.util.zip.*;
import java.util.jar.*;
import java.io.*;

public class MyJVMTest_6409 {

    static int length = 2;

    static String name = "!;l@|X(~L]";

    static int method = 8;

    static byte[] data = {-15,-94,104,-88,-127,95,-26,-104,-58,-27};

    static byte[] extra = {33,-36,81,-124,-58,112,22,-87,-43,-40};

    static String comment = "-=uOE]#L0\\";

    static Random random = new Random();

    String makeName(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) sb.append((char) (random.nextInt(10000) + 1));
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6409().makeName(length));
    }
}
