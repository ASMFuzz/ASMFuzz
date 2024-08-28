import java.io.*;
import java.util.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class MyJVMTest_5366 {

    static Random rand = null;

    static int max = 6;

    static int limit = 9;

    static int count = 0;

    boolean hasNext() {
        return count < limit;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5366().hasNext());
    }
}
