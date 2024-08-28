import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class MyJVMTest_6507 {

    static String csn = "oZiM)]kp'`";

    static long t = 0;

    long checkInit(String csn) throws Exception {
        System.out.printf("Check init <%s>...%n", csn);
        Charset.forName("Big5");
        long t1 = System.nanoTime() / 1000;
        Charset cs = Charset.forName(csn);
        long t2 = System.nanoTime() / 1000;
        System.out.printf("    charset     :%d%n", t2 - t1);
        t1 = System.nanoTime() / 1000;
        cs.newDecoder();
        t2 = System.nanoTime() / 1000;
        System.out.printf("    new Decoder :%d%n", t2 - t1);
        t1 = System.nanoTime() / 1000;
        cs.newEncoder();
        t2 = System.nanoTime() / 1000;
        System.out.printf("    new Encoder :%d%n", t2 - t1);
        return t2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6507().checkInit(csn);
    }
}
