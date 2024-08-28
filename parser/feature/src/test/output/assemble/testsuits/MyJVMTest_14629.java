import java.io.*;
import java.util.*;
import java.security.*;

public class MyJVMTest_14629 {

    static String s = ":$gtf.x|9l";

    static String alg = "PbB\\,AO#hp";

    static byte[] data = {-100,58,35,109,-126,-5,69,-43,-105,-61};

    static byte[] digest = {112,13,23,-52,58,-55,-119,58,-20,42};

    static byte[] ALONG = {-71,64,-23,-14,56,-28,23,-70,29,98}, BLONG = {29,116,51,79,-103,5,-119,-106,94,120};

    byte[] s(String s) {
        try {
            return s.getBytes("UTF8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_14629().s(s)));
    }
}
