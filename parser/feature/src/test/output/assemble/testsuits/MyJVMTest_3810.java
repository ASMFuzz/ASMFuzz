import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import static java.util.Collections.*;

public class MyJVMTest_3810 {

    static int n = 1;

    static Random rnd = new Random();

    boolean maybe(int n) {
        return rnd.nextInt(n) == 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3810().maybe(n));
    }
}
