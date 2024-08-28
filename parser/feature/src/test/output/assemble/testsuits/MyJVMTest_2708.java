import java.io.*;

public class MyJVMTest_2708 {

    static boolean b = false;

    static boolean val = false;

    static long field = 0;

    static int iterations = 2;

    long printMe(boolean b, boolean val, long field) {
        if (b) {
            if (val)
                System.out.print("its even ");
            else
                System.out.print("its odd ");
            System.out.println(field);
        }
        return field;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2708().printMe(b, val, field);
    }
}
