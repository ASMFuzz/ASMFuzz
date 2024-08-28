import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;

public class MyJVMTest_12470 {

    static int max = 7;

    static int cur = -1;

    boolean hasNext() {
        return cur < max;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12470().hasNext());
    }
}
