import java.io.*;

public class MyJVMTest_11995 {

    static boolean b = true;

    static boolean val = true;

    static long field = 0;

    static int iterations = 3;

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
        new MyJVMTest_11995().printMe(b, val, field);
    }
}
