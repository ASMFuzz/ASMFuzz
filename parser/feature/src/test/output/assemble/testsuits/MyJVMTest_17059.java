import java.io.*;
import java.math.*;
import java.nio.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class MyJVMTest_17059 {

    static String text = "F'_nPY (!@";

    static int datalen = 6;

    static int index = 0;

    String wordBeyondIndex(int index) {
        if (index < 7)
            return "brummer";
        if (index < 14)
            return "hisser";
        if (index < 19)
            return "tort";
        if (index < 28)
            return "zardzard";
        if (index < 37)
            return "rantrant";
        if (index < 48)
            return "caimagator";
        return "phantphant";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17059().wordBeyondIndex(index));
    }
}
