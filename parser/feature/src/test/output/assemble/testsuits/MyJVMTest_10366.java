import java.io.*;

public class MyJVMTest_10366 {

    static String msg = "@1^1;I/H?d";

    static byte[] orig = {18,82,-2,35,-101,68,125,-10,-10,-121};

    static byte[] sdeAttr = {-97,65,54,-8,-120,45,-110,62,-117,-49};

    static byte[] gen = {106,-53,-7,-21,106,33,-78,100,4,-59};

    static int genPos = 0;

    String abort(String msg) {
        System.err.println(msg);
        System.exit(1);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10366().abort(msg);
    }
}
