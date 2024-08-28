import java.util.*;
import java.util.zip.*;
import java.util.jar.*;
import java.io.*;

public class MyJVMTest_15893 {

    static int length = -1773056564;

    static String name = "R!Sl iA1;p";

    static int method = 0;

    static byte[] data = {-26,63,-109,124,60,-65,-128,44,14,127};

    static byte[] extra = {-66,-99,-19,62,-47,-109,-113,0,-87,-52};

    static String comment = "[n3V_gOz:S";

    static Random random = new Random();

    String makeName(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) sb.append((char) (random.nextInt(10000) + 1));
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15893().makeName(length));
    }
}
