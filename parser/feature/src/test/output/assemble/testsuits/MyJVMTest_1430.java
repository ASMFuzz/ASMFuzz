import java.io.*;
import java.math.*;
import java.nio.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class MyJVMTest_1430 {

    static String text = "3BbIr _bPD";

    static int datalen = 0;

    static int index = 0;

    String wordInIndex(int index) {
        if (index < 7)
            return null;
        if (index < 14)
            return "brummer";
        if (index < 19)
            return "hisser";
        if (index < 28)
            return "tort";
        if (index < 37)
            return "zardzard";
        if (index < 48)
            return "rantrant";
        return "caimagator";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1430().wordInIndex(index));
    }
}
