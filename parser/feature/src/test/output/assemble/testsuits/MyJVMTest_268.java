import java.util.*;
import java.lang.reflect.*;

public class MyJVMTest_268 {

    static int x = 1988925076;

    static int[] testValues = {5,5,1,0,0,-393962319,0,0,4,0};

    Integer coerceToInteger(int x) {
        return (x == 0) ? null : x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_268().coerceToInteger(x));
    }
}
