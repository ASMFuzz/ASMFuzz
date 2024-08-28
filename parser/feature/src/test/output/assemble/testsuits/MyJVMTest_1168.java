import java.io.*;

public class MyJVMTest_1168 {

    static String msg = "xdN7s7\\U.E";

    static byte[] orig = {-77,83,-67,-82,21,-34,-10,64,-123,-106};

    static byte[] sdeAttr = {-95,99,68,79,105,4,-54,57,89,103};

    static byte[] gen = {-23,-5,123,-79,117,-39,94,-117,-122,27};

    static int genPos = 0;

    String abort(String msg) {
        System.err.println(msg);
        System.exit(1);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1168().abort(msg);
    }
}
