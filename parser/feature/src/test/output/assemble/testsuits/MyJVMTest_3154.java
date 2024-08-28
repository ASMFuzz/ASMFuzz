import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;

public class MyJVMTest_3154 {

    static int max = 4;

    static int cur = -1;

    boolean hasNext() {
        return cur < max;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3154().hasNext());
    }
}
