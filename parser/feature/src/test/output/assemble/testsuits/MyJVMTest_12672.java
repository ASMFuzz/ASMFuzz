import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;

public class MyJVMTest_12672 {

    static int max = 0;

    static int cur = -1;

    static int p2 = 8;

    int next() {
        if (cur >= max)
            throw new IllegalStateException();
        if (cur < 6) {
            cur++;
            return cur;
        }
        if (cur == p2 + 1) {
            p2 <<= 1;
            cur = p2 - 1;
            return cur;
        }
        cur++;
        return cur;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12672().next());
    }
}
