import java.io.*;
import java.math.*;
import java.nio.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class MyJVMTest_16372 {

    static String text = "!dt|@9?JI*";

    static int datalen = -414948990;

    void example1() throws Exception {
        Scanner s = new Scanner("1 fish 2 fish red fish blue fish");
        s.useDelimiter("\\s*fish\\s*");
        List<String> results = new ArrayList<String>();
        while (s.hasNext()) results.add(s.next());
        System.out.println(results);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16372().example1();
    }
}
