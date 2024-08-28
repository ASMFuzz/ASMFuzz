import java.io.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_8177 {

    static String msg = "pCLM3;gEn(";

    static int passed = 0, failed = 0;

    String pass(String msg) {
        System.out.println(msg);
        passed++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8177().pass(msg);
    }
}
