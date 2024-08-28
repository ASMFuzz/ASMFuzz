import java.io.*;

public class MyJVMTest_4526 {

    static int len = 7;

    static int chunk = 0;

    static int count = 0;

    int available() {
        int remaining = len - count;
        return (remaining > chunk) ? chunk : remaining;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4526().available());
    }
}
